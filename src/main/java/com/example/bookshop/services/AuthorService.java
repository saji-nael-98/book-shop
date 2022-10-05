package com.example.bookshop.services;

import com.example.bookshop.dto.AuthorDTO;
import com.example.bookshop.exceptions.ResourceNotFoundException;
import com.example.bookshop.models.Author;
import com.example.bookshop.repositories.AuthorRepository;
import com.example.bookshop.utils.Gender;
import com.example.bookshop.utils.GenderConverter;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author create(AuthorDTO authorDTO) {
        Author author = new Author();
        prepare(author, authorDTO);
        return authorRepository.save(author);
    }

    public Author read(Long id) {
        return authorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id.toString()));
    }

    public Author update(Long id, AuthorDTO authorDTO) {
        Author author = read(id);
        prepare(author, authorDTO);
        author.setUpdatedDateTime(LocalDateTime.now());
        return authorRepository.save(author);
    }

    public Author delete(Long id) {
        Author author = read(id);
        author.setDeleted(true);
        author.setDeletedDateTime(LocalDateTime.now());
        return authorRepository.save(author);
    }

    public List<Author> readAll() {
        return authorRepository.findAll();
    }

    public void prepare(Author author, AuthorDTO authorDTO) {
        author.setName(authorDTO.getName());
        author.setGender(new GenderConverter().convert(authorDTO.getGender()));
        if (author.getCreatedDateTime() == null)
            author.setCreatedDateTime(LocalDateTime.now());
    }

}
