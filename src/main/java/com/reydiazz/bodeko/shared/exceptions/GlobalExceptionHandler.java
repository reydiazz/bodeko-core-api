package com.reydiazz.bodeko.shared.exceptions;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.List;

/**
 * Controlador global de excepciones para toda la aplicación.
 * Intercepta las excepciones lanzadas en los controladores y servicios,
 * transformándolas en respuestas de error estandarizadas en formato JSON
 * definidas por {@link ErrorResponse}.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Maneja las excepciones de negocio personalizadas.
     *
     * @param exception la excepción de negocio capturada
     * @return un {@link ResponseEntity} con el estado HTTP correspondiente y la estructura de error
     */
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponse> handlerBusiness(BusinessException exception) {
        ErrorCode error = exception.getError();
        HttpStatus status = error.getHttpStatus();
        ErrorResponse response = ErrorResponse.builder()
                .status(status.value())
                .code(error.getCode())
                .message(error.getMessage())
                .build();
        return ResponseEntity.status(status).body(response);
    }

    /**
     * Maneja los errores de validación cuando los datos de entrada en las solicitudes fallan
     * (por ejemplo, violaciones a las anotaciones de Jakarta Validation).
     *
     * @param exception la excepción de argumentos no válidos
     * @return un {@link ResponseEntity} con estado HTTP 400 (Bad Request) y el detalle de los campos erróneos
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidation(MethodArgumentNotValidException exception) {
        List<FieldErrorResponse> fieldErrors = exception.getBindingResult().getFieldErrors().stream().map(
                error -> new FieldErrorResponse(error.getField(), error.getDefaultMessage())).toList();
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ErrorResponse response = ErrorResponse.builder()
                .status(status.value())
                .code("VALIDATION_ERROR")
                .message("One or more fields are invalid.")
                .fieldErrors(fieldErrors)
                .build();
        return ResponseEntity.status(status).body(response);
    }

    /**
     * Maneja errores cuando el cuerpo de la petición HTTP tiene un formato inválido o incomprensible.
     *
     * @param exception la excepción de lectura de mensaje HTTP
     * @return un {@link ResponseEntity} con estado HTTP 400 (Bad Request)
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> handleHttpMessageNotReadable(HttpMessageNotReadableException exception) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ErrorResponse response = ErrorResponse.builder()
                .status(status.value())
                .code("INVALID_REQUEST")
                .message("The request body contains invalid values for one or more fields.")
                .build();
        return ResponseEntity.status(status).body(response);
    }

    /**
     * Maneja los intentos de acceso a rutas existentes utilizando una función HTTP no soportada.
     *
     * @param exception la excepción de función no soportada
     * @return un {@link ResponseEntity} con estado HTTP 405 (Method Not Allowed)
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ErrorResponse> handleMethodNotSupported(HttpRequestMethodNotSupportedException exception) {
        HttpStatus status = HttpStatus.METHOD_NOT_ALLOWED;
        ErrorResponse response = ErrorResponse.builder()
                .status(status.value())
                .code("METHOD_NOT_ALLOWED")
                .message("The HTTP method '%s' is not supported for this route.".formatted(exception.getMethod()))
                .build();
        return ResponseEntity.status(status).body(response);
    }

    /**
     * Maneja las peticiones dirigidas a rutas o recursos que no existen en la aplicación.
     *
     * @param exception la excepción de recurso no encontrado
     * @return un {@link ResponseEntity} con estado HTTP 404 (Not Found)
     */
    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<ErrorResponse> handleNoResourceFound(NoResourceFoundException exception) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        ErrorResponse response = ErrorResponse.builder()
                .status(status.value())
                .code("RESOURCE_NOT_FOUND")
                .message("The requested route does not exist.")
                .build();
        return ResponseEntity.status(status).body(response);
    }

    /**
     * Maneja las violaciones de integridad a nivel de base de datos
     * (por ejemplo, violación de restricciones de unicidad o llaves foráneas).
     *
     * @param exception la excepción de violación de integridad de datos
     * @return un {@link ResponseEntity} con estado HTTP 409 (Conflict)
     */
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorResponse> handleDataIntegrityViolation(DataIntegrityViolationException exception) {
        HttpStatus status = HttpStatus.CONFLICT;
        ErrorResponse response = ErrorResponse.builder()
                .status(status.value())
                .code("DATA_INTEGRITY_VIOLATION")
                .message("The operation could not be executed due to database integrity constraints.")
                .build();
        return ResponseEntity.status(status).body(response);
    }

    /**
     * Controlador global por defecto para cualquier excepción no controlada.
     * Evita que el servidor filtre trazas técnicas (stack traces) al cliente.
     *
     * @param exception la excepción genérica no capturada
     * @return un {@link ResponseEntity} con estado HTTP 500 (Internal Server Error)
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception exception) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        ErrorResponse response = ErrorResponse.builder()
                .status(status.value())
                .code("INTERNAL_SERVER_ERROR")
                .message("An unexpected error occurred.")
                .build();
        return ResponseEntity.status(status).body(response);
    }

    /**
     * Maneja las excepciones producidas cuando las credenciales de autenticación
     * proporcionadas no son válidas.
     *
     * @param exception la excepción de credenciales inválidas capturada
     * @return un {@link ResponseEntity} con estado HTTP 401 (Unauthorized)
     * y la estructura de error correspondiente
     */
    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ErrorResponse> handleBadCredentials(BadCredentialsException exception) {
        HttpStatus status = HttpStatus.UNAUTHORIZED;
        ErrorResponse response = ErrorResponse.builder()
                .status(status.value())
                .code("BAD_CREDENTIALS")
                .message("Email or password incorrect.")
                .build();
        return ResponseEntity.status(status).body(response);
    }

    /**
     * Maneja las excepciones producidas cuando una cuenta de usuario se encuentra
     * deshabilitada y, por lo tanto, no tiene permitido acceder al recurso.
     *
     * @param exception la excepción de cuenta deshabilitada capturada
     * @return un {@link ResponseEntity} con estado HTTP 403 (Forbidden)
     * y la estructura de error correspondiente
     */
    @ExceptionHandler(DisabledException.class)
    public ResponseEntity<ErrorResponse> handleDisabledException(DisabledException exception) {
        HttpStatus status = HttpStatus.FORBIDDEN;
        ErrorResponse response = ErrorResponse.builder()
                .status(status.value())
                .code("ACCOUNT_DISABLED")
                .message("Access is denied because your account is disabled.")
                .build();
        return ResponseEntity.status(status).body(response);
    }

    /**
     * Maneja las excepciones producidas cuando se intenta acceder a un recurso
     * protegido sin proporcionar las credenciales de autenticación requeridas.
     *
     * @param exception la excepción de credenciales de autenticación no encontradas
     * @return un {@link ResponseEntity} con estado HTTP 401 (Unauthorized)
     * y la estructura de error correspondiente
     */
    @ExceptionHandler(AuthenticationCredentialsNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleAuthenticationCredentialsNotFound(AuthenticationCredentialsNotFoundException exception) {
        HttpStatus status = HttpStatus.UNAUTHORIZED;
        ErrorResponse response = ErrorResponse.builder()
                .status(status.value())
                .code("AUTHENTICATION_REQUIRED")
                .message("Authentication credentials were not found.")
                .build();
        return ResponseEntity.status(status).body(response);
    }

    /**
     * Maneja las excepciones lanzadas cuando un parámetro de la petición no puede ser
     * convertido al tipo de dato esperado por el controlador.
     *
     * @param exception Excepción capturada automáticamente por Spring con los detalles del desajuste de tipos.
     * @return un {@link ResponseEntity} con estado HTTP 400 (Bad Request)
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorResponse> handleTypeMismatch(MethodArgumentTypeMismatchException exception) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ErrorResponse response = ErrorResponse.builder()
                .status(status.value())
                .code("INVALID_PARAMETER_TYPE")
                .message("The data type of a provided parameter is invalid.")
                .build();
        return ResponseEntity.status(status).body(response);
    }

}