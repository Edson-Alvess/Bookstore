package com.bookstore.bookstore.services;

import com.bookstore.bookstore.dtos.BookRecordDto;
import com.bookstore.bookstore.exceptions.BookNotFoundException;
import com.bookstore.bookstore.exceptions.DuplicateTitleExcepion;
import com.bookstore.bookstore.exceptions.InsufficientStockExceptions;
import com.bookstore.bookstore.models.BookModel;
import com.bookstore.bookstore.models.ReviewModel;
import com.bookstore.bookstore.repositories.AuthorRepository;
import com.bookstore.bookstore.repositories.BookRepository;
import com.bookstore.bookstore.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    PublisherRepository publisherRepository;


    @Transactional
    public BookModel saveBook (BookRecordDto bookRecordDto){
        if (bookRepository.existsByTitle(bookRecordDto.title())){
            throw new DuplicateTitleExcepion(" The title " + bookRecordDto.title() + "is already registered.");
        }
        BookModel book = new BookModel();
        book.setTitle(bookRecordDto.title());
        book.setPublisher(publisherRepository.findById(bookRecordDto.publisherId()).get());
        book.setAuthors(authorRepository.findAllById(bookRecordDto.authorIds()).stream().collect(Collectors.toSet()));

        ReviewModel reviewModel = new ReviewModel();
        reviewModel.setComment(bookRecordDto.reviewComment());
        reviewModel.setBook(book);
        book.setReview(reviewModel);

        book.getStock();

        return bookRepository.save(book);
    }


    public List<BookModel> getAllBooks(){
        return bookRepository.findAll();
    }

    @Transactional
    public void deleteBook(UUID id){
        bookRepository.deleteById(id);
    }

    @Transactional
    public BookModel sellBook(UUID id) throws BookNotFoundException, InsufficientStockExceptions {
        BookModel book = bookRepository.findById(id).orElseThrow(()-> new BookNotFoundException("Book not found !"));
        if (book.getStock() > 0){
            book.setStock(book.getStock() - 1);
            return bookRepository.save(book);
        }else {
            throw new InsufficientStockExceptions(" Insufficient stock ");
        }
    }

}
