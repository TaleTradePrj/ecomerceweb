package com.ecomerce.Authentication.systemutils;

import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.UUID;

@Component
public class IdManager {
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
