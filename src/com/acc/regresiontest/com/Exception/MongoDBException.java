package com.acc.regresiontest.com.Exception;

@SuppressWarnings("serial")
public class MongoDBException extends RuntimeException {

	/**
	 * @param message
	 */
	public MongoDBException(String message) {
		super(message);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public MongoDBException(String message, Throwable cause) {
		super(message, cause);
	}

}
