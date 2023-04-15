/*
 * Copyright 2023 Google LLC
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
package com.google.showcase.v1beta1.it;

import static com.google.common.truth.Truth.assertThat;

import com.google.common.collect.ImmutableList;
import com.google.protobuf.FieldMask;
import com.google.showcase.v1beta1.CreateUserRequest;
import com.google.showcase.v1beta1.DeleteUserRequest;
import com.google.showcase.v1beta1.IdentityClient;
import com.google.showcase.v1beta1.ListUsersRequest;
import com.google.showcase.v1beta1.ListUsersResponse;
import com.google.showcase.v1beta1.UpdateUserRequest;
import com.google.showcase.v1beta1.User;
import com.google.showcase.v1beta1.it.util.TestClientInitializer;
import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ITCrud {

  private static final User DEFAULT_USER =
      User.newBuilder()
          .setDisplayName("Jane Doe")
          .setEmail("janedoe@example.com")
          .setNickname("Doe")
          .setHeightFeet(5)
          .setAge(25)
          .build();

  private IdentityClient grpcClient;
  private IdentityClient httpJsonClient;

  @Before
  public void setup() throws Exception {
    // Create gRPC IdentityClient
    grpcClient = TestClientInitializer.createGrpcIdentityClient();
    // Create HttpJson IdentityClient
    httpJsonClient = TestClientInitializer.createHttpJsonIdentityClient();

    // Ensure an empty state before each run
    cleanupData(httpJsonClient);
  }

  @After
  public void cleanup() {
    grpcClient.close();
    httpJsonClient.close();
  }

  @Test
  public void testHttpJson_Create() {
    User userResponse = createDefaultUser();

    // These properties should be the same
    assertThat(userResponse.getDisplayName()).isEqualTo(DEFAULT_USER.getDisplayName());
    assertThat(userResponse.getEmail()).isEqualTo(DEFAULT_USER.getEmail());
    assertThat(userResponse.getNickname()).isEqualTo(DEFAULT_USER.getNickname());
    assertThat(userResponse.getHeightFeet()).isEqualTo(DEFAULT_USER.getHeightFeet());
    assertThat(userResponse.getAge()).isEqualTo(DEFAULT_USER.getAge());

    // Assert that the server populates these fields
    assertThat(userResponse.getName()).isNotEmpty();
    assertThat(userResponse.getCreateTime()).isNotNull();
    assertThat(userResponse.getUpdateTime()).isNotNull();
    assertThat(userResponse.getEnableNotifications()).isNotNull();
  }

  @Test
  public void testHttpJson_Read() {
    List<User> expectedUsersList =
        ImmutableList.of(
            createDefaultUser(),
            createUser(
                DEFAULT_USER
                    .toBuilder()
                    .setNickname("John Smith")
                    .setEmail("johnsmith@example.com")
                    .build()));
    // Assert that only one User exists
    IdentityClient.ListUsersPagedResponse listUsersPagedResponse =
        httpJsonClient.listUsers(ListUsersRequest.newBuilder().setPageSize(5).build());
    ListUsersResponse listUsersResponse = listUsersPagedResponse.getPage().getResponse();
    assertThat(listUsersResponse.getUsersList().size()).isEqualTo(2);

    // Check that the response from both List (pagination) and Get
    // List Users
    assertThat(listUsersResponse.getUsersList()).containsExactlyElementsIn(expectedUsersList);

    // Get User
    User defaultUser = expectedUsersList.get(0);
    User getUserResponse = httpJsonClient.getUser(defaultUser.getName());
    assertThat(getUserResponse).isEqualTo(defaultUser);
  }

  @Test
  public void testHttpJson_Update() {
    User userResponse = createDefaultUser();
    // Update multiple fields in the User. Age + Nickname are not included in the FieldMask
    // userResponse's enableNotifications field is populated from the server
    User updateUser =
        userResponse
            .toBuilder()
            .setAge(50)
            .setNickname("Smith")
            .setEmail("janedoe@jane.com")
            .setHeightFeet(6.0)
            .setEnableNotifications(true)
            .build();
    User updateUserResponse =
        httpJsonClient.updateUser(
            UpdateUserRequest.newBuilder()
                .setUser(updateUser)
                .setUpdateMask(
                    FieldMask.newBuilder()
                        .addAllPaths(Arrays.asList("email", "height_feet", "enable_notifications"))
                        .build())
                .build());

    // Assert that only the fields in the FieldMask are updated correctly
    assertThat(updateUserResponse).isNotEqualTo(userResponse);
    assertThat(updateUserResponse.getAge()).isEqualTo(userResponse.getAge());
    assertThat(updateUserResponse.getNickname()).isEqualTo(userResponse.getNickname());

    assertThat(updateUserResponse.getEmail()).isEqualTo(updateUser.getEmail());
    assertThat(updateUserResponse.getHeightFeet()).isEqualTo(updateUser.getHeightFeet());
    assertThat(updateUserResponse.getEnableNotifications())
        .isEqualTo(updateUser.getEnableNotifications());
  }

  @Test
  public void testHttpJson_Delete() {
    User userResponse = createDefaultUser();

    httpJsonClient.deleteUser(
        DeleteUserRequest.newBuilder().setName(userResponse.getName()).build());

    IdentityClient.ListUsersPagedResponse listUsersPagedResponse =
        httpJsonClient.listUsers(ListUsersRequest.newBuilder().setPageSize(5).build());
    assertThat(listUsersPagedResponse.getPage().getResponse().getUsersList().size()).isEqualTo(0);
  }

  private void cleanupData(IdentityClient identityClient) {
    IdentityClient.ListUsersPagedResponse pagedResponse =
        identityClient.listUsers(ListUsersRequest.newBuilder().setPageSize(5).build());
    for (IdentityClient.ListUsersPage listUsersPage : pagedResponse.iteratePages()) {
      for (User user : listUsersPage.getResponse().getUsersList()) {
        identityClient.deleteUser(user.getName());
      }
    }
    pagedResponse = httpJsonClient.listUsers(ListUsersRequest.newBuilder().setPageSize(5).build());
    assertThat(pagedResponse.getPage().getResponse().getUsersList().size()).isEqualTo(0);
  }

  private User createDefaultUser() {
    return createUser(DEFAULT_USER);
  }

  /**
   * Helper method to create a user with the DEFAULT_USER configs. Server returns a generated name
   * (not username) that is used to identify the individual user and each test uses the name for the
   * RPC. Server also populates a few additional fields (Create Time, Updated Time, and Enable
   * Notifications).
   *
   * @param user User to be created
   * @return newly created user
   */
  private User createUser(User user) {
    return httpJsonClient.createUser(CreateUserRequest.newBuilder().setUser(user).build());
  }
}
