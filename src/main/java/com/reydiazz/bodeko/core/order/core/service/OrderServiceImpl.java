package com.reydiazz.bodeko.core.order.core.service;

import com.github.f4b6a3.uuid.UuidCreator;
import com.reydiazz.bodeko.core.order.core.component.OrderMapper;
import com.reydiazz.bodeko.core.order.core.exception.OrderNotFoundException;
import com.reydiazz.bodeko.core.order.core.model.entity.Order;
import com.reydiazz.bodeko.core.order.core.model.enums.OrderStatus;
import com.reydiazz.bodeko.core.order.core.repository.OrderRepository;
import com.reydiazz.bodeko.core.order.core.web.request.CreateOrderRequest;
import com.reydiazz.bodeko.core.order.core.web.request.UpdateOrderRequest;
import com.reydiazz.bodeko.core.order.core.web.response.OrderResponse;
import com.reydiazz.bodeko.core.user.store.model.entity.Store;
import com.reydiazz.bodeko.core.user.store.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final StoreService storeService;


    @Override
    @Transactional(readOnly = true)
    public Order findEntityById(UUID id) {

        return orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));
    }

    @Override
    @Transactional
    public OrderResponse create(UUID storeId, CreateOrderRequest request) {

        Store store = storeService.findEntityById(storeId);

        Order order = Order.builder()
                .id(UuidCreator.getTimeOrderedEpoch())
                .name(request.name())
                .clientEmail(request.clientEmail())
                .clientName(request.clientName())
                .total(request.total())
                .status(OrderStatus.PENDING)
                .store(store)
                .build();

        Order savedOrder = orderRepository.save(order);
        return orderMapper.toResponse(savedOrder);
    }

    @Override
    @Transactional
    public OrderResponse update(UUID id, UpdateOrderRequest request) {
        Order order = findEntityById(id);
        order.update(
                request.name(),
                request.clientEmail(),
                request.clientName(),
                request.total(),
                request.status()
        );
        return orderMapper.toResponse(order);
    }
}