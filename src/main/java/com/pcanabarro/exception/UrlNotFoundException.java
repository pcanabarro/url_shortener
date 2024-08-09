package com.pcanabarro.exception;

public class UrlNotFoundException extends RuntimeException {
    public UrlNotFoundException(int code, String message) {
        super(message);
    }
}
