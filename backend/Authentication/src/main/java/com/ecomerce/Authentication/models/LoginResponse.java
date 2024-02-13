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
public class LoginResponse {
    private boolean status;
    private boolean notExist;
    private boolean notVerified;
    private String emailId;
    private String firstName;
    private String lastName;
    private String profilePath;
    private List<Role> roles;
    private String message;
}
