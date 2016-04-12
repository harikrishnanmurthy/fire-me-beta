package com.fireme.model;

public class EmailCriteria {

	String userName;
	String message;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public EmailCriteria(String userName, String message) {
		super();
		this.userName = userName;
		this.message = message;
	}
	public EmailCriteria() {
		super();
		// TODO Auto-generated constructor stub
	}
}
