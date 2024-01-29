package com.ecomerce.authentication.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

import com.ecomerce.authentication.entity.User;
import com.ecomerce.authentication.entity.UserAuthentication;
@EnableMongoRepositories
@Repository
public interface UserAuthenticationRepository extends MongoRepository<UserAuthentication, ObjectId> {

	UserAuthentication findByAuthToken(String authtoken);
	UserAuthentication findByUser(User user);

}
