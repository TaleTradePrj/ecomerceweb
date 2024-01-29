package com.ecomerce.authentication.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class UserAuthentication {
	@Id
	private ObjectId userAuthId;
	@DBRef
	private User user;
	@Field
	private String password;
	@Field
	private String authToken;
	@Field
	private String token;
	@Field
	private String refreshToken;

	public String getAuthToken() {
		return authToken;
	}

	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}

	public ObjectId getUserAuthId() {
		return userAuthId;
	}

	public void setUserAuthId(ObjectId userAuthId) {
		this.userAuthId = userAuthId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
