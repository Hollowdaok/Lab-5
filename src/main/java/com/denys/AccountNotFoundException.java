package com.denys;

public class AccountNotFoundException extends RuntimeException {
    public AccountNotFoundException(String errorMessage) {
        super(errorMessage);
    }

    public AccountNotFoundException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}