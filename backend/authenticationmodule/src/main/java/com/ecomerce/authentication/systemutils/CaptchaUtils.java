package com.ecomerce.authentication.systemutils;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomerce.authentication.models.VerifyCapResponse;
import com.google.code.kaptcha.Producer;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Service
public class CaptchaUtils {
	@Autowired
	private CommonUtils utils;
	@Autowired
	private Producer captchaproducer;
	
	  public void generateCaptcha(HttpServletResponse response, HttpSession request) throws IOException {
		  response.setContentType("image/jpeg");
	        String captchaText = captchaproducer.createText();
	        String id = setCapDataInSession(request,captchaText);
	        response.setHeader("captcha_id", id);
	        BufferedImage bufferedImage = captchaproducer.createImage(captchaText);
	        try (OutputStream outputStream = response.getOutputStream()) {
	            ImageIO.write(bufferedImage, "jpg", outputStream);
	        }
	  }

	  public String setCapDataInSession(HttpSession session, String captchaText) {
		    Map<String, String> map = new HashMap<>();
		    String id = utils.sixDId();
		    map.put("cap_val", captchaText);
		    map.put("count", "0");
		    session.setAttribute(id, map);
		    System.out.println(map);
		    return id;
		}

	  public VerifyCapResponse verifyCaptcha(HttpSession session, String captchaId, String captcha) {
		    System.out.println("inside verifycaptcha");
		    @SuppressWarnings("unchecked")
		    Map<String, String> map = (Map<String, String>) session.getAttribute(captchaId);
		    System.out.println(map);

		    if (null != map) {
		        System.out.println("in");
		        int count = Integer.parseInt(map.get("count"));
		        if(count < 10) {
		            if (map.get("cap_val").equals(captcha))
		                return new VerifyCapResponse(true, "captcha Matched");
		            else {
		                count++;
		                map.put("count", String.valueOf(count));
		                session.setAttribute(captchaId, map);
		                return new VerifyCapResponse(false);
		            }
		        } else {
		            return new VerifyCapResponse(false, true, "please try again later");
		        }
		    } else {
		        return new VerifyCapResponse("invalidCaptchaId", true);
		    }
		}


}
