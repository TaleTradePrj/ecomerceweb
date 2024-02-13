package com.ecomerce.Authentication.service;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

@Service
public class OTPService {

    public String otpVerification(String otp, HttpSession session) {
        return (String) session.getAttribute(otp);
    }
}
