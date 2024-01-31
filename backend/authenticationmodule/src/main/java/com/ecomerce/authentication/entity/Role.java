package com.ecomerce.authentication.entity;

import java.io.Serializable;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class Role implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private ObjectId roleId;
	@Field
	private String roleName;

	public ObjectId getRoleId() {
		return roleId;
	}

	public String getRoleName() {
		return roleName;
	}
}
