package com.reydiazz.bodeko.core.order.core.exception;

import java.util.UUID;

public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(UUID id) {
        super("Order not find order with id " + id);
    }
}
