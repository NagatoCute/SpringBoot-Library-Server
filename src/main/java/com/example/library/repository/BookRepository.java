package com.example.library.repository;

import com.example.library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// @Repository 注解标记这个接口为持久化层组件。
// 继承 JpaRepository 提供了 CRUD 操作方法。
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
