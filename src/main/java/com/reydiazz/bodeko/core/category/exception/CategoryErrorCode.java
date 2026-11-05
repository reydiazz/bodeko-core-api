package com.reydiazz.bodeko.core.category.exception;

import com.reydiazz.bodeko.shared.exception.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.flywaydb.core.api.callback.Error;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum CategoryErrorCode implements ErrorCode {

    NAME_ALREADY_IN_USE(
            "CATEGORY_NAME_ALREADY_IN_USE",
            "The name is already in use.",
            HttpStatus.CONFLICT
    ),

    ENTITY_NOT_FOUND(
            "CATEGORY_NOT_FOUND",
            "The category does not exist.",
            HttpStatus.NOT_FOUND
    );

    private final String code;
    private final String message;
    private final HttpStatus httpStatus;

}
