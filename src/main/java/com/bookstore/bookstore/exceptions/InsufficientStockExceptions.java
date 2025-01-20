package com.bookstore.bookstore.exceptions;

public class InsufficientStockExceptions extends RuntimeException{
    public InsufficientStockExceptions(String message){
        super(message);
    }
}
