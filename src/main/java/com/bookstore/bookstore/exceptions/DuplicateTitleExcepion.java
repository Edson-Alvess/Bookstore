package com.bookstore.bookstore.exceptions;

public class DuplicateTitleExcepion extends RuntimeException{
    public DuplicateTitleExcepion(String message){
        super(message);
    }
}
