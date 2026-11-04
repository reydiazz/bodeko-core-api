package com.reydiazz.bodeko.core.user.core.service;

import com.reydiazz.bodeko.core.user.core.web.request.CreateUserRequest;
import com.reydiazz.bodeko.core.user.core.web.response.UserResponse;

public interface UserService {

    UserResponse create (CreateUserRequest request);
}
