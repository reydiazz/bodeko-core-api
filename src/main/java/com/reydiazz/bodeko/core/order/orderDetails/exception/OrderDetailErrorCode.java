package com.reydiazz.bodeko.core.order.orderDetails.exception;

import com.reydiazz.bodeko.shared.exception.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum OrderDetailErrorCode implements ErrorCode {

    ORDER_DETAIL_NOT_FOUND(
            "ORDER_DETAIL_NOT_FOUND",
            "Order detail with the specified id not found",
            HttpStatus.NOT_FOUND
    );
     private final String code;
     private final String message;
     private final HttpStatus httpStatus;
}
