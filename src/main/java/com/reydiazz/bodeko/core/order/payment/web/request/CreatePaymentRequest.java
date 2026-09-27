package com.reydiazz.bodeko.core.order.payment.web.request;

import jakarta.validation.constraints.NotBlank;

public record CreatePaymentRequest(

        @NotBlank(message = "Transaction id is required")
        String transactionId,
        @NotBlank(message = "Provider is required")
        String provider
) {
}
