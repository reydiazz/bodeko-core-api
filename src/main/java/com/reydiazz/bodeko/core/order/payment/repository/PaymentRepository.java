package com.reydiazz.bodeko.core.order.payment.repository;

import com.reydiazz.bodeko.core.order.payment.model.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PaymentRepository extends JpaRepository<Payment, UUID> {
}
