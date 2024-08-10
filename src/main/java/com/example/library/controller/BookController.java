package com.example.library.controller;

import com.example.library.model.Book;
import com.example.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// @RestController 注解用于标记这个类为 RESTful 控制器。
// @RequestMapping 注解用于映射请求的 URL 路径。
@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    // 构造函数注入 BookService。
    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // @GetMapping 注解用于映射 HTTP GET 请求。
    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.findAll();
    }

    // @GetMapping 注解用于映射 HTTP GET 请求并使用 @PathVariable 提取 URL 路径中的变量。
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookService.findById(id);
    }

    // @PostMapping 注解用于映射 HTTP POST 请求。
    // @RequestBody 注解用于从请求体中提取 JSON 数据并转换为 Book 对象。
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // @ResponseStatus 注解用于设置返回状态码为 201 (Created)。
    public Book createBook(@RequestBody Book book) {
        return bookService.save(book);
    }

    // @PutMapping 注解用于映射 HTTP PUT 请求。
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book bookDetails) {
        return bookService.update(id, bookDetails);
    }

    // @DeleteMapping 注解用于映射 HTTP DELETE 请求。
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // 设置返回状态码为 204 (No Content)。
    public void deleteBook(@PathVariable Long id) {
        bookService.delete(id);
    }
}
