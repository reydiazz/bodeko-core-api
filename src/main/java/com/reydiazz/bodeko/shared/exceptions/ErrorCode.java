package com.reydiazz.bodeko.shared.exceptions;

import org.springframework.http.HttpStatus;

/**
 * Interfaz que representa un código de error específico de la aplicación.
 */
public interface ErrorCode {

    /**
     * Obtiene el estado HTTP asociado con el error.
     * @return el código {@link HttpStatus}
     */
    HttpStatus getHttpStatus();

    /**
     * Obtiene el mensaje predeterminado que explica el error.
     * @return un {@link String} que contiene el mensaje de error
     */
    String getMessage();

    /**
     * Obtiene la cadena única del código de error de la aplicación.
     * @return un {@link String} que representa el código de error único
     */
    String getCode();

}
