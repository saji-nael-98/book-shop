package com.example.bookshop.repositories;

import com.example.bookshop.models.Author;
import com.example.bookshop.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    @Query(value = "select * from Book  where deleted=false and id=:id", nativeQuery = true)
    Optional<Book> findById(Long id);

    @Query(value = "select * from Book  where deleted=false", nativeQuery = true)
    List<Book> findAll();

    @Query("select book from Book book JOIN Author author on author.id=book.author.id where author.deleted=false and book.deleted=false order by book.name")
    List<Book> findByAuthor(Author author);
}
