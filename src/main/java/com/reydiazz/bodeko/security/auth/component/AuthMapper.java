package com.reydiazz.bodeko.security.auth.component;

import com.reydiazz.bodeko.core.user.core.model.entity.User;
import com.reydiazz.bodeko.security.auth.web.response.AuthResponse;
import com.reydiazz.bodeko.security.auth.web.response.LoginResponse;
import org.springframework.stereotype.Component;

@Component
public class AuthMapper {

    public AuthResponse toResponse(User user) {
        return new AuthResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getSubscriptionLimit()
        );
    }

    public LoginResponse toLoginResponse(String token) {
        return new LoginResponse(token);
    }

}
