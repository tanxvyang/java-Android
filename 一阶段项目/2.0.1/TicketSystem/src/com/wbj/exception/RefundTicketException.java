package com.wbj.exception;

public class RefundTicketException extends Exception {
    public RefundTicketException() {
    }

    public RefundTicketException(String message) {
        super(message);
    }

    public RefundTicketException(String message, Throwable cause) {
        super(message, cause);
    }

    public RefundTicketException(Throwable cause) {
        super(cause);
    }
}
