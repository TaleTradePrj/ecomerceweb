package com.ecomerce.authentication.models;

public class LoginResponse {
	private boolean status;
	private boolean notExist;
	private String token;
	private String refreshToken;
	private String message;
	private boolean notverfied;

	public boolean getStatus() {
		return this.status;
	}
	public boolean getNotExist() {
		return this.notExist;
	}


	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isNotverfied() {
		return this.notverfied;
	}

	public boolean getNotverfied() {
		return this.notverfied;
	}

	public void setNotverfied(boolean notverfied) {
		this.notverfied = notverfied;
	}


	public LoginResponse(boolean b) {
        super();
		this.notExist = b;
    }

    public LoginResponse(String message) {
        super();
		this.message = message;
    }

    public LoginResponse(String token2, String refreshToken2) {
        super();
		this.token = token2;
		this.refreshToken = refreshToken2;
		this.status = true;
    }

    public LoginResponse() {
        super();
    }

    public LoginResponse(String string, boolean b) {
		super();
		this.message = string;
		this.notverfied = b;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	public boolean isNotExist() {
		return notExist;
	}

	public void setNotExist(boolean notExist) {
		this.notExist = notExist;
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
