package com.ecomerce.Authentication.repository;

import com.ecomerce.Authentication.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, ObjectId> {
    User findByEmailId(String email);

    User findByUserId(ObjectId objectId);
}
