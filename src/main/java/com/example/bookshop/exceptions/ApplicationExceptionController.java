package com.example.bookshop.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

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
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponse> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        HashMap<String,String> errors=new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName,errorMessage);

        });
        return prepareResponseObject(HttpStatus.BAD_REQUEST,errors.toString());
    }

    private ResponseEntity<ExceptionResponse> prepareResponseObject(HttpStatus httpStatus, String message) {
        return new ResponseEntity<>(new ExceptionResponse(httpStatus.value(), message, LocalDateTime.now()), httpStatus);
    }
}
