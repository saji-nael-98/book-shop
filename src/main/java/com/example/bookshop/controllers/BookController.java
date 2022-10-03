package com.example.bookshop.controllers;

import com.example.bookshop.dto.AuthorDTO;
import com.example.bookshop.dto.BookDTO;
import com.example.bookshop.services.AuthorService;
import com.example.bookshop.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody BookDTO bookDTO) {
        return ResponseEntity.ok(bookService.create(bookDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> read(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.read(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody BookDTO bookDTO) {
        return ResponseEntity.ok(bookService.update(id, bookDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.delete(id));
    }

    @GetMapping("/readAll")
    public ResponseEntity<Object> readAll() {
        return ResponseEntity.ok(bookService.readAll());
    }

    @GetMapping("/findByAuthor")
    public ResponseEntity<Object> findByAuthor(@RequestParam Long authorId) {
        return ResponseEntity.ok(bookService.findByAuthor(authorId));
    }
}
