package com.reydiazz.bodeko.core.order.payment.exception;

import com.reydiazz.bodeko.shared.exception.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum PaymentErrorCode implements ErrorCode {

    PAYMENT_NOT_FOUND(
            "PAYMENT_NOT_FOUND",
            "Payment with the specified id not found",
            HttpStatus.NOT_FOUND
    );
    private final String code;
    private final String message;
    private final HttpStatus httpStatus;

}
