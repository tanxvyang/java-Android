package com.wbj.exception;

public class RegisterFailException extends Exception {

	public RegisterFailException() {
		super();
	}

	public RegisterFailException(String message, Throwable cause) {
		super(message, cause);
	}

	public RegisterFailException(String message) {
		super(message);
	}

	public RegisterFailException(Throwable cause) {
		super(cause);
	}

}
