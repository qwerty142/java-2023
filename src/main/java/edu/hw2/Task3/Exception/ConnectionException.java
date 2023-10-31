package edu.hw2.Task3.Exception;

public class ConnectionException extends RuntimeException {
    public ConnectionException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public ConnectionException(String message) {
        super(message);
    }

    public ConnectionException() {}
}
