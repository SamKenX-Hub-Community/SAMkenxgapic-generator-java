/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.showcase.v1beta1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Empty;
import com.google.showcase.v1beta1.stub.IdentityStub;
import com.google.showcase.v1beta1.stub.IdentityStubSettings;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: A simple identity service.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (IdentityClient identityClient = IdentityClient.create()) {
 *   String displayName = "displayName1714148973";
 *   String email = "email96619420";
 *   User response = identityClient.createUser(displayName, email);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the IdentityClient object to clean up resources such as
 * threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <p>The surface of this class includes several types of Java methods for each of the API's
 * methods:
 *
 * <ol>
 *   <li>A "flattened" method. With this type of method, the fields of the request type have been
 *       converted into function parameters. It may be the case that not all fields are available as
 *       parameters, and not every API method will have a flattened method entry point.
 *   <li>A "request object" method. This type of method only takes one parameter, a request object,
 *       which must be constructed before the call. Not every API method will have a request object
 *       method.
 *   <li>A "callable" method. This type of method takes no parameters and returns an immutable API
 *       callable object, which can be used to initiate calls to the service.
 * </ol>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of IdentitySettings to create().
 * For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * IdentitySettings identitySettings =
 *     IdentitySettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * IdentityClient identityClient = IdentityClient.create(identitySettings);
 * }</pre>
 *
 * <p>To customize the endpoint:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * IdentitySettings identitySettings =
 *     IdentitySettings.newBuilder().setEndpoint(myEndpoint).build();
 * IdentityClient identityClient = IdentityClient.create(identitySettings);
 * }</pre>
 *
 * <p>To use REST (HTTP1.1/JSON) transport (instead of gRPC) for sending and receiving requests over
 * the wire:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * IdentitySettings identitySettings = IdentitySettings.newHttpJsonBuilder().build();
 * IdentityClient identityClient = IdentityClient.create(identitySettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class IdentityClient implements BackgroundResource {
  private final IdentitySettings settings;
  private final IdentityStub stub;

  /** Constructs an instance of IdentityClient with default settings. */
  public static final IdentityClient create() throws IOException {
    return create(IdentitySettings.newBuilder().build());
  }

  /**
   * Constructs an instance of IdentityClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final IdentityClient create(IdentitySettings settings) throws IOException {
    return new IdentityClient(settings);
  }

  /**
   * Constructs an instance of IdentityClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(IdentitySettings).
   */
  public static final IdentityClient create(IdentityStub stub) {
    return new IdentityClient(stub);
  }

  /**
   * Constructs an instance of IdentityClient, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected IdentityClient(IdentitySettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((IdentityStubSettings) settings.getStubSettings()).createStub();
  }

  protected IdentityClient(IdentityStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final IdentitySettings getSettings() {
    return settings;
  }

  public IdentityStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a user.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IdentityClient identityClient = IdentityClient.create()) {
   *   String displayName = "displayName1714148973";
   *   String email = "email96619420";
   *   User response = identityClient.createUser(displayName, email);
   * }
   * }</pre>
   *
   * @param displayName The display_name of the user.
   * @param email The email address of the user.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final User createUser(String displayName, String email) {
    CreateUserRequest request =
        CreateUserRequest.newBuilder()
            .setUser(User.newBuilder().setDisplayName(displayName).setEmail(email).build())
            .build();
    return createUser(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a user.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IdentityClient identityClient = IdentityClient.create()) {
   *   String displayName = "displayName1714148973";
   *   String email = "email96619420";
   *   int age = 96511;
   *   String nickname = "nickname70690926";
   *   boolean enableNotifications = true;
   *   double heightFeet = -1032737338;
   *   User response =
   *       identityClient.createUser(
   *           displayName, email, age, nickname, enableNotifications, heightFeet);
   * }
   * }</pre>
   *
   * @param displayName The display_name of the user.
   * @param email The email address of the user.
   * @param age The age of the user in years.
   * @param nickname The nickname of the user.
   *     <p>(-- aip.dev/not-precedent: An empty string is a valid nickname. Ordinarily,
   *     proto3_optional should not be used on a `string` field. --)
   * @param enableNotifications Enables the receiving of notifications. The default is true if
   *     unset.
   *     <p>(-- aip.dev/not-precedent: The default for the feature is true. Ordinarily, the default
   *     for a `bool` field should be false. --)
   * @param heightFeet The height of the user in feet.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final User createUser(
      String displayName,
      String email,
      int age,
      String nickname,
      boolean enableNotifications,
      double heightFeet) {
    CreateUserRequest request =
        CreateUserRequest.newBuilder()
            .setUser(
                User.newBuilder()
                    .setDisplayName(displayName)
                    .setEmail(email)
                    .setAge(age)
                    .setNickname(nickname)
                    .setEnableNotifications(enableNotifications)
                    .setHeightFeet(heightFeet)
                    .build())
            .build();
    return createUser(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a user.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IdentityClient identityClient = IdentityClient.create()) {
   *   CreateUserRequest request =
   *       CreateUserRequest.newBuilder().setUser(User.newBuilder().build()).build();
   *   User response = identityClient.createUser(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final User createUser(CreateUserRequest request) {
    return createUserCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a user.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IdentityClient identityClient = IdentityClient.create()) {
   *   CreateUserRequest request =
   *       CreateUserRequest.newBuilder().setUser(User.newBuilder().build()).build();
   *   ApiFuture<User> future = identityClient.createUserCallable().futureCall(request);
   *   // Do something.
   *   User response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateUserRequest, User> createUserCallable() {
    return stub.createUserCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the User with the given uri.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IdentityClient identityClient = IdentityClient.create()) {
   *   UserName name = UserName.of("[USER]");
   *   User response = identityClient.getUser(name);
   * }
   * }</pre>
   *
   * @param name The resource name of the requested user.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final User getUser(UserName name) {
    GetUserRequest request =
        GetUserRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getUser(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the User with the given uri.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IdentityClient identityClient = IdentityClient.create()) {
   *   String name = UserName.of("[USER]").toString();
   *   User response = identityClient.getUser(name);
   * }
   * }</pre>
   *
   * @param name The resource name of the requested user.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final User getUser(String name) {
    GetUserRequest request = GetUserRequest.newBuilder().setName(name).build();
    return getUser(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the User with the given uri.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IdentityClient identityClient = IdentityClient.create()) {
   *   GetUserRequest request =
   *       GetUserRequest.newBuilder().setName(UserName.of("[USER]").toString()).build();
   *   User response = identityClient.getUser(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final User getUser(GetUserRequest request) {
    return getUserCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the User with the given uri.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IdentityClient identityClient = IdentityClient.create()) {
   *   GetUserRequest request =
   *       GetUserRequest.newBuilder().setName(UserName.of("[USER]").toString()).build();
   *   ApiFuture<User> future = identityClient.getUserCallable().futureCall(request);
   *   // Do something.
   *   User response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetUserRequest, User> getUserCallable() {
    return stub.getUserCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a user.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IdentityClient identityClient = IdentityClient.create()) {
   *   UpdateUserRequest request =
   *       UpdateUserRequest.newBuilder()
   *           .setUser(User.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   User response = identityClient.updateUser(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final User updateUser(UpdateUserRequest request) {
    return updateUserCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a user.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IdentityClient identityClient = IdentityClient.create()) {
   *   UpdateUserRequest request =
   *       UpdateUserRequest.newBuilder()
   *           .setUser(User.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<User> future = identityClient.updateUserCallable().futureCall(request);
   *   // Do something.
   *   User response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateUserRequest, User> updateUserCallable() {
    return stub.updateUserCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a user, their profile, and all of their authored messages.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IdentityClient identityClient = IdentityClient.create()) {
   *   UserName name = UserName.of("[USER]");
   *   identityClient.deleteUser(name);
   * }
   * }</pre>
   *
   * @param name The resource name of the user to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteUser(UserName name) {
    DeleteUserRequest request =
        DeleteUserRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteUser(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a user, their profile, and all of their authored messages.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IdentityClient identityClient = IdentityClient.create()) {
   *   String name = UserName.of("[USER]").toString();
   *   identityClient.deleteUser(name);
   * }
   * }</pre>
   *
   * @param name The resource name of the user to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteUser(String name) {
    DeleteUserRequest request = DeleteUserRequest.newBuilder().setName(name).build();
    deleteUser(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a user, their profile, and all of their authored messages.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IdentityClient identityClient = IdentityClient.create()) {
   *   DeleteUserRequest request =
   *       DeleteUserRequest.newBuilder().setName(UserName.of("[USER]").toString()).build();
   *   identityClient.deleteUser(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteUser(DeleteUserRequest request) {
    deleteUserCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a user, their profile, and all of their authored messages.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IdentityClient identityClient = IdentityClient.create()) {
   *   DeleteUserRequest request =
   *       DeleteUserRequest.newBuilder().setName(UserName.of("[USER]").toString()).build();
   *   ApiFuture<Empty> future = identityClient.deleteUserCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteUserRequest, Empty> deleteUserCallable() {
    return stub.deleteUserCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all users.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IdentityClient identityClient = IdentityClient.create()) {
   *   ListUsersRequest request =
   *       ListUsersRequest.newBuilder()
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (User element : identityClient.listUsers(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListUsersPagedResponse listUsers(ListUsersRequest request) {
    return listUsersPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all users.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IdentityClient identityClient = IdentityClient.create()) {
   *   ListUsersRequest request =
   *       ListUsersRequest.newBuilder()
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<User> future = identityClient.listUsersPagedCallable().futureCall(request);
   *   // Do something.
   *   for (User element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListUsersRequest, ListUsersPagedResponse> listUsersPagedCallable() {
    return stub.listUsersPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all users.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IdentityClient identityClient = IdentityClient.create()) {
   *   ListUsersRequest request =
   *       ListUsersRequest.newBuilder()
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListUsersResponse response = identityClient.listUsersCallable().call(request);
   *     for (User element : response.getUsersList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListUsersRequest, ListUsersResponse> listUsersCallable() {
    return stub.listUsersCallable();
  }

  @Override
  public final void close() {
    stub.close();
  }

  @Override
  public void shutdown() {
    stub.shutdown();
  }

  @Override
  public boolean isShutdown() {
    return stub.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    return stub.isTerminated();
  }

  @Override
  public void shutdownNow() {
    stub.shutdownNow();
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return stub.awaitTermination(duration, unit);
  }

  public static class ListUsersPagedResponse
      extends AbstractPagedListResponse<
          ListUsersRequest, ListUsersResponse, User, ListUsersPage, ListUsersFixedSizeCollection> {

    public static ApiFuture<ListUsersPagedResponse> createAsync(
        PageContext<ListUsersRequest, ListUsersResponse, User> context,
        ApiFuture<ListUsersResponse> futureResponse) {
      ApiFuture<ListUsersPage> futurePage =
          ListUsersPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListUsersPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListUsersPagedResponse(ListUsersPage page) {
      super(page, ListUsersFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListUsersPage
      extends AbstractPage<ListUsersRequest, ListUsersResponse, User, ListUsersPage> {

    private ListUsersPage(
        PageContext<ListUsersRequest, ListUsersResponse, User> context,
        ListUsersResponse response) {
      super(context, response);
    }

    private static ListUsersPage createEmptyPage() {
      return new ListUsersPage(null, null);
    }

    @Override
    protected ListUsersPage createPage(
        PageContext<ListUsersRequest, ListUsersResponse, User> context,
        ListUsersResponse response) {
      return new ListUsersPage(context, response);
    }

    @Override
    public ApiFuture<ListUsersPage> createPageAsync(
        PageContext<ListUsersRequest, ListUsersResponse, User> context,
        ApiFuture<ListUsersResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListUsersFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListUsersRequest, ListUsersResponse, User, ListUsersPage, ListUsersFixedSizeCollection> {

    private ListUsersFixedSizeCollection(List<ListUsersPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListUsersFixedSizeCollection createEmptyCollection() {
      return new ListUsersFixedSizeCollection(null, 0);
    }

    @Override
    protected ListUsersFixedSizeCollection createCollection(
        List<ListUsersPage> pages, int collectionSize) {
      return new ListUsersFixedSizeCollection(pages, collectionSize);
    }
  }
}
