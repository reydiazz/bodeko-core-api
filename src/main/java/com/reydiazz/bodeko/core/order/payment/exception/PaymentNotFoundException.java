package com.reydiazz.bodeko.core.order.payment.exception;

import java.util.UUID;

public class PaymentNotFoundException extends RuntimeException {
    public PaymentNotFoundException(UUID id) {
        super("Payment not found for order with id" + id);
    }
}
