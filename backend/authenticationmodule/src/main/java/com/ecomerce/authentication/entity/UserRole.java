package com.ecomerce.authentication.entity;

import java.io.Serializable;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class UserRole implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private ObjectId userRoleId;
	@DBRef
	private User user;
	@DBRef
	private List<Role> roleId;

	public ObjectId getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(ObjectId userRoleId) {
		this.userRoleId = userRoleId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Role> getRoleId() {
		return roleId;
	}

	public void setRoleId(List<Role> roleId) {
		this.roleId = roleId;
	}

}
