package com.reydiazz.bodeko.core.order.orderDetails.service;

import com.reydiazz.bodeko.core.order.orderDetails.entity.OrderDetail;
import com.reydiazz.bodeko.core.order.orderDetails.web.request.CreateOrderDetailRequest;
import com.reydiazz.bodeko.core.order.orderDetails.web.request.UpdateOrderDetailRequest;
import com.reydiazz.bodeko.core.order.orderDetails.web.response.OrderDetailResponse;

import java.util.UUID;

public interface OrderDetailService {

    OrderDetail findEntityById(UUID id);

    OrderDetailResponse create(UUID orderId, CreateOrderDetailRequest request);

    OrderDetailResponse update(UUID id, UpdateOrderDetailRequest request);
}
