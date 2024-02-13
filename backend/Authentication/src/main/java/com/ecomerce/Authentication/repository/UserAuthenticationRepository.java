package com.ecomerce.Authentication.repository;

import com.ecomerce.Authentication.entity.User;
import com.ecomerce.Authentication.entity.UserAuthentication;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAuthenticationRepository extends MongoRepository<UserAuthentication, ObjectId> {
    UserAuthentication findByVerificationToken(String verificationToken);

    UserAuthentication findByUser(User user);
}
