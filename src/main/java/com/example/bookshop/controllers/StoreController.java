package com.example.bookshop.controllers;

import com.example.bookshop.dto.StoreOrderDTO;
import com.example.bookshop.services.StoreOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/store")
public class StoreController {
    @Autowired
    private StoreOrderService storeOrderService;

    @PostMapping("/order")
    public ResponseEntity<?> createOrder(@Valid @RequestBody StoreOrderDTO storeOrderDTO) {
        return ResponseEntity.ok(storeOrderService.create(storeOrderDTO));
    }

    @GetMapping("/order/{id}")
    public ResponseEntity<?> read(@PathVariable Long id) {
        return ResponseEntity.ok(storeOrderService.read(id));
    }

    @PutMapping("/order/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody StoreOrderDTO storeOrderDTO) {
        return ResponseEntity.ok(storeOrderService.update(id, storeOrderDTO));
    }

    @DeleteMapping("/order/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return ResponseEntity.ok(storeOrderService.delete(id));
    }
}
