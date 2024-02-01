package com.ecomerce.authentication.models;

import java.io.Serializable;
import java.util.List;

import com.ecomerce.authentication.entity.Role;

public class VerificationResponse implements Serializable {
	private static final long serialVersionUID = 1L;
	private boolean status;
	private boolean wrongOtp;
	private String message;
	private String emailId;
	private String FullName;
	private String profilePath;
	private String token;
	private String refreshToken;
	private List<Role> userroles;

	public VerificationResponse(String token, String refreshToken, String fullName, String emailId, String profilePath,
			List<Role> userroles) {
		super();
		this.status = true;
		this.token = token;
		this.refreshToken = refreshToken;
		this.FullName = fullName;
		this.emailId = emailId;
		this.profilePath = profilePath;
		this.userroles = userroles;
	}

	public VerificationResponse(String message) {
		super();
		this.status = false;
		this.message = message;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public boolean isWrongOtp() {
		return wrongOtp;
	}

	public void setWrongOtp(boolean wrongOtp) {
		this.wrongOtp = wrongOtp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getFullName() {
		return FullName;
	}

	public void setFullName(String fullName) {
		FullName = fullName;
	}

	public String getProfilePath() {
		return profilePath;
	}

	public void setProfilePath(String profilePath) {
		this.profilePath = profilePath;
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

	public List<Role> getUserroles() {
		return userroles;
	}

	public void setUserroles(List<Role> userroles) {
		this.userroles = userroles;
	}

}
