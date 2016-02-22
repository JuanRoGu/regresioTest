package com.acc.regresiontest.com.domains;



/**
 * A customized Exception class used in the Domain Tier
 * 
 */
@SuppressWarnings("serial")
public class DomainException extends RuntimeException {

	/**
	 * Constructor
	 * 
	 * @param message
	 */
	public DomainException(String message) {
		super(message);
	}
}
