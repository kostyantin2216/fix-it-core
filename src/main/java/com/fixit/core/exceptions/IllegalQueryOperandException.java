package com.fixit.core.exceptions;

public class IllegalQueryOperandException extends IllegalArgumentException {
	private static final long serialVersionUID = 4180510503957786618L;
	
	public IllegalQueryOperandException(String message) {
		super(message);
	}

}
