package com.example.bookshop.services;

import com.example.bookshop.dto.StoreOrderDTO;
import com.example.bookshop.exceptions.ResourceNotFoundException;
import com.example.bookshop.models.Book;
import com.example.bookshop.models.StoreOrder;
import com.example.bookshop.repositories.BookRepository;
import com.example.bookshop.repositories.StoreRepository;
import com.example.bookshop.utils.OrderStatusConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.LocalDateTime;

@Service
public class StoreOrderService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private StoreRepository storeRepository;

    public StoreOrder create(StoreOrderDTO storeOrderDTO) {
        StoreOrder storeOrder = new StoreOrder();
        prepare(storeOrder, storeOrderDTO);
        storeOrder.setCreatedDateTime(LocalDateTime.now());
        return storeRepository.save(storeOrder);
    }
    public StoreOrder update(Long id,StoreOrderDTO storeOrderDTO){
        StoreOrder storeOrder=read(id);
        Book book=storeOrder.getBook();
        book.setQty(book.getQty()+storeOrder.getQty());
        bookRepository.save(book);
        prepare(storeOrder,storeOrderDTO);
        storeOrder.setUpdatedDateTime(LocalDateTime.now());
        return storeRepository.save(storeOrder);
    }

    public StoreOrder read(Long id){
        return storeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException(String.format("order: %s is not found!",id)));
    }
    public StoreOrder delete(Long id){
        StoreOrder storeOrder=read(id);
        storeOrder.setDeleted(true);
        storeOrder.setDeletedDateTime(LocalDateTime.now());
        return storeRepository.save(storeOrder);
    }
    public void prepare(StoreOrder storeOrder, StoreOrderDTO storeOrderDTO) {
        Book book = bookRepository.findById(storeOrderDTO.getBookId()).orElseThrow(() -> new ResourceNotFoundException(String.format("%s is not found", storeOrderDTO.getBookId())));
        Assert.isTrue(book.getQty()-storeOrderDTO.getQty() >= 0, "invalid quantity!");
        book.setQty(book.getQty()-storeOrderDTO.getQty());
        storeOrder.setBook(book);
        storeOrder.setQty(storeOrderDTO.getQty());
        storeOrder.setComplete(storeOrderDTO.isComplete());
        storeOrder.setOrderStatus(new OrderStatusConverter().convert(storeOrderDTO.getOrderStatus()));
        bookRepository.save(book);
    }
}
