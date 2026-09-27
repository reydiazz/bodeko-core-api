package com.reydiazz.bodeko.core.order.payment.web.controller;

import com.reydiazz.bodeko.core.order.payment.service.PaymentService;
import com.reydiazz.bodeko.core.order.payment.web.request.CreatePaymentRequest;
import com.reydiazz.bodeko.core.order.payment.web.request.UpdatePaymentRequest;
import com.reydiazz.bodeko.core.order.payment.web.response.PaymentResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/order/{orderId}")
    @ResponseStatus(HttpStatus.CREATED)
    public PaymentResponse create(@PathVariable UUID orderId, @Valid @RequestBody CreatePaymentRequest request) {
        return paymentService.create(orderId, request);
    }


    @PutMapping("/{id}")
    public PaymentResponse update(@PathVariable UUID id, @Valid @RequestBody UpdatePaymentRequest request) {
        return paymentService.update(id, request);
    }
}
