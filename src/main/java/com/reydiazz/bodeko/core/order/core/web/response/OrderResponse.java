package com.reydiazz.bodeko.core.order.core.web.response;

import com.reydiazz.bodeko.core.order.core.model.enums.OrderStatus;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

public record OrderResponse(
        UUID id,
        String name,
        String clientEmail,
        String clientName,
        BigDecimal total,
        OrderStatus status,
        UUID storeId,
        OffsetDateTime createdAt
) {
}
