package com.example.bookshop.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;


public class ExceptionResponse {
    private int httpStatus;
    private String message;
    private LocalDateTime localDateTime;

    public ExceptionResponse(int httpStatus, String message, LocalDateTime localDateTime) {
        this.httpStatus = httpStatus;
        this.message = message;
        this.localDateTime = localDateTime;
    }

    public int getHttpStatus() {
        return httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }
}
