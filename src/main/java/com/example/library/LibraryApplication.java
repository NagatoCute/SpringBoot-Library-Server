package com.example.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootApplication 注解用于标识这是一个 Spring Boot 应用程序的主类。
// 它是一个复合注解，包含了 @Configuration, @EnableAutoConfiguration, 和 @ComponentScan。
@SpringBootApplication
public class LibraryApplication {

    // 应用程序的入口点，启动 Spring 应用。
    public static void main(String[] args) {
        SpringApplication.run(LibraryApplication.class, args);
    }
}
