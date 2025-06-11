package org.openapitools.service;


import org.openapitools.dto.UserRequest;
import org.openapitools.dto.UserResponse;

public interface UserService {
    UserResponse register(UserRequest request);
    String authenticate(String username, String password);
    UserResponse getByUsername(String username);
}
