package com.alexandre.workshopmongo.exception;

public class NotFoundException extends RuntimeException{

    public NotFoundException(final String msg) {
        super(msg);
    }
}
