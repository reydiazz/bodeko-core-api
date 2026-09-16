package com.reydiazz.bodeko.shared.exceptions;

import lombok.Getter;

/**
 * Excepción personalizada para manejar las reglas de negocio de la aplicación.
 * Permite asociar un código de error estructurado ({@link ErrorCode})
 * que define el estado HTTP, el código interno y el mensaje descriptivo del fallo.
 */
@Getter
public class BusinessException extends RuntimeException {

    private final ErrorCode error;

    /**
     * Construye una nueva excepción de negocio utilizando el mensaje predeterminado
     * proporcionado por el objeto {@link ErrorCode}.
     * @param error el código de error que contiene el detalle y estado HTTP del fallo
     */
    public BusinessException(ErrorCode error) {
        super(error.getMessage());
        this.error = error;
    }

    /**
     * Construye una nueva excepción de negocio sobrescribiendo el mensaje predeterminado
     * del {@link ErrorCode} con un mensaje personalizado o específico del contexto.
     * @param message el mensaje personalizado que describe la excepción
     * @param error   el código de error estructurado asociado
     */
    public BusinessException(String message, ErrorCode error) {
        super(message);
        this.error = error;
    }

}