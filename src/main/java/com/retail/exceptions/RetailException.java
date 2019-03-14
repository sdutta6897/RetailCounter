package com.retail.exceptions;

/**
 * Class will be used for exception handling
 *
 */
public class RetailException extends Exception {

	/**
	 * serial uuid
	 */
	private static final long serialVersionUID = 1L;

	private ErrorCodes errorCode;

	public RetailException(ErrorCodes errorCode) {
		this.errorCode = errorCode;
	}

	public RetailException(String message, ErrorCodes errorCode) {
		super(message);
		this.errorCode = errorCode;
	}

	/**
	 * @return the errorCode
	 */
	public ErrorCodes getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode
	 *            the errorCode to set
	 */
	public void setErrorCode(ErrorCodes errorCode) {
		this.errorCode = errorCode;
	}

}
