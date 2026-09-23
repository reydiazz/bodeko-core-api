package com.reydiazz.bodeko.core.product.core.web.request;

import com.reydiazz.bodeko.core.product.categories.entity.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;

public record UpdateProductRequest(
        @NotBlank(message = "Product name is required")
        String name,
        String description,
        @NotNull(message = "Price is required")
        @Positive(message = "Price must be greater than 0")
        BigDecimal price,
        @NotNull(message = "Stock is required")
        @PositiveOrZero(message = "Stock cannot be negative")
        Integer stock,
        @NotNull(message = "Category is required")
        Category category
        ) {
}
