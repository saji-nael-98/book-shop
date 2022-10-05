package com.example.bookshop.repositories;

import com.example.bookshop.models.Book;
import com.example.bookshop.models.StoreOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StoreRepository extends JpaRepository<StoreOrder,Long> {
    @Query(value = "select * from store_order  where deleted=false and id=:id", nativeQuery = true)
    Optional<StoreOrder> findById(Long id);

    @Query(value = "select * from store_order  where deleted=false", nativeQuery = true)
    List<StoreOrder> findAll();
}
