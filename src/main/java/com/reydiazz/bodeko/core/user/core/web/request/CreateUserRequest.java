package com.reydiazz.bodeko.core.user.core.web.request;

import com.reydiazz.bodeko.core.user.core.model.enums.UserDocumentType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CreateUserRequest(

        @NotBlank(message = "Email is required")
        @Email(message = "Email format is invalid")
        @Size(max = 255, message = "Email must have at most 255 characters")
        String email,

        @NotBlank(message = "Password is required")
        @Size(min = 8, message = "Password must have at least 8 characters")
        String password,

        @NotBlank(message = "Full name is required")
        @Size(max = 150, message = "Full name must have at most 150 characters")
        String fullName,

        UserDocumentType documentType,

        @Size(max = 20, message = "Document number must have at most 20 characters")
        String documentNumber


) {
}
