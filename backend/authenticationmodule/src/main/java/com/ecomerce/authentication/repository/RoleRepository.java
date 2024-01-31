package com.ecomerce.authentication.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ecomerce.authentication.entity.Role;

@Repository
public interface RoleRepository extends MongoRepository<Role, Object>{

	Role findByRoleName(String roleName);

}
