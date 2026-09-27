package com.reydiazz.bodeko.core.order.payment.component;

import com.reydiazz.bodeko.core.order.payment.model.entity.Payment;
import com.reydiazz.bodeko.core.order.payment.web.response.PaymentResponse;
import org.springframework.stereotype.Component;

@Component
public class PaymentMapper {

    public PaymentResponse toResponse(Payment payment){
          return new PaymentResponse(
                  payment.getId(),
                  payment.getTransactionId(),
                  payment.getAmount(),
                  payment.getProvider(),
                  payment.getStatus(),
                  payment.getOrder().getId(),
                  payment.getCreatedAt()
          );
    }

}
