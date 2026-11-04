package com.reydiazz.bodeko.core.user.core.component;

import com.reydiazz.bodeko.core.user.core.model.entity.User;
import com.reydiazz.bodeko.core.user.core.web.response.UserResponse;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserMapper {

    public UserResponse toResponse (User user) {
        return new UserResponse(
                user.getId(),
                user.getEmail(),
                user.getFullName(),
                user.getDocumentType(),
                user.getDocumentNumber(),
                user.getRole()
        );
    }
}
