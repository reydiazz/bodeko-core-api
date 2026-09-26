package com.reydiazz.bodeko.core.order.core.web.controller;

import com.reydiazz.bodeko.core.order.core.service.OrderService;
import com.reydiazz.bodeko.core.order.core.web.request.CreateOrderRequest;
import com.reydiazz.bodeko.core.order.core.web.request.UpdateOrderRequest;
import com.reydiazz.bodeko.core.order.core.web.response.OrderResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/store/storeId")
    @ResponseStatus(HttpStatus.CREATED)
    public OrderResponse create(@PathVariable UUID storeId, @Valid @RequestBody CreateOrderRequest request){

        return orderService.create(storeId, request);
    }

    @PutMapping("/{id}")
    public OrderResponse update(@PathVariable UUID id, @Valid @RequestBody UpdateOrderRequest request){
        return orderService.update(id, request);
    }
}
