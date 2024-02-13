package com.ecomerce.Authentication.service;

import com.ecomerce.Authentication.entity.User;
import com.ecomerce.Authentication.entity.UserAuthentication;
import com.ecomerce.Authentication.models.LoginResponse;
import com.ecomerce.Authentication.repository.UserAuthenticationRepository;
import com.ecomerce.Authentication.repository.UserRepository;
import com.ecomerce.Authentication.repository.UserRoleRepository;
import com.ecomerce.Authentication.systemutils.IdManager;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserAuthenticationRepository userAuthenticationRepository;
    @Autowired
    private IdManager idManager;
    @Autowired
    private UserRoleRepository userRoleRepository;
    public LoginResponse login(String emailId, String password, HttpServletResponse httpServletResponse) {
        try {
            User user = userRepository.findByEmailId(emailId);
            UserAuthentication userAuthentication = userAuthenticationRepository.findByUser(user);
            if (user.getUserStatus() == 1) {
                if (userAuthentication.getPassword().equals(password)) {
                    userAuthentication.setToken(idManager.generateToken());
                    userAuthentication.setRefreshToken(idManager.generateToken());
                    userAuthenticationRepository.save(userAuthentication);
                    Cookie token = new Cookie("Token",userAuthentication.getToken());
                    token.setHttpOnly(true);
                    token.setSecure(true);
                    httpServletResponse.addCookie(token);
                    Cookie refreshToken = new Cookie("refreshToken",userAuthentication.getRefreshToken());
                    refreshToken.setHttpOnly(true);
                    refreshToken.setSecure(true);
                    httpServletResponse.addCookie(refreshToken);
                    return LoginResponse.builder().emailId(user.getEmailId()).roles(userRoleRepository.findByUser(user)).firstName(user.getFirstName()).lastName(user.getLastName()).profilePath(user.getProfilePath()).status(true).message("SUCCESS").build();
                } else
                    return LoginResponse.builder().message("WRONG PASSWORD").build();
            } else {
                return LoginResponse.builder().message("ACCOUNT NOT ACTIVATED").build();
            }

        } catch (Exception e) {
            System.out.println(e);
            return LoginResponse.builder().build();
        }
    }
}
