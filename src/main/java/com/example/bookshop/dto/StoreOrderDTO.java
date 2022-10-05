package com.example.bookshop.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class StoreOrderDTO {
    @NotNull
    private Long bookId;
    private boolean complete;
    @NotNull
    private String orderStatus;
    @NotNull
    private int qty;
}
