package com.ecomerce.Authentication.controller;

import com.ecomerce.Authentication.component.AuthenticationComponent;
import com.ecomerce.Authentication.component.IdentityConformationComponent;
import com.ecomerce.Authentication.models.*;
import com.ecomerce.Authentication.systemutils.Constants;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.io.IOException;

@RestController
public class AuthenticationController {
    @Autowired
    private IdentityConformationComponent identityConformationComponent;
    @Autowired
    private AuthenticationComponent authenticationComponent;

    @GetMapping("/captcha")
    public void getCaptcha(HttpSession httpSession, HttpServletResponse httpServletResponse) throws IOException {
        identityConformationComponent.generateCaptcha(httpServletResponse, httpSession);
    }

    @PostMapping("/signup")
    public ResponseEntity<AuthenticationResponse> signup(HttpSession httpSession, @RequestBody UserSignupRequest userSignupRequest) throws MessagingException {
        CaptchaResponse captchaResponse = identityConformationComponent.verifyCaptcha(httpSession, userSignupRequest.getCaptchaId(), userSignupRequest.getCaptcha());
        if (captchaResponse.isStatus()) {
            SignupResponse signupResponse = authenticationComponent.signup(userSignupRequest, httpSession);
            if (signupResponse.isStatus())
                return new ResponseEntity<AuthenticationResponse>(AuthenticationResponse.builder().status(true).message("Success").body(signupResponse).statusCode(Constants.SUCESS).build(), HttpStatus.OK);
            else if (signupResponse.isUserExist())
                return new ResponseEntity<AuthenticationResponse>(AuthenticationResponse.builder().message(signupResponse.getMessage()).statusCode(Constants.USER_EXIST).build(), HttpStatus.OK);
            else
                return new ResponseEntity<AuthenticationResponse>(AuthenticationResponse.builder().message(signupResponse.getMessage()).statusCode(Constants.FAILED).build(), HttpStatus.OK);

        } else
            return new ResponseEntity<AuthenticationResponse>(AuthenticationResponse.builder().statusCode(Constants.INVALID_CAPTCHA).message(captchaResponse.getMessage()).build(), HttpStatus.OK);
    }

    @GetMapping("/otpVerification")
    public ResponseEntity<AuthenticationResponse> verifyOtp(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,@RequestParam String otp, HttpSession session) {
        String VerificationToken = identityConformationComponent.verifyOtp(otp, session);
        if (null != VerificationToken) {
            AccountActivateResponse accountActivateResponse = authenticationComponent.accountActivation(VerificationToken,httpServletResponse);
            if (accountActivateResponse.isStatus())
                return new ResponseEntity<AuthenticationResponse>(AuthenticationResponse.builder().status(true).statusCode(Constants.SUCESS).message("Success").body(accountActivateResponse).build(), HttpStatus.OK);
            else
                return new ResponseEntity<AuthenticationResponse>(AuthenticationResponse.builder().message("INVALID OTP").statusCode(Constants.FAILED).build(), HttpStatus.OK);
        } else
            return new ResponseEntity<AuthenticationResponse>(AuthenticationResponse.builder().message("INVALID OTP || OTP EXPIRED").statusCode(Constants.INVALID_TOKEN).build(), HttpStatus.OK);

    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> Login(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse, @RequestBody LoginRequest loginRequest) {
        LoginResponse loginResponse = authenticationComponent.login(loginRequest.getEmailId(), loginRequest.getPassword(),httpServletResponse);
        if (loginResponse.isStatus())
            return new ResponseEntity<AuthenticationResponse>(AuthenticationResponse.builder().message(loginResponse.getMessage()).status(true).statusCode(Constants.SUCESS).body(loginResponse).build(), HttpStatus.OK);
        else
            return new ResponseEntity<AuthenticationResponse>(AuthenticationResponse.builder().message(loginResponse.getMessage()).statusCode(Constants.FAILED).build(),
                    HttpStatus.OK);
    }
}
