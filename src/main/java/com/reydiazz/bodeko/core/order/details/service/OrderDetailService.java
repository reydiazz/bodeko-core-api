package com.reydiazz.bodeko.core.order.details.service;

import com.reydiazz.bodeko.core.order.details.entity.OrderDetail;
import com.reydiazz.bodeko.core.order.details.web.request.CreateOrderDetailRequest;
import com.reydiazz.bodeko.core.order.details.web.request.UpdateOrderDetailRequest;
import com.reydiazz.bodeko.core.order.details.web.response.OrderDetailResponse;

import java.util.UUID;

public interface OrderDetailService {

    OrderDetail findEntityById(UUID id);

    OrderDetailResponse create(UUID orderId, CreateOrderDetailRequest request);

    OrderDetailResponse update(UUID id, UpdateOrderDetailRequest request);
}
