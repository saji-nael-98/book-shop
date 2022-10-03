package com.example.bookshop.repositories;

import com.example.bookshop.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    @Query(value = "select * from Author  where deleted=false and id=:id", nativeQuery = true)
    Optional<Author> findById(Long id);

    @Query(value = "select * from Author  where deleted=false", nativeQuery = true)
    List<Author> findAll();
}
