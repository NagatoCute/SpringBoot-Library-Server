package com.example.library.service;

import com.example.library.exception.RentalConflictException;
import com.example.library.exception.RentalNotFoundException;
import com.example.library.model.Rental;
import com.example.library.repository.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class RentalService {

    private final RentalRepository rentalRepository;

    @Autowired
    public RentalService(RentalRepository rentalRepository) {
        this.rentalRepository = rentalRepository;
    }

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
        // 检查是否有重叠的租赁记录
        List<Rental> existingRentals = rentalRepository.findByBookId(rental.getBook().getId());

        for (Rental existingRental : existingRentals) {
            if (isOverlapping(rental.getStartDate(), rental.getEndDate(), existingRental.getStartDate(), existingRental.getEndDate())) {
                throw new RentalConflictException("This book is already rented for the specified period.");
            }
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

    // 检查时间段是否重叠
    private boolean isOverlapping(LocalDate start1, LocalDate end1, LocalDate start2, LocalDate end2) {
        return start1.isBefore(end2) && end1.isAfter(start2);
    }
}
