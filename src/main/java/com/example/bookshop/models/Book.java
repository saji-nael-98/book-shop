package com.example.bookshop.models;

import com.example.bookshop.base.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
@Data
public class Book extends BaseEntity {
    @Column(insertable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private double price;
    private Integer qty = 0;
    @OneToOne
    @JoinColumn(name = "author_id",referencedColumnName = "id")
    private Author author;

}
