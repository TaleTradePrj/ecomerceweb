package com.ecomerce.authentication.models;

public class LoginResponse {
	private boolean status;
	private boolean notExist;
	private boolean notverfied;
	private String token;
	private String refreshToken;
	private String firstName;
	private String lastName;
	private String profilePath;
	private String message;

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


	public LoginResponse(boolean notExist) {
        super();
		this.notExist = notExist;
    }

    public LoginResponse(String message) {
        super();
		this.message = message;
    }

    public LoginResponse(String token, String refreshToken, String firstName, String lastName, String profilePath) {
        super();
		this.token = token;
		this.refreshToken = refreshToken;
		this.firstName = firstName;
		this.lastName = lastName;
		this.profilePath = profilePath;
		this.status = true;
    }

    public LoginResponse() {
        super();
    }

    public LoginResponse(String message, boolean notverfied) {
		super();
		this.message = message;
		this.notverfied = notverfied;
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
