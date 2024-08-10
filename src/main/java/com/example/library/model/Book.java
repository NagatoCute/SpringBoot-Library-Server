package com.example.library.model;

import javax.persistence.*;

// @Entity 注解标记这个类为 JPA 实体，将其映射到数据库中的表。
// @Table 注解指定了表名为 "books"。
@Entity
@Table(name = "books")
public class Book {

    // @Id 注解标记主键字段。
    // @GeneratedValue 注解用于自动生成 ID。
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // @Column 注解用于指定列名和属性。
    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    // 构造函数、Getter 和 Setter 方法。
    public Book() {
    }

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
