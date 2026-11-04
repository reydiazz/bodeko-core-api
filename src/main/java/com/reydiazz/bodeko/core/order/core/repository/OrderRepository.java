package com.reydiazz.bodeko.core.order.core.repository;

import com.reydiazz.bodeko.core.order.core.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, UUID >{
}
