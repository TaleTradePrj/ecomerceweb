package com.ecomerce.authentication.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ecomerce.authentication.entity.User;

@Repository
public interface UserRepository extends MongoRepository<User, ObjectId> {

	User findByEmailId(String email);

	User findByUserId(ObjectId objectId);

}
