package com.ecomerce.authentication.models;

import java.io.Serializable;

public class CreateUser implements Serializable {
	private static final long serialVersionUID = 1L;
	private String emailId;
	private String firstName;
	private String lastName;
	private String profilePath;
	private String password;
	private String confirmPassword;
	private String captchaId;
	private String captcha;
	private boolean agreedTermsandCondition;
	private int age;
	private int gender;
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCaptchaId() {
		return captchaId;
	}

	public void setCaptchaId(String captchaId) {
		this.captchaId = captchaId;
	}

	public String getCaptcha() {
		return captcha;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}

	public String getConfirmPassword() {
		return this.confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public boolean isAgreedTermsandCondition() {
		return this.agreedTermsandCondition;
	}

	public boolean getAgreedTermsandCondition() {
		return this.agreedTermsandCondition;
	}

	public void setAgreedTermsandCondition(boolean agreedTermsandCondition) {
		this.agreedTermsandCondition = agreedTermsandCondition;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getProfilePath() {
		return this.profilePath;
	}

	public void setProfilePath(String profilePath) {
		this.profilePath = profilePath;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
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
