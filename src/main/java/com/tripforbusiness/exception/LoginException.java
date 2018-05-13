package com.tripforbusiness.exception;

public final class LoginException extends RuntimeException{

    public LoginException() {
        super();
    }

    public LoginException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public LoginException(final String message) {
        super(message);
    }

    public LoginException(final Throwable cause) {
        super(cause);
    }

}
