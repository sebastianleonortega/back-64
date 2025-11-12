package com.base64.gamesback.common.exception_handler;

import com.base64.gamesback.common.exception.AccessDeniedException;
import com.base64.gamesback.common.exception.AlreadyExistException;
import com.base64.gamesback.common.exception.ResourceNotFoundException;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Clase que maneja las excepciones de la aplicación y proporciona respuestas de error adecuadas.
 */
@RestControllerAdvice
public class AppExceptionHandler {

    private final HttpSession httpSession;

    public AppExceptionHandler(HttpSession httpSession) {
        this.httpSession = httpSession;
    }

    /**
     * Maneja la excepción de argumento ilegal.
     *
     * @param exception la excepción IllegalArgumentException
     * @return un record con el mensaje de error y el mensaje de la excepción
     */
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorResponse> handleIllegalArgumentException(IllegalArgumentException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(exception.getMessage(), "Bad Request"));
    }

    /**
     * Maneja la excepción de credenciales incorrectas.
     *
     * @param exception la excepción AccessDeniedException
     * @return un record con el mensaje de error y el mensaje de la excepción
     */
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ErrorResponse> handleAuthenticationException(AccessDeniedException exception) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new ErrorResponse(exception.getMessage(), "Acceso denegado"));
    }

    /**
     * Maneja la excepción de registros no encontrados.
     *
     * @param exception la excepción ResourceNotFoundException
     * @return un record con el mensaje de error y el mensaje de la excepción
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(exception.getMessage(), "Not Found"));
    }

    /**
     * Maneja la excepción de conflictos en los registros.
     *
     * @param exception la excepción AlreadyExistException
     * @return un record con el mensaje de error y el mensaje de la excepción
     */
    @ExceptionHandler(AlreadyExistException.class)
    public ResponseEntity<ErrorResponse> handleAlreadyExistException(AlreadyExistException exception) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorResponse(exception.getMessage(), "Already Exist"));
    }
}
