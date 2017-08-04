/**
 * 
 */
package com.src.magnushealth.model;

/**
 * @author Rakesh Rai
 *
 */
public final class ResponseObject {
	private boolean success;
	private String message;

	/**
	 * 
	 * @return success - true or false.
	 */
	public boolean isSuccess() {
		return success;
	}
	

	/**
	 * 
	 * @return String
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Constructor
	 * @param success
	 * @param message
	 */
	public ResponseObject(boolean success, String message) {
		super();
		this.success = success;
		this.message = message;
	}
}