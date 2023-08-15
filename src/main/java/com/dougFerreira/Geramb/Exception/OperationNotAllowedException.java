package com.dougFerreira.Geramb.Exception;

public class OperationNotAllowedException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public OperationNotAllowedException(String message) {
		super(message);
	}
	
	public OperationNotAllowedException(String message, Throwable cause) {
		super(message, cause);
	}
}
