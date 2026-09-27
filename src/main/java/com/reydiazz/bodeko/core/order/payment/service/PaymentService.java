package com.reydiazz.bodeko.core.order.payment.service;

import com.reydiazz.bodeko.core.order.payment.model.entity.Payment;
import com.reydiazz.bodeko.core.order.payment.web.request.CreatePaymentRequest;
import com.reydiazz.bodeko.core.order.payment.web.request.UpdatePaymentRequest;
import com.reydiazz.bodeko.core.order.payment.web.response.PaymentResponse;

import java.util.UUID;

public interface PaymentService {

    Payment findEntityById(UUID id);

    PaymentResponse create(UUID orderId, CreatePaymentRequest request);

    PaymentResponse update(UUID id, UpdatePaymentRequest request);
}
