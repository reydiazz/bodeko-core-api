package com.reydiazz.bodeko.security.auth.service;

import com.reydiazz.bodeko.core.user.core.model.entity.User;
import com.reydiazz.bodeko.security.auth.web.request.LoginRequest;
import com.reydiazz.bodeko.security.auth.web.response.AuthResponse;
import com.reydiazz.bodeko.security.auth.web.response.LoginResponse;


public interface AuthService {

    LoginResponse login(LoginRequest request);

    AuthResponse getAuthenticatedUser();

    User findAuthenticatedUser();

}