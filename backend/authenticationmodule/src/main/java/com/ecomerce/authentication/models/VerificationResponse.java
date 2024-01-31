package com.ecomerce.authentication.models;

import java.io.Serializable;

public class VerificationResponse implements Serializable{
	private static final long serialVersionUID = 1L;
	private boolean status;
	private String token;
	private String refreshToken;
	private String fristName;
	private String lastName;
	private String profilePath;

	public boolean getStatus() {
		return this.status;
	}


	public String getFristName() {
		return this.fristName;
	}

	public void setFristName(String fristName) {
		this.fristName = fristName;
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

	

	public VerificationResponse(String token2, String refreshToken2) {
		super();
		this.status = true;
		this.token = token2;
		this.refreshToken = refreshToken2;
	}

	public VerificationResponse(boolean b) {
		super();
		this.status = b;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

}
