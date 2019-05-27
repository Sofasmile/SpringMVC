package net.spring.exception;

public class UserNotFoundException extends RuntimeException {
    private static final String MESSAGE = "User with this username not found";
    public UserNotFoundException() {
        super(MESSAGE);
    }

    public UserNotFoundException(String message) {
        super(message);
    }
}
