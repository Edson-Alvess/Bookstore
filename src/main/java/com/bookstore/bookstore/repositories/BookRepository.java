package com.bookstore.bookstore.repositories;

import com.bookstore.bookstore.models.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface BookRepository extends JpaRepository<BookModel, UUID> {
    Optional<BookModel> findBookModelByTitle (String title);

    boolean existsByTitle(String title);
}
