package com.javamaster.application.exception;

public class ValidationException extends Exception {

    private String message;

    public ValidationException(String message) {
        super(message);
    }

    public String getMessage() {
        return message;
    }
}
