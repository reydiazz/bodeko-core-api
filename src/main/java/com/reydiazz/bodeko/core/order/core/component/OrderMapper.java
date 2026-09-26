package com.reydiazz.bodeko.core.order.core.component;

import com.reydiazz.bodeko.core.order.core.model.entity.Order;
import com.reydiazz.bodeko.core.order.core.web.response.OrderResponse;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {
    public OrderResponse toResponse(Order order) {

        return new OrderResponse(
                order.getId(),
                order.getName(),
                order.getClientEmail(),
                order.getClientName(),
                order.getTotal(),
                order.getStatus(),
                order.getStore().getId(),
                order.getCreatedAt()
        );
    }
}
