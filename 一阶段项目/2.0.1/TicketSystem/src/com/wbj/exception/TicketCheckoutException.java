package com.wbj.exception;

public class TicketCheckoutException extends Exception {

	public TicketCheckoutException() {
		super();
	}

	public TicketCheckoutException(String message, Throwable cause) {
		super(message, cause);
	}

	public TicketCheckoutException(String message) {
		super(message);
	}

	public TicketCheckoutException(Throwable cause) {
		super(cause);
	}

}
