package com.ecomerce.authentication.entity;

import java.io.Serializable;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class Functions implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private ObjectId functionId;
	@Field
	private String functionName;
	@DBRef
	private List<Role> roleId;

	public ObjectId getFunctionId() {
		return functionId;
	}

	public void setFunctionId(ObjectId functionId) {
		this.functionId = functionId;
	}

	public String getFunctionName() {
		return functionName;
	}

	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}

	public List<Role> getRoleId() {
		return roleId;
	}

	public void setRoleId(List<Role> roleId) {
		this.roleId = roleId;
	}

}
