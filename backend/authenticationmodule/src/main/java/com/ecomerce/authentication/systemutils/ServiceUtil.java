package com.ecomerce.authentication.systemutils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomerce.authentication.entity.User;
import com.ecomerce.authentication.entity.UserAuthentication;
import com.ecomerce.authentication.models.CreateUser;
import com.ecomerce.authentication.repository.UserRepository;

@Service
public class ServiceUtil {
	@Autowired
	private UserRepository userrepo;
	@Autowired
	private CommonUtils utils;

	public boolean userexist(String email) {
		User user = userrepo.findByEmailId(email);
		if (utils.isEmpty(user))
			return false;
		return true;
	}

	public User bindUser(CreateUser userdto) {
		try {
			User user = new User();
			user.setEmailId(userdto.getEmailId());
			user.setFullName(user.getFullName());
			user.setGender(userdto.getGender());
			return user;
		} catch (Exception e) {
			System.out.println("ServiceUtils.BindUser" + e);
			return null;
		}

	}

	public UserAuthentication bindUserAuth(String password, User user) {
		try {
			UserAuthentication userauth = new UserAuthentication();
			userauth.setPassword(password);
			userauth.setUser(user);
			userauth.setAuthToken(utils.generateToken());
			return userauth;
		} catch (Exception e) {
			System.out.println("ServiceUtils.BindUserAuth" + e);
			return null;
		}
		

	}

	public Object bindUserAuthToken(UserAuthentication userauth) {
		userauth.setAuthToken(null);
		userauth.setToken(utils.generateToken());
		userauth.setRefreshToken(utils.generateToken());
		return userauth;
	}
}
