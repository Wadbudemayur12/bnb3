package com.bnb3.exception;

public class NoResourceFound extends RuntimeException{
    public NoResourceFound(String message) {
        super(message);
    }
}
