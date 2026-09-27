package com.reydiazz.bodeko.core.order.orderDetails.web.response;

import java.math.BigDecimal;
import java.util.UUID;

public record OrderDetailResponse(
        UUID id,
        BigDecimal price,
        Integer quantity,
        UUID orderId,
        UUID productId
) {
}
