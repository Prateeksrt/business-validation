package org.validation;

public class ValidationException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2858835073032134440L;
	public ValidationException(){
		super();
	}
	
	public ValidationException(String exceptionMsg) {
		super(exceptionMsg);
	}
	
}
