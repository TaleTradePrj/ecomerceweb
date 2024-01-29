package com.ecomerce.authentication.models;

public class SignupResponse {

	private boolean userExist;
	private boolean status;
	private String message;
	
	
	
	public SignupResponse(String message,boolean status) {
		super();
		this.status = status;
		this.message = message;
	}

	public SignupResponse(String message) {
		super();
		this.message = message;
	}

	public SignupResponse(boolean userExist, String message) {
		super();
		this.userExist = userExist;
		this.message = message;
	}

	public boolean isUserExist() {
		return userExist;
	}

	public void setUserExist(boolean userExist) {
		this.userExist = userExist;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
