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
		
	public void sendMail(String email, String authtoken) throws MessagingException {
		MimeMessage message = mailsender.createMimeMessage();

	    message.setFrom(new InternetAddress("ecomerceweb46@gmail.com"));
	    message.setRecipients(MimeMessage.RecipientType.TO, email);
	    message.setSubject("Test email from Spring");

	    String htmlContent = "<h3>please verify the email using the link below</h1>" +
                "<a href='localhost:8081/signupverification?authtoken=" + authtoken + "'> please click here to verify your account</a>";
	    message.setContent(htmlContent, "text/html; charset=utf-8");

	    mailsender.send(message);
	}
}