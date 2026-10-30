package com.reydiazz.bodeko.core.order.items.repository;

import com.reydiazz.bodeko.core.order.items.model.entity.OrderItem;
import com.reydiazz.bodeko.core.order.items.model.entity.OrderItemId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemId> {
}
