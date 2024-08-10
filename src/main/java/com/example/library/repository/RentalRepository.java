package com.example.library.repository;

import com.example.library.model.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Long> {
    List<Rental> findByBookId(Long bookId);

    // 检查是否存在重叠的租赁记录
    List<Rental> findByBookIdAndStartDateBeforeAndEndDateAfter(Long bookId, LocalDate endDate, LocalDate startDate);
}
