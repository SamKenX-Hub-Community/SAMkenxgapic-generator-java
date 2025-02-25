package com.google.showcase.v1beta1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: schema/google/showcase/v1beta1/messaging.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class MessagingGrpc {

  private MessagingGrpc() {}

  public static final String SERVICE_NAME = "google.showcase.v1beta1.Messaging";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.showcase.v1beta1.CreateRoomRequest,
      com.google.showcase.v1beta1.Room> getCreateRoomMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateRoom",
      requestType = com.google.showcase.v1beta1.CreateRoomRequest.class,
      responseType = com.google.showcase.v1beta1.Room.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.showcase.v1beta1.CreateRoomRequest,
      com.google.showcase.v1beta1.Room> getCreateRoomMethod() {
    io.grpc.MethodDescriptor<com.google.showcase.v1beta1.CreateRoomRequest, com.google.showcase.v1beta1.Room> getCreateRoomMethod;
    if ((getCreateRoomMethod = MessagingGrpc.getCreateRoomMethod) == null) {
      synchronized (MessagingGrpc.class) {
        if ((getCreateRoomMethod = MessagingGrpc.getCreateRoomMethod) == null) {
          MessagingGrpc.getCreateRoomMethod = getCreateRoomMethod =
              io.grpc.MethodDescriptor.<com.google.showcase.v1beta1.CreateRoomRequest, com.google.showcase.v1beta1.Room>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateRoom"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.showcase.v1beta1.CreateRoomRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.showcase.v1beta1.Room.getDefaultInstance()))
              .setSchemaDescriptor(new MessagingMethodDescriptorSupplier("CreateRoom"))
              .build();
        }
      }
    }
    return getCreateRoomMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.showcase.v1beta1.GetRoomRequest,
      com.google.showcase.v1beta1.Room> getGetRoomMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetRoom",
      requestType = com.google.showcase.v1beta1.GetRoomRequest.class,
      responseType = com.google.showcase.v1beta1.Room.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.showcase.v1beta1.GetRoomRequest,
      com.google.showcase.v1beta1.Room> getGetRoomMethod() {
    io.grpc.MethodDescriptor<com.google.showcase.v1beta1.GetRoomRequest, com.google.showcase.v1beta1.Room> getGetRoomMethod;
    if ((getGetRoomMethod = MessagingGrpc.getGetRoomMethod) == null) {
      synchronized (MessagingGrpc.class) {
        if ((getGetRoomMethod = MessagingGrpc.getGetRoomMethod) == null) {
          MessagingGrpc.getGetRoomMethod = getGetRoomMethod =
              io.grpc.MethodDescriptor.<com.google.showcase.v1beta1.GetRoomRequest, com.google.showcase.v1beta1.Room>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetRoom"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.showcase.v1beta1.GetRoomRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.showcase.v1beta1.Room.getDefaultInstance()))
              .setSchemaDescriptor(new MessagingMethodDescriptorSupplier("GetRoom"))
              .build();
        }
      }
    }
    return getGetRoomMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.showcase.v1beta1.UpdateRoomRequest,
      com.google.showcase.v1beta1.Room> getUpdateRoomMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateRoom",
      requestType = com.google.showcase.v1beta1.UpdateRoomRequest.class,
      responseType = com.google.showcase.v1beta1.Room.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.showcase.v1beta1.UpdateRoomRequest,
      com.google.showcase.v1beta1.Room> getUpdateRoomMethod() {
    io.grpc.MethodDescriptor<com.google.showcase.v1beta1.UpdateRoomRequest, com.google.showcase.v1beta1.Room> getUpdateRoomMethod;
    if ((getUpdateRoomMethod = MessagingGrpc.getUpdateRoomMethod) == null) {
      synchronized (MessagingGrpc.class) {
        if ((getUpdateRoomMethod = MessagingGrpc.getUpdateRoomMethod) == null) {
          MessagingGrpc.getUpdateRoomMethod = getUpdateRoomMethod =
              io.grpc.MethodDescriptor.<com.google.showcase.v1beta1.UpdateRoomRequest, com.google.showcase.v1beta1.Room>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateRoom"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.showcase.v1beta1.UpdateRoomRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.showcase.v1beta1.Room.getDefaultInstance()))
              .setSchemaDescriptor(new MessagingMethodDescriptorSupplier("UpdateRoom"))
              .build();
        }
      }
    }
    return getUpdateRoomMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.showcase.v1beta1.DeleteRoomRequest,
      com.google.protobuf.Empty> getDeleteRoomMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteRoom",
      requestType = com.google.showcase.v1beta1.DeleteRoomRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.showcase.v1beta1.DeleteRoomRequest,
      com.google.protobuf.Empty> getDeleteRoomMethod() {
    io.grpc.MethodDescriptor<com.google.showcase.v1beta1.DeleteRoomRequest, com.google.protobuf.Empty> getDeleteRoomMethod;
    if ((getDeleteRoomMethod = MessagingGrpc.getDeleteRoomMethod) == null) {
      synchronized (MessagingGrpc.class) {
        if ((getDeleteRoomMethod = MessagingGrpc.getDeleteRoomMethod) == null) {
          MessagingGrpc.getDeleteRoomMethod = getDeleteRoomMethod =
              io.grpc.MethodDescriptor.<com.google.showcase.v1beta1.DeleteRoomRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteRoom"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.showcase.v1beta1.DeleteRoomRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new MessagingMethodDescriptorSupplier("DeleteRoom"))
              .build();
        }
      }
    }
    return getDeleteRoomMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.showcase.v1beta1.ListRoomsRequest,
      com.google.showcase.v1beta1.ListRoomsResponse> getListRoomsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListRooms",
      requestType = com.google.showcase.v1beta1.ListRoomsRequest.class,
      responseType = com.google.showcase.v1beta1.ListRoomsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.showcase.v1beta1.ListRoomsRequest,
      com.google.showcase.v1beta1.ListRoomsResponse> getListRoomsMethod() {
    io.grpc.MethodDescriptor<com.google.showcase.v1beta1.ListRoomsRequest, com.google.showcase.v1beta1.ListRoomsResponse> getListRoomsMethod;
    if ((getListRoomsMethod = MessagingGrpc.getListRoomsMethod) == null) {
      synchronized (MessagingGrpc.class) {
        if ((getListRoomsMethod = MessagingGrpc.getListRoomsMethod) == null) {
          MessagingGrpc.getListRoomsMethod = getListRoomsMethod =
              io.grpc.MethodDescriptor.<com.google.showcase.v1beta1.ListRoomsRequest, com.google.showcase.v1beta1.ListRoomsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListRooms"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.showcase.v1beta1.ListRoomsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.showcase.v1beta1.ListRoomsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MessagingMethodDescriptorSupplier("ListRooms"))
              .build();
        }
      }
    }
    return getListRoomsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.showcase.v1beta1.CreateBlurbRequest,
      com.google.showcase.v1beta1.Blurb> getCreateBlurbMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateBlurb",
      requestType = com.google.showcase.v1beta1.CreateBlurbRequest.class,
      responseType = com.google.showcase.v1beta1.Blurb.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.showcase.v1beta1.CreateBlurbRequest,
      com.google.showcase.v1beta1.Blurb> getCreateBlurbMethod() {
    io.grpc.MethodDescriptor<com.google.showcase.v1beta1.CreateBlurbRequest, com.google.showcase.v1beta1.Blurb> getCreateBlurbMethod;
    if ((getCreateBlurbMethod = MessagingGrpc.getCreateBlurbMethod) == null) {
      synchronized (MessagingGrpc.class) {
        if ((getCreateBlurbMethod = MessagingGrpc.getCreateBlurbMethod) == null) {
          MessagingGrpc.getCreateBlurbMethod = getCreateBlurbMethod =
              io.grpc.MethodDescriptor.<com.google.showcase.v1beta1.CreateBlurbRequest, com.google.showcase.v1beta1.Blurb>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateBlurb"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.showcase.v1beta1.CreateBlurbRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.showcase.v1beta1.Blurb.getDefaultInstance()))
              .setSchemaDescriptor(new MessagingMethodDescriptorSupplier("CreateBlurb"))
              .build();
        }
      }
    }
    return getCreateBlurbMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.showcase.v1beta1.GetBlurbRequest,
      com.google.showcase.v1beta1.Blurb> getGetBlurbMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetBlurb",
      requestType = com.google.showcase.v1beta1.GetBlurbRequest.class,
      responseType = com.google.showcase.v1beta1.Blurb.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.showcase.v1beta1.GetBlurbRequest,
      com.google.showcase.v1beta1.Blurb> getGetBlurbMethod() {
    io.grpc.MethodDescriptor<com.google.showcase.v1beta1.GetBlurbRequest, com.google.showcase.v1beta1.Blurb> getGetBlurbMethod;
    if ((getGetBlurbMethod = MessagingGrpc.getGetBlurbMethod) == null) {
      synchronized (MessagingGrpc.class) {
        if ((getGetBlurbMethod = MessagingGrpc.getGetBlurbMethod) == null) {
          MessagingGrpc.getGetBlurbMethod = getGetBlurbMethod =
              io.grpc.MethodDescriptor.<com.google.showcase.v1beta1.GetBlurbRequest, com.google.showcase.v1beta1.Blurb>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetBlurb"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.showcase.v1beta1.GetBlurbRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.showcase.v1beta1.Blurb.getDefaultInstance()))
              .setSchemaDescriptor(new MessagingMethodDescriptorSupplier("GetBlurb"))
              .build();
        }
      }
    }
    return getGetBlurbMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.showcase.v1beta1.UpdateBlurbRequest,
      com.google.showcase.v1beta1.Blurb> getUpdateBlurbMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateBlurb",
      requestType = com.google.showcase.v1beta1.UpdateBlurbRequest.class,
      responseType = com.google.showcase.v1beta1.Blurb.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.showcase.v1beta1.UpdateBlurbRequest,
      com.google.showcase.v1beta1.Blurb> getUpdateBlurbMethod() {
    io.grpc.MethodDescriptor<com.google.showcase.v1beta1.UpdateBlurbRequest, com.google.showcase.v1beta1.Blurb> getUpdateBlurbMethod;
    if ((getUpdateBlurbMethod = MessagingGrpc.getUpdateBlurbMethod) == null) {
      synchronized (MessagingGrpc.class) {
        if ((getUpdateBlurbMethod = MessagingGrpc.getUpdateBlurbMethod) == null) {
          MessagingGrpc.getUpdateBlurbMethod = getUpdateBlurbMethod =
              io.grpc.MethodDescriptor.<com.google.showcase.v1beta1.UpdateBlurbRequest, com.google.showcase.v1beta1.Blurb>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateBlurb"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.showcase.v1beta1.UpdateBlurbRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.showcase.v1beta1.Blurb.getDefaultInstance()))
              .setSchemaDescriptor(new MessagingMethodDescriptorSupplier("UpdateBlurb"))
              .build();
        }
      }
    }
    return getUpdateBlurbMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.showcase.v1beta1.DeleteBlurbRequest,
      com.google.protobuf.Empty> getDeleteBlurbMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteBlurb",
      requestType = com.google.showcase.v1beta1.DeleteBlurbRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.showcase.v1beta1.DeleteBlurbRequest,
      com.google.protobuf.Empty> getDeleteBlurbMethod() {
    io.grpc.MethodDescriptor<com.google.showcase.v1beta1.DeleteBlurbRequest, com.google.protobuf.Empty> getDeleteBlurbMethod;
    if ((getDeleteBlurbMethod = MessagingGrpc.getDeleteBlurbMethod) == null) {
      synchronized (MessagingGrpc.class) {
        if ((getDeleteBlurbMethod = MessagingGrpc.getDeleteBlurbMethod) == null) {
          MessagingGrpc.getDeleteBlurbMethod = getDeleteBlurbMethod =
              io.grpc.MethodDescriptor.<com.google.showcase.v1beta1.DeleteBlurbRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteBlurb"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.showcase.v1beta1.DeleteBlurbRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new MessagingMethodDescriptorSupplier("DeleteBlurb"))
              .build();
        }
      }
    }
    return getDeleteBlurbMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.showcase.v1beta1.ListBlurbsRequest,
      com.google.showcase.v1beta1.ListBlurbsResponse> getListBlurbsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListBlurbs",
      requestType = com.google.showcase.v1beta1.ListBlurbsRequest.class,
      responseType = com.google.showcase.v1beta1.ListBlurbsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.showcase.v1beta1.ListBlurbsRequest,
      com.google.showcase.v1beta1.ListBlurbsResponse> getListBlurbsMethod() {
    io.grpc.MethodDescriptor<com.google.showcase.v1beta1.ListBlurbsRequest, com.google.showcase.v1beta1.ListBlurbsResponse> getListBlurbsMethod;
    if ((getListBlurbsMethod = MessagingGrpc.getListBlurbsMethod) == null) {
      synchronized (MessagingGrpc.class) {
        if ((getListBlurbsMethod = MessagingGrpc.getListBlurbsMethod) == null) {
          MessagingGrpc.getListBlurbsMethod = getListBlurbsMethod =
              io.grpc.MethodDescriptor.<com.google.showcase.v1beta1.ListBlurbsRequest, com.google.showcase.v1beta1.ListBlurbsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListBlurbs"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.showcase.v1beta1.ListBlurbsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.showcase.v1beta1.ListBlurbsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MessagingMethodDescriptorSupplier("ListBlurbs"))
              .build();
        }
      }
    }
    return getListBlurbsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.showcase.v1beta1.SearchBlurbsRequest,
      com.google.longrunning.Operation> getSearchBlurbsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SearchBlurbs",
      requestType = com.google.showcase.v1beta1.SearchBlurbsRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.showcase.v1beta1.SearchBlurbsRequest,
      com.google.longrunning.Operation> getSearchBlurbsMethod() {
    io.grpc.MethodDescriptor<com.google.showcase.v1beta1.SearchBlurbsRequest, com.google.longrunning.Operation> getSearchBlurbsMethod;
    if ((getSearchBlurbsMethod = MessagingGrpc.getSearchBlurbsMethod) == null) {
      synchronized (MessagingGrpc.class) {
        if ((getSearchBlurbsMethod = MessagingGrpc.getSearchBlurbsMethod) == null) {
          MessagingGrpc.getSearchBlurbsMethod = getSearchBlurbsMethod =
              io.grpc.MethodDescriptor.<com.google.showcase.v1beta1.SearchBlurbsRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SearchBlurbs"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.showcase.v1beta1.SearchBlurbsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new MessagingMethodDescriptorSupplier("SearchBlurbs"))
              .build();
        }
      }
    }
    return getSearchBlurbsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.showcase.v1beta1.StreamBlurbsRequest,
      com.google.showcase.v1beta1.StreamBlurbsResponse> getStreamBlurbsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StreamBlurbs",
      requestType = com.google.showcase.v1beta1.StreamBlurbsRequest.class,
      responseType = com.google.showcase.v1beta1.StreamBlurbsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.google.showcase.v1beta1.StreamBlurbsRequest,
      com.google.showcase.v1beta1.StreamBlurbsResponse> getStreamBlurbsMethod() {
    io.grpc.MethodDescriptor<com.google.showcase.v1beta1.StreamBlurbsRequest, com.google.showcase.v1beta1.StreamBlurbsResponse> getStreamBlurbsMethod;
    if ((getStreamBlurbsMethod = MessagingGrpc.getStreamBlurbsMethod) == null) {
      synchronized (MessagingGrpc.class) {
        if ((getStreamBlurbsMethod = MessagingGrpc.getStreamBlurbsMethod) == null) {
          MessagingGrpc.getStreamBlurbsMethod = getStreamBlurbsMethod =
              io.grpc.MethodDescriptor.<com.google.showcase.v1beta1.StreamBlurbsRequest, com.google.showcase.v1beta1.StreamBlurbsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StreamBlurbs"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.showcase.v1beta1.StreamBlurbsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.showcase.v1beta1.StreamBlurbsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MessagingMethodDescriptorSupplier("StreamBlurbs"))
              .build();
        }
      }
    }
    return getStreamBlurbsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.showcase.v1beta1.CreateBlurbRequest,
      com.google.showcase.v1beta1.SendBlurbsResponse> getSendBlurbsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SendBlurbs",
      requestType = com.google.showcase.v1beta1.CreateBlurbRequest.class,
      responseType = com.google.showcase.v1beta1.SendBlurbsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<com.google.showcase.v1beta1.CreateBlurbRequest,
      com.google.showcase.v1beta1.SendBlurbsResponse> getSendBlurbsMethod() {
    io.grpc.MethodDescriptor<com.google.showcase.v1beta1.CreateBlurbRequest, com.google.showcase.v1beta1.SendBlurbsResponse> getSendBlurbsMethod;
    if ((getSendBlurbsMethod = MessagingGrpc.getSendBlurbsMethod) == null) {
      synchronized (MessagingGrpc.class) {
        if ((getSendBlurbsMethod = MessagingGrpc.getSendBlurbsMethod) == null) {
          MessagingGrpc.getSendBlurbsMethod = getSendBlurbsMethod =
              io.grpc.MethodDescriptor.<com.google.showcase.v1beta1.CreateBlurbRequest, com.google.showcase.v1beta1.SendBlurbsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SendBlurbs"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.showcase.v1beta1.CreateBlurbRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.showcase.v1beta1.SendBlurbsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MessagingMethodDescriptorSupplier("SendBlurbs"))
              .build();
        }
      }
    }
    return getSendBlurbsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.showcase.v1beta1.ConnectRequest,
      com.google.showcase.v1beta1.StreamBlurbsResponse> getConnectMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Connect",
      requestType = com.google.showcase.v1beta1.ConnectRequest.class,
      responseType = com.google.showcase.v1beta1.StreamBlurbsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.google.showcase.v1beta1.ConnectRequest,
      com.google.showcase.v1beta1.StreamBlurbsResponse> getConnectMethod() {
    io.grpc.MethodDescriptor<com.google.showcase.v1beta1.ConnectRequest, com.google.showcase.v1beta1.StreamBlurbsResponse> getConnectMethod;
    if ((getConnectMethod = MessagingGrpc.getConnectMethod) == null) {
      synchronized (MessagingGrpc.class) {
        if ((getConnectMethod = MessagingGrpc.getConnectMethod) == null) {
          MessagingGrpc.getConnectMethod = getConnectMethod =
              io.grpc.MethodDescriptor.<com.google.showcase.v1beta1.ConnectRequest, com.google.showcase.v1beta1.StreamBlurbsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Connect"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.showcase.v1beta1.ConnectRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.showcase.v1beta1.StreamBlurbsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MessagingMethodDescriptorSupplier("Connect"))
              .build();
        }
      }
    }
    return getConnectMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static MessagingStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MessagingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MessagingStub>() {
        @java.lang.Override
        public MessagingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MessagingStub(channel, callOptions);
        }
      };
    return MessagingStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MessagingBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MessagingBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MessagingBlockingStub>() {
        @java.lang.Override
        public MessagingBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MessagingBlockingStub(channel, callOptions);
        }
      };
    return MessagingBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static MessagingFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MessagingFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MessagingFutureStub>() {
        @java.lang.Override
        public MessagingFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MessagingFutureStub(channel, callOptions);
        }
      };
    return MessagingFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void createRoom(com.google.showcase.v1beta1.CreateRoomRequest request,
        io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.Room> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateRoomMethod(), responseObserver);
    }

    /**
     */
    default void getRoom(com.google.showcase.v1beta1.GetRoomRequest request,
        io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.Room> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetRoomMethod(), responseObserver);
    }

    /**
     */
    default void updateRoom(com.google.showcase.v1beta1.UpdateRoomRequest request,
        io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.Room> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateRoomMethod(), responseObserver);
    }

    /**
     */
    default void deleteRoom(com.google.showcase.v1beta1.DeleteRoomRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteRoomMethod(), responseObserver);
    }

    /**
     */
    default void listRooms(com.google.showcase.v1beta1.ListRoomsRequest request,
        io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.ListRoomsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListRoomsMethod(), responseObserver);
    }

    /**
     */
    default void createBlurb(com.google.showcase.v1beta1.CreateBlurbRequest request,
        io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.Blurb> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateBlurbMethod(), responseObserver);
    }

    /**
     */
    default void getBlurb(com.google.showcase.v1beta1.GetBlurbRequest request,
        io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.Blurb> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetBlurbMethod(), responseObserver);
    }

    /**
     */
    default void updateBlurb(com.google.showcase.v1beta1.UpdateBlurbRequest request,
        io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.Blurb> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateBlurbMethod(), responseObserver);
    }

    /**
     */
    default void deleteBlurb(com.google.showcase.v1beta1.DeleteBlurbRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteBlurbMethod(), responseObserver);
    }

    /**
     */
    default void listBlurbs(com.google.showcase.v1beta1.ListBlurbsRequest request,
        io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.ListBlurbsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListBlurbsMethod(), responseObserver);
    }

    /**
     */
    default void searchBlurbs(com.google.showcase.v1beta1.SearchBlurbsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSearchBlurbsMethod(), responseObserver);
    }

    /**
     */
    default void streamBlurbs(com.google.showcase.v1beta1.StreamBlurbsRequest request,
        io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.StreamBlurbsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStreamBlurbsMethod(), responseObserver);
    }

    /**
     */
    default io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.CreateBlurbRequest> sendBlurbs(
        io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.SendBlurbsResponse> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getSendBlurbsMethod(), responseObserver);
    }

    /**
     */
    default io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.ConnectRequest> connect(
        io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.StreamBlurbsResponse> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getConnectMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Messaging.
   */
  public static abstract class MessagingImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return MessagingGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service Messaging.
   */
  public static final class MessagingStub
      extends io.grpc.stub.AbstractAsyncStub<MessagingStub> {
    private MessagingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MessagingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MessagingStub(channel, callOptions);
    }

    /**
     */
    public void createRoom(com.google.showcase.v1beta1.CreateRoomRequest request,
        io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.Room> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateRoomMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getRoom(com.google.showcase.v1beta1.GetRoomRequest request,
        io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.Room> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetRoomMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateRoom(com.google.showcase.v1beta1.UpdateRoomRequest request,
        io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.Room> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateRoomMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteRoom(com.google.showcase.v1beta1.DeleteRoomRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteRoomMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void listRooms(com.google.showcase.v1beta1.ListRoomsRequest request,
        io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.ListRoomsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListRoomsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void createBlurb(com.google.showcase.v1beta1.CreateBlurbRequest request,
        io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.Blurb> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateBlurbMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getBlurb(com.google.showcase.v1beta1.GetBlurbRequest request,
        io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.Blurb> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetBlurbMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateBlurb(com.google.showcase.v1beta1.UpdateBlurbRequest request,
        io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.Blurb> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateBlurbMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteBlurb(com.google.showcase.v1beta1.DeleteBlurbRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteBlurbMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void listBlurbs(com.google.showcase.v1beta1.ListBlurbsRequest request,
        io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.ListBlurbsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListBlurbsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void searchBlurbs(com.google.showcase.v1beta1.SearchBlurbsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSearchBlurbsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void streamBlurbs(com.google.showcase.v1beta1.StreamBlurbsRequest request,
        io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.StreamBlurbsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getStreamBlurbsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.CreateBlurbRequest> sendBlurbs(
        io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.SendBlurbsResponse> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncClientStreamingCall(
          getChannel().newCall(getSendBlurbsMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.ConnectRequest> connect(
        io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.StreamBlurbsResponse> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getConnectMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Messaging.
   */
  public static final class MessagingBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<MessagingBlockingStub> {
    private MessagingBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MessagingBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MessagingBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.google.showcase.v1beta1.Room createRoom(com.google.showcase.v1beta1.CreateRoomRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateRoomMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.showcase.v1beta1.Room getRoom(com.google.showcase.v1beta1.GetRoomRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetRoomMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.showcase.v1beta1.Room updateRoom(com.google.showcase.v1beta1.UpdateRoomRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateRoomMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty deleteRoom(com.google.showcase.v1beta1.DeleteRoomRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteRoomMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.showcase.v1beta1.ListRoomsResponse listRooms(com.google.showcase.v1beta1.ListRoomsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListRoomsMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.showcase.v1beta1.Blurb createBlurb(com.google.showcase.v1beta1.CreateBlurbRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateBlurbMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.showcase.v1beta1.Blurb getBlurb(com.google.showcase.v1beta1.GetBlurbRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetBlurbMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.showcase.v1beta1.Blurb updateBlurb(com.google.showcase.v1beta1.UpdateBlurbRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateBlurbMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty deleteBlurb(com.google.showcase.v1beta1.DeleteBlurbRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteBlurbMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.showcase.v1beta1.ListBlurbsResponse listBlurbs(com.google.showcase.v1beta1.ListBlurbsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListBlurbsMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.longrunning.Operation searchBlurbs(com.google.showcase.v1beta1.SearchBlurbsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSearchBlurbsMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<com.google.showcase.v1beta1.StreamBlurbsResponse> streamBlurbs(
        com.google.showcase.v1beta1.StreamBlurbsRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getStreamBlurbsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Messaging.
   */
  public static final class MessagingFutureStub
      extends io.grpc.stub.AbstractFutureStub<MessagingFutureStub> {
    private MessagingFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MessagingFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MessagingFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.showcase.v1beta1.Room> createRoom(
        com.google.showcase.v1beta1.CreateRoomRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateRoomMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.showcase.v1beta1.Room> getRoom(
        com.google.showcase.v1beta1.GetRoomRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetRoomMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.showcase.v1beta1.Room> updateRoom(
        com.google.showcase.v1beta1.UpdateRoomRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateRoomMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteRoom(
        com.google.showcase.v1beta1.DeleteRoomRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteRoomMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.showcase.v1beta1.ListRoomsResponse> listRooms(
        com.google.showcase.v1beta1.ListRoomsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListRoomsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.showcase.v1beta1.Blurb> createBlurb(
        com.google.showcase.v1beta1.CreateBlurbRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateBlurbMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.showcase.v1beta1.Blurb> getBlurb(
        com.google.showcase.v1beta1.GetBlurbRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetBlurbMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.showcase.v1beta1.Blurb> updateBlurb(
        com.google.showcase.v1beta1.UpdateBlurbRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateBlurbMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteBlurb(
        com.google.showcase.v1beta1.DeleteBlurbRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteBlurbMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.showcase.v1beta1.ListBlurbsResponse> listBlurbs(
        com.google.showcase.v1beta1.ListBlurbsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListBlurbsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> searchBlurbs(
        com.google.showcase.v1beta1.SearchBlurbsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSearchBlurbsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_ROOM = 0;
  private static final int METHODID_GET_ROOM = 1;
  private static final int METHODID_UPDATE_ROOM = 2;
  private static final int METHODID_DELETE_ROOM = 3;
  private static final int METHODID_LIST_ROOMS = 4;
  private static final int METHODID_CREATE_BLURB = 5;
  private static final int METHODID_GET_BLURB = 6;
  private static final int METHODID_UPDATE_BLURB = 7;
  private static final int METHODID_DELETE_BLURB = 8;
  private static final int METHODID_LIST_BLURBS = 9;
  private static final int METHODID_SEARCH_BLURBS = 10;
  private static final int METHODID_STREAM_BLURBS = 11;
  private static final int METHODID_SEND_BLURBS = 12;
  private static final int METHODID_CONNECT = 13;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_ROOM:
          serviceImpl.createRoom((com.google.showcase.v1beta1.CreateRoomRequest) request,
              (io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.Room>) responseObserver);
          break;
        case METHODID_GET_ROOM:
          serviceImpl.getRoom((com.google.showcase.v1beta1.GetRoomRequest) request,
              (io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.Room>) responseObserver);
          break;
        case METHODID_UPDATE_ROOM:
          serviceImpl.updateRoom((com.google.showcase.v1beta1.UpdateRoomRequest) request,
              (io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.Room>) responseObserver);
          break;
        case METHODID_DELETE_ROOM:
          serviceImpl.deleteRoom((com.google.showcase.v1beta1.DeleteRoomRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LIST_ROOMS:
          serviceImpl.listRooms((com.google.showcase.v1beta1.ListRoomsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.ListRoomsResponse>) responseObserver);
          break;
        case METHODID_CREATE_BLURB:
          serviceImpl.createBlurb((com.google.showcase.v1beta1.CreateBlurbRequest) request,
              (io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.Blurb>) responseObserver);
          break;
        case METHODID_GET_BLURB:
          serviceImpl.getBlurb((com.google.showcase.v1beta1.GetBlurbRequest) request,
              (io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.Blurb>) responseObserver);
          break;
        case METHODID_UPDATE_BLURB:
          serviceImpl.updateBlurb((com.google.showcase.v1beta1.UpdateBlurbRequest) request,
              (io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.Blurb>) responseObserver);
          break;
        case METHODID_DELETE_BLURB:
          serviceImpl.deleteBlurb((com.google.showcase.v1beta1.DeleteBlurbRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LIST_BLURBS:
          serviceImpl.listBlurbs((com.google.showcase.v1beta1.ListBlurbsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.ListBlurbsResponse>) responseObserver);
          break;
        case METHODID_SEARCH_BLURBS:
          serviceImpl.searchBlurbs((com.google.showcase.v1beta1.SearchBlurbsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_STREAM_BLURBS:
          serviceImpl.streamBlurbs((com.google.showcase.v1beta1.StreamBlurbsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.StreamBlurbsResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SEND_BLURBS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.sendBlurbs(
              (io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.SendBlurbsResponse>) responseObserver);
        case METHODID_CONNECT:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.connect(
              (io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.StreamBlurbsResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getCreateRoomMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.showcase.v1beta1.CreateRoomRequest,
              com.google.showcase.v1beta1.Room>(
                service, METHODID_CREATE_ROOM)))
        .addMethod(
          getGetRoomMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.showcase.v1beta1.GetRoomRequest,
              com.google.showcase.v1beta1.Room>(
                service, METHODID_GET_ROOM)))
        .addMethod(
          getUpdateRoomMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.showcase.v1beta1.UpdateRoomRequest,
              com.google.showcase.v1beta1.Room>(
                service, METHODID_UPDATE_ROOM)))
        .addMethod(
          getDeleteRoomMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.showcase.v1beta1.DeleteRoomRequest,
              com.google.protobuf.Empty>(
                service, METHODID_DELETE_ROOM)))
        .addMethod(
          getListRoomsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.showcase.v1beta1.ListRoomsRequest,
              com.google.showcase.v1beta1.ListRoomsResponse>(
                service, METHODID_LIST_ROOMS)))
        .addMethod(
          getCreateBlurbMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.showcase.v1beta1.CreateBlurbRequest,
              com.google.showcase.v1beta1.Blurb>(
                service, METHODID_CREATE_BLURB)))
        .addMethod(
          getGetBlurbMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.showcase.v1beta1.GetBlurbRequest,
              com.google.showcase.v1beta1.Blurb>(
                service, METHODID_GET_BLURB)))
        .addMethod(
          getUpdateBlurbMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.showcase.v1beta1.UpdateBlurbRequest,
              com.google.showcase.v1beta1.Blurb>(
                service, METHODID_UPDATE_BLURB)))
        .addMethod(
          getDeleteBlurbMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.showcase.v1beta1.DeleteBlurbRequest,
              com.google.protobuf.Empty>(
                service, METHODID_DELETE_BLURB)))
        .addMethod(
          getListBlurbsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.showcase.v1beta1.ListBlurbsRequest,
              com.google.showcase.v1beta1.ListBlurbsResponse>(
                service, METHODID_LIST_BLURBS)))
        .addMethod(
          getSearchBlurbsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.showcase.v1beta1.SearchBlurbsRequest,
              com.google.longrunning.Operation>(
                service, METHODID_SEARCH_BLURBS)))
        .addMethod(
          getStreamBlurbsMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              com.google.showcase.v1beta1.StreamBlurbsRequest,
              com.google.showcase.v1beta1.StreamBlurbsResponse>(
                service, METHODID_STREAM_BLURBS)))
        .addMethod(
          getSendBlurbsMethod(),
          io.grpc.stub.ServerCalls.asyncClientStreamingCall(
            new MethodHandlers<
              com.google.showcase.v1beta1.CreateBlurbRequest,
              com.google.showcase.v1beta1.SendBlurbsResponse>(
                service, METHODID_SEND_BLURBS)))
        .addMethod(
          getConnectMethod(),
          io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
            new MethodHandlers<
              com.google.showcase.v1beta1.ConnectRequest,
              com.google.showcase.v1beta1.StreamBlurbsResponse>(
                service, METHODID_CONNECT)))
        .build();
  }

  private static abstract class MessagingBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MessagingBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.showcase.v1beta1.MessagingOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Messaging");
    }
  }

  private static final class MessagingFileDescriptorSupplier
      extends MessagingBaseDescriptorSupplier {
    MessagingFileDescriptorSupplier() {}
  }

  private static final class MessagingMethodDescriptorSupplier
      extends MessagingBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    MessagingMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (MessagingGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new MessagingFileDescriptorSupplier())
              .addMethod(getCreateRoomMethod())
              .addMethod(getGetRoomMethod())
              .addMethod(getUpdateRoomMethod())
              .addMethod(getDeleteRoomMethod())
              .addMethod(getListRoomsMethod())
              .addMethod(getCreateBlurbMethod())
              .addMethod(getGetBlurbMethod())
              .addMethod(getUpdateBlurbMethod())
              .addMethod(getDeleteBlurbMethod())
              .addMethod(getListBlurbsMethod())
              .addMethod(getSearchBlurbsMethod())
              .addMethod(getStreamBlurbsMethod())
              .addMethod(getSendBlurbsMethod())
              .addMethod(getConnectMethod())
              .build();
        }
      }
    }
    return result;
  }
}
