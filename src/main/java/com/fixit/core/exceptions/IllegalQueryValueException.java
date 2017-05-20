package com.fixit.core.exceptions;

public class IllegalQueryValueException extends IllegalArgumentException {
	private static final long serialVersionUID = 6752751891453936051L;

	public IllegalQueryValueException(String message) {
		super(message);
	}
	
	public IllegalQueryValueException(String message, Throwable throwable) {
		super(message, throwable);
	}
	
}
