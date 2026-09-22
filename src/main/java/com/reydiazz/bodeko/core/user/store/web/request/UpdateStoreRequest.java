package com.reydiazz.bodeko.core.user.store.web.request;

import jakarta.validation.constraints.NotBlank;

public record UpdateStoreRequest(
        @NotBlank(message = "Store name is required")
        String name
) {
}