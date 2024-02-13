package com.ecomerce.Authentication.repository;

import com.ecomerce.Authentication.entity.Role;
import com.ecomerce.Authentication.entity.User;
import com.ecomerce.Authentication.entity.UserRole;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleRepository extends MongoRepository<UserRole, ObjectId> {

    List<Role> findByUser(User user);
}
