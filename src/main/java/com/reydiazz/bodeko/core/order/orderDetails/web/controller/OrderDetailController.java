package com.reydiazz.bodeko.core.order.orderDetails.web.controller;

import com.reydiazz.bodeko.core.order.orderDetails.service.OrderDetailService;
import com.reydiazz.bodeko.core.order.orderDetails.web.request.CreateOrderDetailRequest;
import com.reydiazz.bodeko.core.order.orderDetails.web.request.UpdateOrderDetailRequest;
import com.reydiazz.bodeko.core.order.orderDetails.web.response.OrderDetailResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/order_details")
@RequiredArgsConstructor
public class OrderDetailController {

    private final OrderDetailService orderDetailService;

    @PostMapping("/order/{orderId}")
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDetailResponse create(@PathVariable UUID orderId, @Valid @RequestBody CreateOrderDetailRequest request) {
        return orderDetailService.create(orderId, request);
    }

    @PutMapping("/{id}")
    public OrderDetailResponse update(@PathVariable UUID id, @Valid @RequestBody UpdateOrderDetailRequest request) {
        return orderDetailService.update(id, request);
    }
}
