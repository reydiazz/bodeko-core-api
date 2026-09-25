package com.reydiazz.bodeko.core.product.categories.exception;

import com.reydiazz.bodeko.shared.exception.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum CategoryErrorCode  implements ErrorCode {

    CATEGORY_NOT_FOUND(
            "CATEGORY NOY_FOUND",
            "Category with the specified id not found",
            HttpStatus.NOT_FOUND
    );
    private final String code;
    private final String message;
    private final HttpStatus httpStatus;
}
