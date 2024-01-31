package com.ecomerce.authentication.models;

import java.io.Serializable;

public class VerifyCapResponse implements Serializable{
	private static final long serialVersionUID = 1L;
	private boolean status;
	private boolean limitOver;
	private boolean wrongId;
	private String message;

	public VerifyCapResponse(String message, boolean wrongId) {
		super();
		this.message = message;
		this.wrongId = wrongId;
	}

	public VerifyCapResponse(boolean status, String message) {
		super();
		this.status = status;
		this.message = message;
	}
	
	public VerifyCapResponse(boolean status, boolean limitOver,String message) {
		super();
		this.status = status;
		this.limitOver = limitOver;
		this.message = message;
	}

	public VerifyCapResponse(boolean status) {
		super();
		this.status = status;
		this.message = "invalid captcha";
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isWrongId() {
		return wrongId;
	}

	public void setWrongId(boolean wrongId) {
		this.wrongId = wrongId;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public boolean isLimitOver() {
		return limitOver;
	}

	public void setLimitOver(boolean limitOver) {
		this.limitOver = limitOver;
	}

}
