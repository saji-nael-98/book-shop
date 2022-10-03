package com.example.bookshop.services;

import com.example.bookshop.dto.BookDTO;
import com.example.bookshop.exceptions.ResourceNotFoundException;
import com.example.bookshop.models.Author;
import com.example.bookshop.models.Book;
import com.example.bookshop.repositories.AuthorRepository;
import com.example.bookshop.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookService {
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BookRepository bookRepository;

    public Book create(BookDTO bookDTO) {
        Book book = new Book();
        prepare(book, bookDTO);
        if (book.getCreatedDateTime() == null) book.setCreatedDateTime(LocalDateTime.now());
        return bookRepository.save(book);
    }

    public Book update(Long id, BookDTO bookDTO) {
        Book book = read(id);
        prepare(book, bookDTO);
        book.setUpdatedDateTime(LocalDateTime.now());
        return bookRepository.save(book);
    }

    public Book read(Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(String.valueOf(id)));
    }

    public Book delete(Long id) {
        Book book = read(id);
        book.setDeleted(true);
        book.setDeletedDateTime(LocalDateTime.now());
        return bookRepository.save(book);
    }


    public List<Book> readAll() {
        return bookRepository.findAll();
    }

    public List<Book> findByAuthor(Long authorId) {
        Author author = readAuthor(authorId);
        return bookRepository.findByAuthor(author);
    }

    private void prepare(Book book, BookDTO bookDTO) {
        Author author = readAuthor(bookDTO.getAuthorId());
        book.setAuthor(author);
        book.setName(bookDTO.getName());
        book.setPrice(bookDTO.getPrice());
        book.setQty(book.getQty() + bookDTO.getQty());
        Assert.isTrue(book.getQty() >= 0, "At least,the quantity must greater than zero!");
    }

    private Author readAuthor(Long id) {
        return authorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("author"));
    }
}
