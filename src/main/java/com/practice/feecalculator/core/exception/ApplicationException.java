package com.practice.feecalculator.core.exception;

/**
 * Created by gaurav.bhatnagar on 12/2/18.
 */
public class ApplicationException extends RuntimeException {
	
	public ApplicationException(String message) {
		super(message);
	}

	public ApplicationException(String message, Throwable e) {
		super(message, e);
	}
}
