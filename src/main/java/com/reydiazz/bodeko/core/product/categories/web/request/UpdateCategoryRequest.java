package com.reydiazz.bodeko.core.product.categories.web.request;

import jakarta.validation.constraints.NotBlank;

public record UpdateCategoryRequest(
        @NotBlank(message = "Category name is required")
        String name
) {
}
