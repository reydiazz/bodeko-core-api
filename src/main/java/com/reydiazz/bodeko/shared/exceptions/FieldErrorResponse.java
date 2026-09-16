package com.reydiazz.bodeko.shared.exceptions;

/**
 * Representa un error de validación específico para un campo individual de una petición HTTP.
 *
 * <p>Este registro (record) es utilizado por él {@link GlobalExceptionHandler} para desglosar
 * y detallar qué atributos exactos fallaron durante las validaciones de entrada
 * (por ejemplo, cuando se violan restricciones de Jakarta Validation como @NotNull o @Email).</p>
 *
 * @param field   el nombre del atributo o campo de la petición que falló la validación (ej. "username", "correo")
 * @param message el mensaje descriptivo que explica por qué el campo es inválido (ej. "El campo no puede estar vacío")
 */
public record FieldErrorResponse(
        String field,
        String message
) {
}