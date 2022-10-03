package com.example.bookshop;

import com.example.bookshop.dto.AuthorDTO;
import com.example.bookshop.services.AuthorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AuthorTests {
    @Autowired
    private AuthorService authorService;

    @Test
    void createAuthor() {
        AuthorDTO authorDTO = new AuthorDTO();
        authorDTO.setName("test 1");
        authorDTO.setGender(1);
        System.out.println(authorService.create(authorDTO));
    }

    @Test
    void updateAuthor() {
        AuthorDTO authorDTO = new AuthorDTO();
        authorDTO.setName("test 1");
        authorDTO.setGender(1);
        System.out.println(authorService.update(1L, authorDTO));
    }

    @Test
    void deleteAuthor() {
        System.out.println(authorService.delete(1L));
    }

    @Test
    void readAuthor() {
        System.out.println(authorService.read(1L));
    }

    @Test
    void readAllAuthors() {
        System.out.println(authorService.readAll());
    }
}
