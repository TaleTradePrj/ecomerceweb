package com.ecomerce.authentication.systemutils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ecomerce.authentication.entity.Role;
import com.ecomerce.authentication.entity.User;
import com.ecomerce.authentication.entity.UserAuthentication;
import com.ecomerce.authentication.entity.UserRole;
import com.ecomerce.authentication.models.CreateUser;
import com.ecomerce.authentication.repository.RoleRepository;
import com.ecomerce.authentication.repository.UserRepository;


@Component
public class ServiceUtil {
	
	@Autowired
	private UserRepository userrepo;
	@Autowired
	private CommonUtils utils;
	@Autowired
	private RoleRepository rolerepo;
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
			user.setFirstName(userdto.getFirstName());
			user.setLastName(userdto.getLastName());
			user.setProfilePath(userdto.getProfilePath());
			user.setGender(userdto.getGender());
			user.setAge(userdto.getAge());
			user.setUserStatus(0);
			return user;
		} catch (Exception e) {
			System.out.println("ServiceUtils.BindUser" + e);
			return new User();
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
			return new UserAuthentication();
		}
		

	}

	public Object bindUserAuthToken(UserAuthentication userauth) {
		userauth.setAuthToken(null);
		userauth.setToken(utils.generateToken());
		userauth.setRefreshToken(utils.generateToken());
		return userauth;
	}

	public UserRole bindUserRole(User user) {
		UserRole userrole= new UserRole();
	    Role userPriv = rolerepo.findByRoleName("User");
	    Role buyerPriv= rolerepo.findByRoleName("Buyer");
		List<Role> rolelist = new ArrayList<>();
		rolelist.add(buyerPriv);
		rolelist.add(userPriv);
		userrole.setUser(user);
		userrole.setRoleId(rolelist);
		return userrole;
	}
}
