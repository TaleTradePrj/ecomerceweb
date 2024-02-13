package com.ecomerce.Authentication.service;

import com.ecomerce.Authentication.component.IdentityConformationComponent;
import com.ecomerce.Authentication.entity.User;
import com.ecomerce.Authentication.entity.UserAuthentication;
import com.ecomerce.Authentication.entity.UserRole;
import com.ecomerce.Authentication.models.AccountActivateResponse;
import com.ecomerce.Authentication.models.UserSignupRequest;
import com.ecomerce.Authentication.models.SignupResponse;
import com.ecomerce.Authentication.repository.UserAuthenticationRepository;
import com.ecomerce.Authentication.repository.UserRepository;
import com.ecomerce.Authentication.repository.UserRoleRepository;
import com.ecomerce.Authentication.systemutils.IdManager;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignupService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserAuthenticationRepository userAuthenticationRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private IdManager idManager;
    @Autowired
    private IdentityConformationComponent identityConformationComponent;
    @Autowired
    private UserRoleRepository userRoleRepository;

    @SuppressWarnings("null")
    public SignupResponse createUser(UserSignupRequest userSignupRequest, HttpSession session) throws MessagingException {

        User user = userService.bindUser(userSignupRequest);
        if (null != user) {
            String otp = idManager.sixDId();
            if (identityConformationComponent.sendMail(user.getEmailId(), otp)) {
                user = userRepository.save(user);
                UserAuthentication userAuthentication = userService.bindUserAuthentication(userSignupRequest.getPassword(), user);
                userAuthenticationRepository.save(userAuthentication);
                session.setAttribute(otp, userAuthentication.getVerificationToken());
                return SignupResponse.builder().status(true).message("OTP SEND SUCCESSFULLY").build();
            } else return SignupResponse.builder().message("Oops something went wrong!!! retry Signup").build();


        } else return SignupResponse.builder().message("Oops something went wrong").build();
    }

    public AccountActivateResponse accountActivation(String verificationToken, HttpServletResponse httpServletResponse) {
        try {
            UserAuthentication userAuthentication = userAuthenticationRepository.findByVerificationToken(verificationToken);
            User user;
            System.out.println("out");
            if (null != userAuthentication) {
                System.out.println("in");
                user = userRepository.findByUserId(userAuthentication.getUser().getUserId());
                user.setUserStatus(1);
                userAuthentication = userAuthenticationRepository.save((UserAuthentication) userService.bindUserAuthToken(userAuthentication));
                userAuthenticationRepository.save(userAuthentication);
                userRepository.save(user);
                UserRole userRole = userService.bindUserRole(user);
                userRoleRepository.save(userRole);
                //have to add the curresponding function to the user
                Cookie token = new Cookie("Token",userAuthentication.getToken());
                token.setHttpOnly(true);
                token.setSecure(true);
                httpServletResponse.addCookie(token);
                Cookie refreshToken = new Cookie("refreshToken",userAuthentication.getRefreshToken());
                refreshToken.setHttpOnly(true);
                refreshToken.setSecure(true);
                httpServletResponse.addCookie(refreshToken);
                return AccountActivateResponse.builder().status(true).fullName(user.getFirstName() + " " + user.getLastName()).emailId(user.getEmailId()).profilePath(user.getProfilePath()).userRoles(userRole.getRoles()).build();
            } else return AccountActivateResponse.builder().message("INVALID OTP").build();

        } catch (Exception e) {
            System.out.println(e);
            return AccountActivateResponse.builder().message("Oops something went wrong").build();
        }
    }
}
