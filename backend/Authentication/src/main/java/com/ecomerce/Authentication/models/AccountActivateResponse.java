package com.ecomerce.Authentication.models;

import com.ecomerce.Authentication.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountActivateResponse {
    private static final long serialVersionUID = 1L;
    private boolean status;
    private String message;
    private String emailId;
    private String fullName;
    private String profilePath;
    private String token;
    private String refreshToken;
    private List<Role> userRoles;
}
