package com.reydiazz.bodeko.core.order.payment.web.request;

import com.reydiazz.bodeko.core.order.payment.model.enums.PaymentStatus;
import jakarta.validation.constraints.NotNull;

public record UpdatePaymentRequest(

        @NotNull(message = "Payment status is required")
        PaymentStatus status
) {
}
