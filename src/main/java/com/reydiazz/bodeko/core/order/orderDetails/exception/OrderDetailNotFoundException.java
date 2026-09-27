package com.reydiazz.bodeko.core.order.orderDetails.exception;

import java.util.UUID;

public class OrderDetailNotFoundException extends RuntimeException {
    public OrderDetailNotFoundException(UUID id) {
        super("Order Detail not find order with id" + id );
    }
}
