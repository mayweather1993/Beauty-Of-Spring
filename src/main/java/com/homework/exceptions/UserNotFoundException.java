package com.homework.exceptions;

public class UserNotFoundException extends ResourceNotFoundException {
    public UserNotFoundException(final String userName) {
        super("User [" + userName + "] not found.");
    }
}
