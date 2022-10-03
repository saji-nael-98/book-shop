package com.example.bookshop.models;

import com.example.bookshop.base.BaseEntity;
import com.example.bookshop.utils.Gender;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Author extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(insertable = false)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Gender gender;
}
