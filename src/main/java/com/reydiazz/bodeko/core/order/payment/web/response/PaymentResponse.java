package com.reydiazz.bodeko.core.order.payment.web.response;

import com.reydiazz.bodeko.core.order.payment.model.enums.PaymentStatus;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

public record PaymentResponse(
        UUID id,
        String transactionId,
        BigDecimal amount,
        String provider,
        PaymentStatus status,
        UUID orderId,
        OffsetDateTime createdAt
) {
}
