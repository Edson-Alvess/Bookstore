package com.bookstore.bookstore.repositories;

import com.bookstore.bookstore.models.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BookRepository extends JpaRepository<BookModel, UUID> {
    BookModel findBookModelByTitle (String title);
}
