package com.reydiazz.bodeko.core.user.core.web.response;

import com.reydiazz.bodeko.core.user.core.model.enums.UserDocumentType;
import com.reydiazz.bodeko.core.user.core.model.enums.UserRole;

import java.util.UUID;

public record UserResponse(
        UUID id,
        String email,
        String fullName,
        UserDocumentType documentType,
        String documentNumber,
        UserRole role
) {
}
