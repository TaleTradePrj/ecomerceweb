package com.ecomerce.authentication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomerce.authentication.entity.User;
import com.ecomerce.authentication.entity.UserAuthentication;
import com.ecomerce.authentication.entity.UserRole;
import com.ecomerce.authentication.models.CreateUser;
import com.ecomerce.authentication.models.LoginResponse;
import com.ecomerce.authentication.models.SignupResponse;
import com.ecomerce.authentication.models.VerificationResponse;
import com.ecomerce.authentication.repository.UserAuthenticationRepository;
import com.ecomerce.authentication.repository.UserRepository;
import com.ecomerce.authentication.repository.UserRoleRepository;
import com.ecomerce.authentication.systemutils.CommonUtils;
import com.ecomerce.authentication.systemutils.EmailService;
import com.ecomerce.authentication.systemutils.ServiceUtil;

import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpSession;

@Service
public class AuthentictionService {
	@Autowired
	private ServiceUtil serviceutil;
	@Autowired
	private UserRepository userrepo;
	@Autowired
	private UserAuthenticationRepository userauthrepo;
	@Autowired
	private CommonUtils commonUtils;
	@Autowired
	private EmailService emailservice;
	@Autowired
	private UserRoleRepository userrolerepo;

	@SuppressWarnings("null")
	public SignupResponse createUser(CreateUser createuser, HttpSession session) throws MessagingException {
		User user = serviceutil.bindUser(createuser);
		if (null != user) {
			user = userrepo.save(user);
			UserAuthentication userauth = serviceutil.bindUserAuth(createuser.getPassword(), user);
			userauthrepo.save(userauth);
			String otp = commonUtils.sixDId();
			session.setAttribute(otp, userauth.getAuthToken());
			System.out.println(session.getAttribute(otp));
			emailservice.sendMail(user.getEmailId(), otp);
			return new SignupResponse("opt send to you email", true);
		} else
			return new SignupResponse("oops something wrong");
	}

	@SuppressWarnings("null")
	public VerificationResponse verifyOtp(String OTP) {
		try {
			UserAuthentication userauth = userauthrepo.findByAuthToken(OTP);
			User user;
			if (null != userauth) {
				user = userrepo.findByUserId(userauth.getUser().getUserId());
				user.setUserStatus(1);
				userauth = userauthrepo.save((UserAuthentication) serviceutil.bindUserAuthToken(userauth));
				userauthrepo.save(userauth);
				userrepo.save(user);
				UserRole userrole = serviceutil.bindUserRole(user);
				userrolerepo.save(userrole);
				//have to add the curresponding function to the user
				return new VerificationResponse(userauth.getToken(), userauth.getRefreshToken(),
						user.getFirstName() + " " + user.getLastName(), user.getEmailId(), user.getProfilePath(), userrole.getRoleId());
			} else
				return new VerificationResponse("invalid otp");

		} catch (Exception e) {
			System.out.println("oops something happened");
			return new VerificationResponse("oops something went wrong");
		}

	}

	public LoginResponse Login(String emailId, String password) {
		try {
			User user = userrepo.findByEmailId(emailId);
			UserAuthentication userauth = userauthrepo.findByUser(user);
			if (user.getUserStatus() == 1) {
				if (userauth.getPassword().equals(password)) {
					userauth.setToken(commonUtils.generateToken());
					userauth.setRefreshToken(commonUtils.generateToken());
					userauthrepo.save(userauth);
					return new LoginResponse(userauth.getToken(), userauth.getRefreshToken(), user.getFirstName(),
							user.getLastName(), user.getProfilePath());
				} else
					return new LoginResponse("wrong password");
			} else {
				return new LoginResponse("account not activated", true);
			}

		} catch (Exception e) {
			System.out.println(e);
			return new LoginResponse();
		}
	}

}
