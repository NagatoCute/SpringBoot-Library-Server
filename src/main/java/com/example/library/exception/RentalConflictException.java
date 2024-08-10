package com.example.library.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// @ResponseStatus 注解用于将这个异常映射到 HTTP 409 (Conflict) 状态码。
@ResponseStatus(HttpStatus.CONFLICT)
public class RentalConflictException extends RuntimeException {
    public RentalConflictException(String message) {
        super(message);
    }
}
