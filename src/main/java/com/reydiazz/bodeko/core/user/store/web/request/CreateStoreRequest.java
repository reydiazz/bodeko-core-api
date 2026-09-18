package com.reydiazz.bodeko.core.user.store.web.request;

import jakarta.validation.constraints.NotBlank;

public record CreateStoreRequest(
        @NotBlank(message = "Store name is required")
        String name
) {
}