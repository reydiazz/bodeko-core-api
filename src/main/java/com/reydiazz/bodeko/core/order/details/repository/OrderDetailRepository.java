package com.reydiazz.bodeko.core.order.details.repository;

import com.reydiazz.bodeko.core.order.details.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, UUID> {
}
