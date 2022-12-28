package com.project.book_catalog.exceptions;

public class NotFoundProductException extends RuntimeException {

    public NotFoundProductException(String message){
        super(message);
    }
}
