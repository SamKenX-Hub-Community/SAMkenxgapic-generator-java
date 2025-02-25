/*
 * Copyright 2017 Google LLC
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *     * Neither the name of Google LLC nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.google.api.gax.grpc;

import com.google.api.core.InternalApi;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ForwardingClientCall.SimpleForwardingClientCall;
import io.grpc.ForwardingClientCallListener.SimpleForwardingClientCallListener;
import io.grpc.ManagedChannel;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import org.threeten.bp.Duration;

/**
 * A {@link ManagedChannel} that will send requests round-robin via a set of channels.
 *
 * <p>In addition to spreading requests over a set of child connections, the pool will also actively
 * manage the lifecycle of the channels. Currently lifecycle management is limited to pre-emptively
 * replacing channels every hour. In the future it will dynamically size the pool based on number of
 * outstanding requests.
 *
 * <p>Package-private for internal use.
 */
class ChannelPool extends ManagedChannel {
  private static final Logger LOG = Logger.getLogger(ChannelPool.class.getName());
  private static final Duration REFRESH_PERIOD = Duration.ofMinutes(50);

  private final ChannelPoolSettings settings;
  private final ChannelFactory channelFactory;
  private final ScheduledExecutorService executor;

  private final Object entryWriteLock = new Object();
  @VisibleForTesting final AtomicReference<ImmutableList<Entry>> entries = new AtomicReference<>();
  private final AtomicInteger indexTicker = new AtomicInteger();
  private final String authority;

  static ChannelPool create(ChannelPoolSettings settings, ChannelFactory channelFactory)
      throws IOException {
    return new ChannelPool(settings, channelFactory, Executors.newSingleThreadScheduledExecutor());
  }

  /**
   * Initializes the channel pool. Assumes that all channels have the same authority.
   *
   * @param settings options for controling the ChannelPool sizing behavior
   * @param channelFactory method to create the channels
   * @param executor periodically refreshes the channels
   */
  @VisibleForTesting
  ChannelPool(
      ChannelPoolSettings settings,
      ChannelFactory channelFactory,
      ScheduledExecutorService executor)
      throws IOException {
    this.settings = settings;
    this.channelFactory = channelFactory;

    ImmutableList.Builder<Entry> initialListBuilder = ImmutableList.builder();

    for (int i = 0; i < settings.getInitialChannelCount(); i++) {
      initialListBuilder.add(new Entry(channelFactory.createSingleChannel()));
    }

    entries.set(initialListBuilder.build());
    authority = entries.get().get(0).channel.authority();
    this.executor = executor;

    if (!settings.isStaticSize()) {
      executor.scheduleAtFixedRate(
          this::resizeSafely,
          ChannelPoolSettings.RESIZE_INTERVAL.getSeconds(),
          ChannelPoolSettings.RESIZE_INTERVAL.getSeconds(),
          TimeUnit.SECONDS);
    }
    if (settings.isPreemptiveRefreshEnabled()) {
      executor.scheduleAtFixedRate(
          this::refreshSafely,
          REFRESH_PERIOD.getSeconds(),
          REFRESH_PERIOD.getSeconds(),
          TimeUnit.SECONDS);
    }
  }

  /** {@inheritDoc} */
  @Override
  public String authority() {
    return authority;
  }

  /**
   * Create a {@link ClientCall} on a Channel from the pool chosen in a round-robin fashion to the
   * remote operation specified by the given {@link MethodDescriptor}. The returned {@link
   * ClientCall} does not trigger any remote behavior until {@link
   * ClientCall#start(ClientCall.Listener, io.grpc.Metadata)} is invoked.
   */
  @Override
  public <ReqT, RespT> ClientCall<ReqT, RespT> newCall(
      MethodDescriptor<ReqT, RespT> methodDescriptor, CallOptions callOptions) {
    return getChannel(indexTicker.getAndIncrement()).newCall(methodDescriptor, callOptions);
  }

  Channel getChannel(int affinity) {
    return new AffinityChannel(affinity);
  }

