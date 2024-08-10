package com.example.library.controller;

import com.example.library.model.Rental;
import com.example.library.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// @RestController 注解用于标记这个类为 RESTful 控制器。
// @RequestMapping 注解用于映射请求的 URL 路径。
@RestController
@RequestMapping("/api/rentals")
public class RentalController {

    private final RentalService rentalService;

    // 构造函数注入 RentalService。
    @Autowired
    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    // @GetMapping 注解用于处理 GET 请求，返回所有租赁的列表。
    @GetMapping
    public List<Rental> getAllRentals() {
        return rentalService.findAll();
    }

    // @GetMapping 注解用于处理 GET 请求，通过租赁 ID 返回特定租赁。
    @GetMapping("/{id}")
    public Rental getRentalById(@PathVariable Long id) {
        return rentalService.findById(id);
    }

    // @PostMapping 注解用于处理 POST 请求，创建新的租赁。
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Rental createRental(@RequestBody Rental rental) {
        return rentalService.save(rental);
    }

    // @PutMapping 注解用于处理 PUT 请求，更新现有的租赁。
    @PutMapping("/{id}")
    public Rental updateRental(@PathVariable Long id, @RequestBody Rental rentalDetails) {
        return rentalService.update(id, rentalDetails);
    }

    // @DeleteMapping 注解用于处理 DELETE 请求，删除指定的租赁。
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRental(@PathVariable Long id) {
        rentalService.delete(id);
    }
}
