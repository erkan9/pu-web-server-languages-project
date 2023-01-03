package org.erkamber.exceptions;

public class NotFoundException extends RuntimeException {

    /**
     * Exception used when Searched Product or User is not Found.
     *
     * @param message Message, which is shown to the User.
     */
    public NotFoundException(String message) {
        super(message);
    }
}