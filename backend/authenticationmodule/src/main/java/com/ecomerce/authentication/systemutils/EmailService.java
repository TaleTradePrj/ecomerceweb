package com.ecomerce.authentication.systemutils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {
	@Autowired
	private JavaMailSender mailsender;
		
	public void sendMail(String email, String otp) throws MessagingException {
		MimeMessage message = mailsender.createMimeMessage();
	    message.setFrom(new InternetAddress("ecomerceweb46@gmail.com"));
	    message.setRecipients(MimeMessage.RecipientType.TO, email);
	    message.setSubject("Ecomerce Verificaiton Mail");

	    String htmlContent = "<p>Please verify your email using the link below:</p>"
                + "<p>Ecomerce OTP- "+otp+"</p>";
	    message.setText(htmlContent);
	    mailsender.send(message);
	}
}