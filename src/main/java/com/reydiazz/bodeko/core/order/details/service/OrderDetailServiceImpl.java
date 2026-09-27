package com.reydiazz.bodeko.core.order.details.service;

import com.github.f4b6a3.uuid.UuidCreator;
import com.reydiazz.bodeko.core.order.core.model.entity.Order;
import com.reydiazz.bodeko.core.order.core.service.OrderService;
import com.reydiazz.bodeko.core.order.details.componet.OrderDetailMapper;
import com.reydiazz.bodeko.core.order.details.entity.OrderDetail;
import com.reydiazz.bodeko.core.order.details.exception.OrderDetailNotFoundException;
import com.reydiazz.bodeko.core.order.details.repository.OrderDetailRepository;
import com.reydiazz.bodeko.core.order.details.web.request.CreateOrderDetailRequest;
import com.reydiazz.bodeko.core.order.details.web.request.UpdateOrderDetailRequest;
import com.reydiazz.bodeko.core.order.details.web.response.OrderDetailResponse;
import com.reydiazz.bodeko.core.product.core.model.entity.Product;
import com.reydiazz.bodeko.core.product.core.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderDetailServiceImpl implements OrderDetailService {

    private final OrderDetailRepository orderDetailRepository;
    private final OrderDetailMapper orderDetailMapper;

    private final OrderService orderService;
    private final ProductService productService;


    @Override
    @Transactional(readOnly = true)
    public OrderDetail findEntityById(UUID id) {
        return orderDetailRepository.findById(id)
                .orElseThrow(() -> new OrderDetailNotFoundException(id));
    }

    @Override
    @Transactional
    public OrderDetailResponse create(UUID orderId, CreateOrderDetailRequest request) {

        Order order = orderService.findEntityById(orderId);
        Product product =
                productService.findEntityById(request.productId());

        OrderDetail orderDetail = OrderDetail.builder()
                .id(UuidCreator.getTimeOrderedEpoch())
                .price(product.getPrice())
                .quantity(request.quantity())
                .order(order)
                .product(product)
                .build();

        OrderDetail savedOrderDetail =
                orderDetailRepository.save(orderDetail);

        return orderDetailMapper.toResponse(savedOrderDetail);
    }

    @Override
    @Transactional
    public OrderDetailResponse update(
            UUID id,
            UpdateOrderDetailRequest request
    ) {
        OrderDetail orderDetail = findEntityById(id);
        orderDetail.update(
                request.quantity()
        );
        return orderDetailMapper.toResponse(orderDetail);
    }

}