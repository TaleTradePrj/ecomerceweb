package com.ecomerce.Authentication.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

@Document
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserAuthentication implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private ObjectId userAuthId;
    @DBRef
    private User user;
    @Field
    private String password;
    @Field
    private String verificationToken;
    @Field
    private String token;
    @Field
    private String refreshToken;
}
