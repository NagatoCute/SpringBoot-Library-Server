package com.example.library.service;

import com.example.library.exception.RentalConflictException;
import com.example.library.exception.RentalNotFoundException;
import com.example.library.model.Rental;
import com.example.library.repository.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

// @Service 注解标记这个类为服务层组件。
@Service
public class RentalService {

    private final RentalRepository rentalRepository;

    // 构造函数注入 RentalRepository。
    @Autowired
    public RentalService(RentalRepository rentalRepository) {
        this.rentalRepository = rentalRepository;
    }

    // @Transactional 注解用于标记这个方法在事务中执行。
    @Transactional(readOnly = true)
    public List<Rental> findAll() {
        return rentalRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Rental findById(Long id) {
        return rentalRepository.findById(id).orElseThrow(() -> new RentalNotFoundException(id));
    }

    @Transactional
    public Rental save(Rental rental) {
        // 检查是否已存在相同的借阅记录
        List<Rental> existingRentals = rentalRepository.findByBookIdAndStartDateAndEndDate(
                rental.getBook().getId(),
                rental.getStartDate(),
                rental.getEndDate()
        );

        if (!existingRentals.isEmpty()) {
            throw new RentalConflictException("This book is already rented for the specified period.");
        }

        return rentalRepository.save(rental);
    }

    @Transactional
    public Rental update(Long id, Rental rentalDetails) {
        Rental rental = findById(id);
        rental.setStartDate(rentalDetails.getStartDate());
        rental.setEndDate(rentalDetails.getEndDate());
        rental.setBook(rentalDetails.getBook());
        return rentalRepository.save(rental);
    }

    @Transactional
    public void delete(Long id) {
        Rental rental = findById(id);
        rentalRepository.delete(rental);
    }
}
