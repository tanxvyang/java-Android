package com.wbj.exception;

public class UserNotFoundException extends Exception {

	public UserNotFoundException() {
		super();
	}

	public UserNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserNotFoundException(String message) {
	}

	public UserNotFoundException(Throwable cause) {
		super(cause);
	}

	

}
