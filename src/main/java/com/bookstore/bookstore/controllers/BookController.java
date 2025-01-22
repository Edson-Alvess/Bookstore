package com.bookstore.bookstore.controllers;

import com.bookstore.bookstore.dtos.BookRecordDto;
import com.bookstore.bookstore.exceptions.BookNotFoundException;
import com.bookstore.bookstore.exceptions.DuplicateTitleExcepion;
import com.bookstore.bookstore.exceptions.InsufficientStockExceptions;
import com.bookstore.bookstore.models.BookModel;
import com.bookstore.bookstore.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/bookstore/books")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping
    public ResponseEntity<?> saveBook(@RequestBody BookRecordDto bookRecordDto) {
        try {
            BookModel savedBook = bookService.saveBook(bookRecordDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);
        }catch (DuplicateTitleExcepion ex){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving book.");
        }
    }

         {

    }

    @PostMapping("/{id}/addStock")
    public BookModel addStock(@PathVariable UUID id, @RequestParam(name = "quantityAdd") int quantityAdd) {
        return bookService.addStock(id, quantityAdd);
    }

    @GetMapping
    public ResponseEntity<List<BookModel>> getAllBooks() {
        return ResponseEntity.status(HttpStatus.OK).body(bookService.getAllBooks());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteBook(@PathVariable UUID id) {
        bookService.deleteBook(id);
        return ResponseEntity.status(HttpStatus.OK).body("Book deleted successfully");
    }






}
