package com.ecomerce.Authentication.service;

import com.ecomerce.Authentication.entity.Role;
import com.ecomerce.Authentication.entity.User;
import com.ecomerce.Authentication.entity.UserAuthentication;
import com.ecomerce.Authentication.entity.UserRole;
import com.ecomerce.Authentication.models.UserSignupRequest;
import com.ecomerce.Authentication.repository.RoleRepository;
import com.ecomerce.Authentication.repository.UserRepository;
import com.ecomerce.Authentication.systemutils.IdManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private IdManager idManager;
    @Autowired
    private RoleRepository roleRepository;
    public boolean userExist(String email) {
        User user = userRepository.findByEmailId(email);
        if (null == user)
            return false;
        return true;
    }

    public User bindUser(UserSignupRequest userSignupRequest) {
        try {
            User user = new User();
            user.setEmailId(userSignupRequest.getEmailId());
            user.setFirstName(userSignupRequest.getFirstName());
            user.setLastName(userSignupRequest.getLastName());
            user.setProfilePath(userSignupRequest.getProfilePath());
            user.setGender(userSignupRequest.getGender());
            user.setAge(userSignupRequest.getAge());
            user.setUserStatus(0);
            return user;
        } catch (Exception e) {
            System.out.println("ServiceUtils.BindUser" + e);
            return new User();
        }

    }

    public UserAuthentication bindUserAuthentication(String password, User user) {
        try {
            UserAuthentication userAuthentication = new UserAuthentication();
            userAuthentication.setPassword(password);
            userAuthentication.setUser(user);
            userAuthentication.setVerificationToken(idManager.generateToken());
            return userAuthentication;
        } catch (Exception e) {
            System.out.println("ServiceUtils.BindUserAuth" + e);
            return new UserAuthentication();
        }


    }

    public Object bindUserAuthToken(UserAuthentication userAuthentication) {
        userAuthentication.setVerificationToken(null);
        userAuthentication.setToken(idManager.generateToken());
        userAuthentication.setRefreshToken(idManager.generateToken());
        return userAuthentication;
    }

    public UserRole bindUserRole(User user) {
        UserRole userRole= new UserRole();
        Role userPriv = roleRepository.findByRoleName("User");
        List<Role> rolelist = new ArrayList<>();
        rolelist.add(userPriv);
        userRole.setUser(user);
        userRole.setRoles(rolelist);
        return userRole;
    }
}
