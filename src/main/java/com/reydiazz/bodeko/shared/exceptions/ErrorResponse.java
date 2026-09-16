package com.reydiazz.bodeko.shared.exceptions;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Estructura estandarizada (Data Transfer Object) para las respuestas de error de la API.
 *
 * <p>Esta clase es construida y retornada por el {@link GlobalExceptionHandler} cuando
 * ocurre una excepción en el sistema. Garantiza que el cliente (Frontend o consumidor externo)
 * siempre reciba un formato JSON predecible, independientemente del tipo de fallo.</p>
 */
@Getter
public class ErrorResponse {

    private final int status;
    private final String code;
    private final String message;
    private final List<FieldErrorResponse> fieldErrors;
    private final LocalDateTime timestamp;

    /**
     * Construye la respuesta de error estandarizada mediante el patrón Builder.
     * El campo {@code timestamp} se genera automáticamente al momento de la creación.
     *
     * @param status      el código de estado HTTP nativo
     * @param code        el código de error interno y único de la aplicación
     * @param message     el mensaje descriptivo y legible explicando el motivo del error
     * @param fieldErrors la lista opcional de errores específicos por campo, utilizada principalmente en fallos de validación
     */
    @Builder
    private ErrorResponse(int status, String code, String message, List<FieldErrorResponse> fieldErrors) {
        this.status = status;
        this.code = code;
        this.message = message;
        this.fieldErrors = fieldErrors;
        this.timestamp = LocalDateTime.now();
    }

}