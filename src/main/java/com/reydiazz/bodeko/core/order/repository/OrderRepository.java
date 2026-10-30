package com.reydiazz.bodeko.core.order.repository;

import com.reydiazz.bodeko.core.order.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, UUID >{
}
