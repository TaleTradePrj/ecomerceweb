package com.ecomerce.authentication.systemutils;

import java.util.Base64;
import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class CommonUtils {
	public boolean isEmpty(Object data) {
		if(null==data)
			return true;
		return false;
	}
	public String generateToken() {
		UUID uuid = UUID.randomUUID();
		return encrypt(uuid.toString());
	}
	public String encrypt(String data) {
		return Base64.getEncoder().encodeToString(data.getBytes());
	}
	public String decrypt(String data) {
		byte[] decodedBytes = Base64.getDecoder().decode(data);
        return new String(decodedBytes);
	}
	public String sixDId() {
        return String.format("%06d", UUID.randomUUID().getMostSignificantBits() & 0xFFFFFF);
    }
}
