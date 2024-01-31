package com.ecomerce.authentication.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ecomerce.authentication.entity.UserRole;

@Repository
public interface UserRoleRepository extends MongoRepository<UserRole, ObjectId>{

}
