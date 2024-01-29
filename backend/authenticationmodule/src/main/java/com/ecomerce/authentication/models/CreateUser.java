package com.ecomerce.authentication.models;

public class CreateUser {
	private String emailId;
	private String fullName;
	private String password;
	private int gender;
	
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getFirstName() {
		return fullName;
	}
	public void setFirstName(String firstName) {
		this.fullName = firstName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	
}
