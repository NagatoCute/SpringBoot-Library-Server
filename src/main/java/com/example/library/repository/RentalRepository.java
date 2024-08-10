package com.example.library.repository;

import com.example.library.model.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

// @Repository 注解标记这个接口为持久化层组件。
// 继承 JpaRepository 提供了 CRUD 操作方法。
@Repository
public interface RentalRepository extends JpaRepository<Rental, Long> {
    List<Rental> findByBookIdAndStartDateAndEndDate(Long bookId, LocalDate startDate, LocalDate endDate);
}
