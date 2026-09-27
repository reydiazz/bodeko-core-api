package com.reydiazz.bodeko.core.order.orderDetails.repository;

import com.reydiazz.bodeko.core.order.orderDetails.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderDetailsRepository  extends JpaRepository<OrderDetails, UUID> {
}
