package com.ecomerce.Authentication.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserSignupRequest {
    private String emailId;
    private String firstName;
    private String lastName;
    private String profilePath;
    private String password;
    private String confirmPassword;
    private String captchaId;
    private String captcha;
    private int agreedTermsandCondition;
    private int age;
    private int gender;
}
