package com.ecomerce.Authentication.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CaptchaResponse {
    private static final long serialVersionUID = 1L;
    private boolean status;
    private boolean limitOver;
    private boolean wrongId;
    private String message;
}
