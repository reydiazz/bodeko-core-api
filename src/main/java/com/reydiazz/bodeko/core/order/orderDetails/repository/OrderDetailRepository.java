package com.reydiazz.bodeko.core.order.orderDetails.repository;

import com.reydiazz.bodeko.core.order.orderDetails.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, UUID> {
}
