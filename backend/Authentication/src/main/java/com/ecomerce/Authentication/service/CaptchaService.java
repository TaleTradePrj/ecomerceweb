package com.ecomerce.Authentication.service;

import com.ecomerce.Authentication.models.CaptchaResponse;
import com.ecomerce.Authentication.systemutils.IdManager;
import com.google.code.kaptcha.Producer;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

@Service
public class CaptchaService {
    @Autowired
    private IdManager idManager;
    @Autowired
    private Producer captchaproducer;

    public void generateCaptcha(HttpServletResponse httpServletResponse, HttpSession httpSession) throws IOException {
        httpServletResponse.setContentType("image/jpeg");
        String captchaText = captchaproducer.createText();
        String id = setCapDataInSession(httpSession, captchaText);
        httpServletResponse.setHeader("captcha_id", id);
        BufferedImage bufferedImage = captchaproducer.createImage(captchaText);
        try (OutputStream outputStream = httpServletResponse.getOutputStream()) {
            ImageIO.write(bufferedImage, "jpg", outputStream);
        }
    }

    public String setCapDataInSession(HttpSession httpSession, String captchaText) {
        Map<String, String> map = new HashMap<>();
        String id = idManager.sixDId();
        map.put("cap_val", captchaText);
        map.put("count", "0");
        httpSession.setAttribute(id, map);
        System.out.println(map);
        return id;
    }

    public CaptchaResponse verifyCaptcha(HttpSession httpSession, String captchaId, String captcha) {
        System.out.println("inside verify captcha");
        @SuppressWarnings("unchecked")
        Map<String, String> map = (Map<String, String>) httpSession.getAttribute(captchaId);
        System.out.println(map);

        if (null != map) {
            System.out.println("in");
            int count = Integer.parseInt(map.get("count"));
            if (count < 10) {
                if (map.get("cap_val").equals(captcha))
                    return CaptchaResponse.builder().status(true).message("Captcha Matched").build();
                else {
                    count++;
                    map.put("count", String.valueOf(count));
                    httpSession.setAttribute(captchaId, map);
                    return CaptchaResponse.builder().message("invalid captcha").build();
                }
            } else {
                return CaptchaResponse.builder().limitOver(true).message("Try again later!!!").build();
            }
        } else {
            return CaptchaResponse.builder().wrongId(true).message("Invalid Captcha Id").build();
        }
    }

}
