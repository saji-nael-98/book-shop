package com.example.bookshop.controllers;

import com.example.bookshop.dto.AuthorDTO;
import com.example.bookshop.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @PostMapping
    public ResponseEntity<Object> create(@Valid @RequestBody AuthorDTO authorDTO) {
        return ResponseEntity.ok(authorService.create(authorDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> read(@PathVariable Long id) {
        return ResponseEntity.ok(authorService.read(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody AuthorDTO authorDTO) {
        return ResponseEntity.ok(authorService.update(id, authorDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        return ResponseEntity.ok(authorService.delete(id));
    }

    @GetMapping("/readAll")
    public ResponseEntity<Object> readAll() {
        return ResponseEntity.ok(authorService.readAll());
    }


}
