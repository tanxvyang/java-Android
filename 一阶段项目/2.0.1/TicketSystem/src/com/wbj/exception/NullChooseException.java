package com.wbj.exception;

public class NullChooseException extends  Exception {
    public NullChooseException() {
    }

    public NullChooseException(String message) {
        super(message);
    }

    public NullChooseException(String message, Throwable cause) {
        super(message, cause);
    }

    public NullChooseException(Throwable cause) {
        super(cause);
    }
}
