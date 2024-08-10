package com.example.library.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// @ResponseStatus 注解用于定义响应状态码，当抛出这个异常时返回 404 (Not Found)。
@ResponseStatus(HttpStatus.NOT_FOUND)
public class BookNotFoundException extends RuntimeException {

    // 构造函数接收书籍 ID，并生成异常消息。
    public BookNotFoundException(Long id) {
        super("Book with id " + id + " not found.");
    }
}
