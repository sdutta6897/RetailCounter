package com.retail.exceptions;

/**
 * The class will hold the error codes for exception scenarios
 * 
 *
 */
public enum ErrorCodes {

	ERR_PRODUCT_DATA_LOAD_ERROR("There was an error while trying to load the application", Severity.FATAL);

	enum Severity {
		FATAL, ERROR, WARNING
	};

	private String description;
	private Severity severity;

	private ErrorCodes(String description, Severity severity) {
		this.setDescription(description);
		this.severity = severity;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

}
