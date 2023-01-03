package org.erkamber.exceptions;

public class InvalidCredentialsException extends RuntimeException {

    /**
     * Exception used when Invalid Credentials are Entered by the User.
     *
     * @param message Message, which is shown to the user.
     */
    public InvalidCredentialsException(String message) {
        super(message);
    }
}