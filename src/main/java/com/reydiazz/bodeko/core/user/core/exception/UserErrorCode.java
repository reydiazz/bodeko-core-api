package com.reydiazz.bodeko.core.user.core.exception;

import com.reydiazz.bodeko.shared.exception.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum UserErrorCode implements ErrorCode {


    EMAIL_ALREADY_IN_USE(
            HttpStatus.CONFLICT,
            "The email is already in use."
    ),
    DOCUMENT_INCOMPLETE(
            HttpStatus.BAD_REQUEST,
            "Document type and document number must be provided together."
    ),
    INVALID_DOCUMENT_NUMBER(
            HttpStatus.BAD_REQUEST,
            "The document number does not match the format of the selected document type."
    );

    private final HttpStatus httpStatus;
    private final String message;

    @Override
    public String getCode() {
        return name();
    }
}
