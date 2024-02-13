package com.ecomerce.Authentication.component;

import com.ecomerce.Authentication.models.CaptchaResponse;
import com.ecomerce.Authentication.service.CaptchaService;
import com.ecomerce.Authentication.service.EmailService;
import com.ecomerce.Authentication.service.OTPService;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class IdentityConformationComponent {
    @Autowired
    private CaptchaService captchaService;
    @Autowired
    private EmailService emailService;
    @Autowired
    private OTPService otpService;
    public void generateCaptcha(HttpServletResponse httpServletResponse, HttpSession httpSession) throws IOException {
        captchaService.generateCaptcha(httpServletResponse,httpSession);
    }
    public CaptchaResponse verifyCaptcha(HttpSession session, String captchaId, String captcha){
        return captchaService.verifyCaptcha(session,captchaId,captcha);
    }

    public boolean sendMail(String emailId, String otp) throws MessagingException {

        if(emailService.sendMail(emailId,otp))
            return true;
        else
            return false;
    }

    public String verifyOtp(String otp, HttpSession session) {
        return otpService.otpVerification(otp,session);
    }
}
