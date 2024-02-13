package com.ecomerce.Authentication.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender javaMailSender;

    public boolean sendMail(String email, String otp) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        mimeMessage.setFrom(new InternetAddress("ecomerceweb46@gmail.com"));
        mimeMessage.setRecipients(MimeMessage.RecipientType.TO, email);
        mimeMessage.setSubject("Ecommerce Verification Mail");

        String htmlContent = "<p>Please verify your email using the link below:</p>"
                + "<p>Ecommerce OTP- "+otp+"</p>";
        mimeMessage.setText(htmlContent);
       try {
            javaMailSender.send(mimeMessage);
            return true;
       }catch (MailException e){
           e.printStackTrace();
           return false;
       }

    }
}
