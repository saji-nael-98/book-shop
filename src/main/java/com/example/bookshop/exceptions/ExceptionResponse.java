package com.example.bookshop.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class ExceptionResponse {
    private int httpStatus;
    private String message;
    private String localDateTime;

    public ExceptionResponse(int httpStatus, String message, LocalDateTime localDateTime) {
        this.httpStatus = httpStatus;
        this.message = message;
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        this.localDateTime = localDateTime.format(format);
    }

    public int getHttpStatus() {
        return httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public String getLocalDateTime() {
        return localDateTime;
    }
}
