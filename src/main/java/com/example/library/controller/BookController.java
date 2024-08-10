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

    // @GetMapping 注解用于处理 GET 请求，返回所有书籍的列表。
    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.findAll();
    }

    // @GetMapping 注解用于处理 GET 请求，通过书籍 ID 返回特定书籍。
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookService.findById(id);
    }

    // @PostMapping 注解用于处理 POST 请求，创建新的书籍。
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book createBook(@RequestBody Book book) {
        return bookService.save(book);
    }

    // @PutMapping 注解用于处理 PUT 请求，更新现有的书籍。
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book bookDetails) {
        return bookService.update(id, bookDetails);
    }

    // @DeleteMapping 注解用于处理 DELETE 请求，删除指定的书籍。
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable Long id) {
        bookService.delete(id);
    }
}
