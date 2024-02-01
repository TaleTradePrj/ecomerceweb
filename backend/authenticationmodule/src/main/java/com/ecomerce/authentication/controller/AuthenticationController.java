package com.ecomerce.authentication.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecomerce.authentication.component.AuthenticationComponent;
import com.ecomerce.authentication.models.CommonResponse;
import com.ecomerce.authentication.models.CreateUser;
import com.ecomerce.authentication.models.LoginDto;
import com.ecomerce.authentication.models.LoginResponse;
import com.ecomerce.authentication.models.SignupResponse;
import com.ecomerce.authentication.models.VerificationResponse;
import com.ecomerce.authentication.models.VerifyCapResponse;
import com.ecomerce.authentication.systemutils.CaptchaUtils;
import com.ecomerce.authentication.systemutils.Constants;
import com.ecomerce.authentication.systemutils.EmailService;

import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@RestController()
public class AuthenticationController {
	@Autowired
	private AuthenticationComponent authcomp;

	@Autowired
	private CaptchaUtils caputils;

	@Autowired
	private EmailService serivce;
	
	@GetMapping("/captcha")
	public void handleRequest(HttpServletResponse response, HttpSession request) throws IOException {

		caputils.generateCaptcha(response, request);

	}

	@GetMapping("/email")
	public void sendMail(@RequestParam String authToken) throws MessagingException {
		serivce.sendMail("anandhu2suresh797@gmail.com", authToken);
	}

	@PostMapping("/signup")
	public ResponseEntity<CommonResponse> signup(HttpSession request, HttpSession session,
			@RequestBody CreateUser createuser) throws MessagingException {
		VerifyCapResponse capresponse = caputils.verifyCaptcha(request, createuser.getCaptchaId(),
				createuser.getCaptcha());
		if (capresponse.isStatus()) {
			SignupResponse singupresponse = authcomp.signup(createuser, session);
			if (singupresponse.isStatus())
				return new ResponseEntity<CommonResponse>(new CommonResponse(Constants.SUCESS, singupresponse),
						HttpStatus.OK);
			else if (singupresponse.isUserExist())
				return new ResponseEntity<CommonResponse>(
						new CommonResponse(singupresponse.getMessage(), Constants.USER_EXIST), HttpStatus.OK);
			else
				return new ResponseEntity<CommonResponse>(
						new CommonResponse(singupresponse.getMessage(), Constants.FAILED), HttpStatus.OK);

		} else
			return new ResponseEntity<CommonResponse>(
					new CommonResponse(capresponse.getMessage(), Constants.INVALID_CAPTCHA), HttpStatus.OK);
	}

	@GetMapping("/verifyotp")
	public ResponseEntity<CommonResponse> verifyOtp(HttpServletRequest request, @RequestParam String otp, HttpSession session) {
		VerificationResponse response = authcomp.verifyOtp(otp, session);
		if (response.isStatus())
			return new ResponseEntity<CommonResponse>(new CommonResponse(Constants.SUCESS, response), HttpStatus.OK);
		else
			return new ResponseEntity<CommonResponse>(
					new CommonResponse(response.getMessage(), Constants.INVALID_TOKEN), HttpStatus.OK);

	}

	@PostMapping("/login")
	public ResponseEntity<CommonResponse> login(HttpServletRequest request, @RequestBody LoginDto logindto) {
		LoginResponse response = authcomp.login(logindto.getEmailId(), logindto.getPassword());
		if (response.isStatus())
			return new ResponseEntity<CommonResponse>(new CommonResponse(Constants.SUCESS, response), HttpStatus.OK);
		else
			return new ResponseEntity<CommonResponse>(new CommonResponse(response.getMessage(), Constants.FAILED),
					HttpStatus.OK);
	}

}