  /** {@inheritDoc} */
  @Override
  public ManagedChannel shutdown() {
    List<Entry> localEntries = entries.get();
    for (Entry entry : localEntries) {
      entry.channel.shutdown();
    }
    if (executor != null) {
      // shutdownNow will cancel scheduled tasks
      executor.shutdownNow();
    }
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public boolean isShutdown() {
    List<Entry> localEntries = entries.get();
    for (Entry entry : localEntries) {
      if (!entry.channel.isShutdown()) {
        return false;
      }
    }
    return executor == null || executor.isShutdown();
  }

  /** {@inheritDoc} */
  @Override
  public boolean isTerminated() {
    List<Entry> localEntries = entries.get();
    for (Entry entry : localEntries) {
      if (!entry.channel.isTerminated()) {
        return false;
      }
    }

    return executor == null || executor.isTerminated();
  }

  /** {@inheritDoc} */
  @Override
  public ManagedChannel shutdownNow() {
    List<Entry> localEntries = entries.get();
    for (Entry entry : localEntries) {
      entry.channel.shutdownNow();
    }
    if (executor != null) {
      executor.shutdownNow();
    }
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
    long endTimeNanos = System.nanoTime() + unit.toNanos(timeout);
    List<Entry> localEntries = entries.get();
    for (Entry entry : localEntries) {
      long awaitTimeNanos = endTimeNanos - System.nanoTime();
      if (awaitTimeNanos <= 0) {
        break;
      }
      entry.channel.awaitTermination(awaitTimeNanos, TimeUnit.NANOSECONDS);
    }
    if (executor != null) {
      long awaitTimeNanos = endTimeNanos - System.nanoTime();
      executor.awaitTermination(awaitTimeNanos, TimeUnit.NANOSECONDS);
    }
    return isTerminated();
  }

  private void resizeSafely() {
    try {
      synchronized (entryWriteLock) {
        resize();
      }
    } catch (Exception e) {
      LOG.log(Level.WARNING, "Failed to resize channel pool", e);
    }
  }

  /**
   * Resize the number of channels based on the number of outstanding RPCs.
   *
   * <p>This method is expected to be called on a fixed interval. On every invocation it will:
   *
   * <ul>
   *   <li>Get the maximum number of outstanding RPCs since last invocation
   *   <li>Determine a valid range of number of channels to handle that many outstanding RPCs
   *   <li>If the current number of channel falls outside of that range, add or remove at most
   *       {@link ChannelPoolSettings#MAX_RESIZE_DELTA} to get closer to middle of that range.
   * </ul>
   *
   * <p>Not threadsafe, must be called under the entryWriteLock monitor
   */
  @VisibleForTesting
  void resize() {
    List<Entry> localEntries = entries.get();
    // Estimate the peak of RPCs in the last interval by summing the peak of RPCs per channel
    int actualOutstandingRpcs =
        localEntries.stream().mapToInt(Entry::getAndResetMaxOutstanding).sum();

    // Number of channels if each channel operated at max capacity
    int minChannels =
        (int) Math.ceil(actualOutstandingRpcs / (double) settings.getMaxRpcsPerChannel());
    // Limit the threshold to absolute range
    if (minChannels < settings.getMinChannelCount()) {
      minChannels = settings.getMinChannelCount();
    }

    // Number of channels if each channel operated at minimum capacity
    // Note: getMinRpcsPerChannel() can return 0, but division by 0 shouldn't cause a problem.
    int maxChannels =
        (int) Math.ceil(actualOutstandingRpcs / (double) settings.getMinRpcsPerChannel());
    // Limit the threshold to absolute range
    if (maxChannels > settings.getMaxChannelCount()) {
      maxChannels = settings.getMaxChannelCount();
    }
    if (maxChannels < minChannels) {
      maxChannels = minChannels;
    }

    // If the pool were to be resized, try to aim for the middle of the bound, but limit rate of
    // change.
    int tentativeTarget = (maxChannels + minChannels) / 2;
    int currentSize = localEntries.size();
    int delta = tentativeTarget - currentSize;
    int dampenedTarget = tentativeTarget;
    if (Math.abs(delta) > ChannelPoolSettings.MAX_RESIZE_DELTA) {
      dampenedTarget =
          currentSize + (int) Math.copySign(ChannelPoolSettings.MAX_RESIZE_DELTA, delta);
    }

    // Only resize the pool when thresholds are crossed
    if (localEntries.size() < minChannels) {
      LOG.fine(
          String.format(
              "Detected throughput peak of %d, expanding channel pool size: %d -> %d.",
              actualOutstandingRpcs, currentSize, dampenedTarget));

      expand(dampenedTarget);
    } else if (localEntries.size() > maxChannels) {
      LOG.fine(
          String.format(
              "Detected throughput drop to %d, shrinking channel pool size: %d -> %d.",
              actualOutstandingRpcs, currentSize, dampenedTarget));

      shrink(dampenedTarget);
    }
  }

  /** Not threadsafe, must be called under the entryWriteLock monitor */
  private void shrink(int desiredSize) {
    ImmutableList<Entry> localEntries = entries.get();
    Preconditions.checkState(
        localEntries.size() >= desiredSize, "current size is already smaller than the desired");

    // Set the new list
    entries.set(localEntries.subList(0, desiredSize));
    // clean up removed entries
    List<Entry> removed = localEntries.subList(desiredSize, localEntries.size());
    removed.forEach(Entry::requestShutdown);
  }

  /** Not threadsafe, must be called under the entryWriteLock monitor */
  private void expand(int desiredSize) {
    List<Entry> localEntries = entries.get();
    Preconditions.checkState(
        localEntries.size() <= desiredSize, "current size is already bigger than the desired");

    ImmutableList.Builder<Entry> newEntries = ImmutableList.<Entry>builder().addAll(localEntries);

    for (int i = 0; i < desiredSize - localEntries.size(); i++) {
      try {
        newEntries.add(new Entry(channelFactory.createSingleChannel()));
      } catch (IOException e) {
        LOG.log(Level.WARNING, "Failed to add channel", e);
      }
    }

    entries.set(newEntries.build());
  }

  private void refreshSafely() {
    try {
      refresh();
    } catch (Exception e) {
      LOG.log(Level.WARNING, "Failed to pre-emptively refresh channnels", e);
    }
  }

  /**
   * Replace all of the channels in the channel pool with fresh ones. This is meant to mitigate the
   * hourly GFE disconnects by giving clients the ability to prime the channel on reconnect.
   *
   * <p>This is done on a best effort basis. If the replacement channel fails to construct, the old
   * channel will continue to be used.
   */
  @InternalApi("Visible for testing")
  void refresh() {
    // Note: synchronization is necessary in case refresh is called concurrently:
    // - thread1 fails to replace a single entry
    // - thread2 succeeds replacing an entry
    // - thread1 loses the race to replace the list
    // - then thread2 will shut down channel that thread1 will put back into circulation (after it
    //   replaces the list)
    synchronized (entryWriteLock) {
      ArrayList<Entry> newEntries = new ArrayList<>(entries.get());

      for (int i = 0; i < newEntries.size(); i++) {
        try {
          newEntries.set(i, new Entry(channelFactory.createSingleChannel()));
        } catch (IOException e) {
          LOG.log(Level.WARNING, "Failed to refresh channel, leaving old channel", e);
        }
      }

      ImmutableList<Entry> replacedEntries = entries.getAndSet(ImmutableList.copyOf(newEntries));

      // Shutdown the channels that were cycled out.
      for (Entry e : replacedEntries) {
        if (!newEntries.contains(e)) {
          e.requestShutdown();
        }
      }
    }
  }

  /**
   * Get and retain a Channel Entry. The returned Entry will have its rpc count incremented,
   * preventing it from getting recycled.
   */
  Entry getRetainedEntry(int affinity) {
    // The maximum number of concurrent calls to this method for any given time span is at most 2,
    // so the loop can actually be 2 times. But going for 5 times for a safety margin for potential
    // code evolving
    for (int i = 0; i < 5; i++) {
      Entry entry = getEntry(affinity);
      if (entry.retain()) {
        return entry;
      }
    }
    // It is unlikely to reach here unless the pool code evolves to increase the maximum possible
    // concurrent calls to this method. If it does, this is a bug in the channel pool implementation
    // the number of retries above should be greater than the number of contending maintenance
    // tasks.
    throw new IllegalStateException("Bug: failed to retain a channel");
  }

  /**
   * Returns one of the channels managed by this pool. The pool continues to "own" the channel, and
   * the caller should not shut it down.
   *
   * @param affinity Two calls to this method with the same affinity returns the same channel most
   *     of the time, if the channel pool was refreshed since the last call, a new channel will be
   *     returned. The reverse is not true: Two calls with different affinities might return the
   *     same channel. However, the implementation should attempt to spread load evenly.
   */
  private Entry getEntry(int affinity) {
    List<Entry> localEntries = entries.get();

    int index = Math.abs(affinity % localEntries.size());

    return localEntries.get(index);
  }

  /** Bundles a gRPC {@link ManagedChannel} with some usage accounting. */
  private static class Entry {
    private final ManagedChannel channel;
    private final AtomicInteger outstandingRpcs = new AtomicInteger(0);
    private final AtomicInteger maxOutstanding = new AtomicInteger();

    // Flag that the channel should be closed once all of the outstanding RPC complete.
    private final AtomicBoolean shutdownRequested = new AtomicBoolean();
    // Flag that the channel has been closed.
    private final AtomicBoolean shutdownInitiated = new AtomicBoolean();

    private Entry(ManagedChannel channel) {
      this.channel = channel;
    }

    int getAndResetMaxOutstanding() {
      return maxOutstanding.getAndSet(outstandingRpcs.get());
    }

    /**
     * Try to increment the outstanding RPC count. The method will return false if the channel is
     * closing and the caller should pick a different channel. If the method returned true, the
     * channel has been successfully retained and it is the responsibility of the caller to release
     * it.
     */
    private boolean retain() {
      // register desire to start RPC
      int currentOutstanding = outstandingRpcs.incrementAndGet();

      // Rough book keeping
      int prevMax = maxOutstanding.get();
      if (currentOutstanding > prevMax) {
        maxOutstanding.incrementAndGet();
      }

      // abort if the channel is closing
      if (shutdownRequested.get()) {
        release();
        return false;
      }
      return true;
    }

    /**
     * Notify the channel that the number of outstanding RPCs has decreased. If shutdown has been
     * previously requested, this method will shutdown the channel if its the last outstanding RPC.
     */
    private void release() {
      int newCount = outstandingRpcs.decrementAndGet();
      if (newCount < 0) {
        throw new IllegalStateException("Bug: reference count is negative!: " + newCount);
      }

      // Must check outstandingRpcs after shutdownRequested (in reverse order of retain()) to ensure
      // mutual exclusion.
      if (shutdownRequested.get() && outstandingRpcs.get() == 0) {
        shutdown();
      }
    }

    /**
     * Request a shutdown. The actual shutdown will be delayed until there are no more outstanding
     * RPCs.
     */
    private void requestShutdown() {
      shutdownRequested.set(true);
      if (outstandingRpcs.get() == 0) {
        shutdown();
      }
    }

    /** Ensure that shutdown is only called once. */
    private void shutdown() {
      if (shutdownInitiated.compareAndSet(false, true)) {
        channel.shutdown();
      }
    }
  }

  /** Thin wrapper to ensure that new calls are properly reference counted. */
  private class AffinityChannel extends Channel {
    private final int affinity;

    public AffinityChannel(int affinity) {
      this.affinity = affinity;
    }

    @Override
    public String authority() {
      return authority;
    }

    @Override
    public <RequestT, ResponseT> ClientCall<RequestT, ResponseT> newCall(
        MethodDescriptor<RequestT, ResponseT> methodDescriptor, CallOptions callOptions) {

      Entry entry = getRetainedEntry(affinity);

      return new ReleasingClientCall<>(entry.channel.newCall(methodDescriptor, callOptions), entry);
    }
  }

  /** ClientCall wrapper that makes sure to decrement the outstanding RPC count on completion. */
  static class ReleasingClientCall<ReqT, RespT> extends SimpleForwardingClientCall<ReqT, RespT> {
    @Nullable private CancellationException cancellationException;
    final Entry entry;

    public ReleasingClientCall(ClientCall<ReqT, RespT> delegate, Entry entry) {
      super(delegate);
      this.entry = entry;
    }

    @Override
    public void start(Listener<RespT> responseListener, Metadata headers) {
      if (cancellationException != null) {
        throw new IllegalStateException("Call is already cancelled", cancellationException);
      }
      try {
        super.start(
            new SimpleForwardingClientCallListener<RespT>(responseListener) {
              @Override
              public void onClose(Status status, Metadata trailers) {
                try {
                  super.onClose(status, trailers);
                } finally {
                  entry.release();
                }
              }
            },
            headers);
      } catch (Exception e) {
        // In case start failed, make sure to release
        entry.release();
        throw e;
      }
    }

    @Override
    public void cancel(@Nullable String message, @Nullable Throwable cause) {
      this.cancellationException = new CancellationException(message);
      super.cancel(message, cause);
    }
  }
}
