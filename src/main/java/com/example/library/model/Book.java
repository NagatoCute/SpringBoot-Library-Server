package com.example.library.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

// @Entity 注解标记这个类为 JPA 实体，将其映射到数据库中的表。
// @Table 注解指定了表名为 "books"。
// @Data 注解是 Lombok 提供的，它会自动生成 getter、setter、toString、equals、hashCode 方法。
// @NoArgsConstructor 注解自动生成无参数构造函数。
@Entity
@Table(name = "books")
@Data
@NoArgsConstructor
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

    // Lombok 的 @Data 注解已经自动生成了以下内容：
    // - 无参构造函数（由 @NoArgsConstructor 提供）
    // - 所有字段的 getter 和 setter
    // - toString 方法
    // - equals 和 hashCode 方法
}
