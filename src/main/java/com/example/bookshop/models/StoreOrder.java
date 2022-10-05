package com.example.bookshop.models;

import com.example.bookshop.base.BaseEntity;
import com.example.bookshop.utils.OrderStatus;
import lombok.Data;
import javax.persistence.*;

@Entity
@Table
@Data
public class StoreOrder extends BaseEntity {
    @Column(insertable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private OrderStatus orderStatus;
    private boolean complete;
    private int qty;
    @OneToOne
    @JoinColumn(name = "book_id")
    private Book book;
}
