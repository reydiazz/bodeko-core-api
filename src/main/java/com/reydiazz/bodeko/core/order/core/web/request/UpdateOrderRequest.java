package com.reydiazz.bodeko.core.order.core.web.request;

import com.reydiazz.bodeko.core.order.core.model.enums.OrderStatus;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record UpdateOrderRequest(
        String name,
        @NotBlank(message = "Client email is required")
        @Email(message = "Client email must be valid")
        String clientEmail,
        @NotBlank(message = "Client name is required")
        String clientName,
        @NotNull(message = "Total is required")
        @Positive(message = "Total must be greater than 0")
        BigDecimal total,
        @NotNull(message = "Status is required")
        OrderStatus status
) {
}
