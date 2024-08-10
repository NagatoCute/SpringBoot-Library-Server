package com.example.library.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// @ResponseStatus 注解用于定义异常的 HTTP 状态码。
@ResponseStatus(HttpStatus.NOT_FOUND)
public class RentalNotFoundException extends RuntimeException {

    // 构造函数用于创建异常实例，包含错误信息。
    public RentalNotFoundException(Long id) {
        super("Could not find rental with ID: " + id);
    }
}
