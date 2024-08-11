package com.example.library;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

// @SpringBootTest 注解用于标记一个测试类，表示该测试类需要启动整个 Spring Boot 容器。
@SpringBootTest
class LibraryApplicationTests {

    // @Test 注解用于标记一个测试方法。
    @Test
    void contextLoads() {
        // 这个测试方法用于检查 Spring 应用程序上下文是否可以正确加载。
    }
}
