package com.ecomerce.Authentication.repository;

import com.ecomerce.Authentication.entity.Role;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends MongoRepository<Role, ObjectId> {
    Role findByRoleName(String roleName);
}
