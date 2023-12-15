package com.mydrive.mydrive.exception;

public class UserNotFoundException extends RuntimeException {
	
	public UserNotFoundException ( String message) {
		super(message);
	}

}
