package com.example.bookshop.dto;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class BookDTO {
    @NotNull
    private Long authorId;
    @NotNull
    @NotEmpty
    @NotBlank
    private String name;
    @Min(1)
    @NotNull
    private double price;
    @NotNull
    private int qty;
}
