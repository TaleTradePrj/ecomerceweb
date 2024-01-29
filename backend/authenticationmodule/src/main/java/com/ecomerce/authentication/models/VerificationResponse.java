package com.ecomerce.authentication.models;

public class VerificationResponse {
	private boolean status;
	private String token;
	private String refreshToken;

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
