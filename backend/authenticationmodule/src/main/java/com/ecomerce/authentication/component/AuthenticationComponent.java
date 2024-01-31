package com.ecomerce.authentication.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ecomerce.authentication.models.CreateUser;
import com.ecomerce.authentication.models.LoginResponse;
import com.ecomerce.authentication.models.SignupResponse;
import com.ecomerce.authentication.models.VerificationResponse;
import com.ecomerce.authentication.service.AuthentictionService;
import com.ecomerce.authentication.systemutils.ServiceUtil;

import jakarta.mail.MessagingException;

@Component
public class AuthenticationComponent {
	@Autowired
	private ServiceUtil serviceutil;
	@Autowired
	private AuthentictionService authservice;

	public SignupResponse signup(CreateUser createuser) throws MessagingException {
		if (null != createuser.getEmailId()) {
			if (null != createuser.getPassword() && null != createuser.getConfirmPassword()) {
				if(1 == createuser.getAgreedTermsandCondition()) {
					if(createuser.getPassword().equals(createuser.getConfirmPassword())) {
						if (serviceutil.userexist(createuser.getEmailId()))
							return new SignupResponse(true, "user Already exist at this emailId");
						else
							return authservice.createUser(createuser);
					}else
						return new SignupResponse("passwords does'nt match");
				}
				else return new SignupResponse("terms and conditions not agrred");
			} else
				return new SignupResponse("password fields are madatory");

		} else
			return new SignupResponse("email cannot be empty");

	}

	public VerificationResponse signupVerification(String authtoken) {
		return authservice.checkAuthToken(authtoken);
	}

	public LoginResponse login(String emailId, String password) {
		if (serviceutil.userexist(emailId))
			return authservice.Login(emailId, password);
		else
			return new LoginResponse("not user found");

	}

}
