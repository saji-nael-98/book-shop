package com.example.bookshop.models;

import com.example.bookshop.base.BaseEntity;
import com.example.bookshop.utils.Gender;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@Table
public class Author extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(insertable = false)
    private Long id;
    @Column(nullable = false)
    @NotBlank(message = "Name is mandatory")
    private String name;
    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private Gender gender;
}
