package com.disney.explore.exception;

public class UserAlreadyRegisteredException extends Exception {
    private static final long serialVersionUID = 1L;
    public UserAlreadyRegisteredException(String message) {
        super(message);
    }

}
