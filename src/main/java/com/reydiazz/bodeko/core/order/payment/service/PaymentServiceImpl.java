package com.reydiazz.bodeko.core.order.payment.service;

import com.github.f4b6a3.uuid.UuidCreator;
import com.reydiazz.bodeko.core.order.core.model.entity.Order;
import com.reydiazz.bodeko.core.order.core.service.OrderService;
import com.reydiazz.bodeko.core.order.payment.component.PaymentMapper;
import com.reydiazz.bodeko.core.order.payment.exception.PaymentNotFoundException;
import com.reydiazz.bodeko.core.order.payment.model.entity.Payment;
import com.reydiazz.bodeko.core.order.payment.model.enums.PaymentStatus;
import com.reydiazz.bodeko.core.order.payment.repository.PaymentRepository;
import com.reydiazz.bodeko.core.order.payment.web.request.CreatePaymentRequest;
import com.reydiazz.bodeko.core.order.payment.web.request.UpdatePaymentRequest;
import com.reydiazz.bodeko.core.order.payment.web.response.PaymentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final PaymentMapper paymentMapper;
    private final OrderService orderService;


    @Override
    @Transactional(readOnly = true)
    public Payment findEntityById(UUID id) {

        return paymentRepository.findById(id)
                .orElseThrow(() -> new PaymentNotFoundException(id));
    }


    @Override
    @Transactional
    public PaymentResponse create(UUID orderId, CreatePaymentRequest request) {

        Order order = orderService.findEntityById(orderId);

        Payment payment = Payment.builder()
                .id(UuidCreator.getTimeOrderedEpoch())
                .transactionId(request.transactionId())
                .amount(order.getTotal())
                .provider(request.provider())
                .status(PaymentStatus.PENDING)
                .order(order)
                .build();

        Payment savedPayment = paymentRepository.save(payment);

        return paymentMapper.toResponse(savedPayment);
    }


    @Override
    @Transactional
    public PaymentResponse update(UUID id, UpdatePaymentRequest request) {

        Payment payment = findEntityById(id);
        payment.update(request.status());

        return paymentMapper.toResponse(payment);
    }
}