package com.example.bookshop.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ApplicationExceptionController {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionResponse> ResourceNotFoundExceptionHandler(ResourceNotFoundException exception) {
        return prepareResponseObject(HttpStatus.NOT_FOUND, exception.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ExceptionResponse> IllegalArgumentExceptionHandler(IllegalArgumentException exception) {
        return prepareResponseObject(HttpStatus.BAD_REQUEST, exception.getMessage());
    }

    private ResponseEntity<ExceptionResponse> prepareResponseObject(HttpStatus httpStatus, String message) {
        return new ResponseEntity<>(prepareExceptionResponse(httpStatus, message), httpStatus);
    }

    private ExceptionResponse prepareExceptionResponse(HttpStatus httpStatus, String message) {
        return new ExceptionResponse(httpStatus.value(), message, LocalDateTime.now());
    }
}
