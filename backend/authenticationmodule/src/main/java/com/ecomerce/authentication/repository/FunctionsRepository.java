package com.ecomerce.authentication.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ecomerce.authentication.entity.Functions;

@Repository
public interface FunctionsRepository extends MongoRepository<Functions, ObjectId>{

}
