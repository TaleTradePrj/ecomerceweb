package com.ecomerce.Authentication.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

@Document
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private ObjectId userId;
    @Field
    private String firstName;
    @Field
    private String lastName;
    @Field
    private String profilePath;
    @Field
    private int age;
    @Field
    private String emailId;
    @Field
    private int gender;
    @Field
    private int userStatus;
}
