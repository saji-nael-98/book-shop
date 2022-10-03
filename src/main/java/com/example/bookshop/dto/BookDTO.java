package com.example.bookshop.dto;

import lombok.Data;

@Data
public class BookDTO {
    private Long authorId;
    private String name;
    private double price;
    private int qty;
}
