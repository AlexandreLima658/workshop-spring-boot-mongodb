package com.alexandre.workshopmongo.resources.exception;

import java.io.Serializable;

public class StandardError implements Serializable {

    private String message;


    public StandardError(final String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
