package com.ambank.gst.web.util;

public class LoggedInException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LoggedInException(String message) {
		super();
		this.message = message;
	}

	public LoggedInException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoggedInException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public LoggedInException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	
}
