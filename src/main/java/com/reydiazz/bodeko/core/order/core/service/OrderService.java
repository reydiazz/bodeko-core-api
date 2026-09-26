package com.reydiazz.bodeko.core.order.core.service;

import com.reydiazz.bodeko.core.order.core.model.entity.Order;
import com.reydiazz.bodeko.core.order.core.web.request.CreateOrderRequest;
import com.reydiazz.bodeko.core.order.core.web.request.UpdateOrderRequest;
import com.reydiazz.bodeko.core.order.core.web.response.OrderResponse;

import java.util.UUID;

public interface OrderService {

    Order findEntityById(UUID id);

    OrderResponse create(UUID storeId, CreateOrderRequest request);

    OrderResponse update(UUID id, UpdateOrderRequest request);
}
