package com.ecomerce.Authentication.component;

import com.ecomerce.Authentication.models.AccountActivateResponse;
import com.ecomerce.Authentication.models.LoginResponse;
import com.ecomerce.Authentication.models.UserSignupRequest;
import com.ecomerce.Authentication.models.SignupResponse;
import com.ecomerce.Authentication.service.LoginService;
import com.ecomerce.Authentication.service.UserService;
import com.ecomerce.Authentication.service.SignupService;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationComponent {
    @Autowired
    private UserService userService;
    @Autowired
    private SignupService signupService;
    @Autowired
    private LoginService loginService;
    public SignupResponse signup(UserSignupRequest userSignupRequest, HttpSession httpSession) throws MessagingException {
        if (null != userSignupRequest.getEmailId()) {
            if (null != userSignupRequest.getPassword() && null != userSignupRequest.getConfirmPassword()) {
                if (1 == userSignupRequest.getAgreedTermsandCondition()) {
                    if (userSignupRequest.getPassword().equals(userSignupRequest.getConfirmPassword())) {
                        if (userService.userExist(userSignupRequest.getEmailId()))
                            return SignupResponse.builder().userExist(true).message("user already exist at this EmailId").build();
                        else
                            return signupService.createUser(userSignupRequest, httpSession);
                    } else
                        return SignupResponse.builder().message("password doesn't match").build();
                } else
                    return SignupResponse.builder().message("Terms and Conditions Not Accepted").build();
            } else
                return SignupResponse.builder().message("Password Cannot be empty").build();

        } else
            return SignupResponse.builder().message("Email Cannot be Empty").build();

    }

    public AccountActivateResponse accountActivation(String verificationToken) {
        return signupService.accountActivation(verificationToken);
    }

    public LoginResponse login(String emailId, String password, HttpServletResponse httpServletResponse) {
        if (userService.userExist(emailId))
            return loginService.login(emailId, password,httpServletResponse);
        else
            return LoginResponse.builder().notExist(true).message("NO USER FOUND").build();
    }
}
