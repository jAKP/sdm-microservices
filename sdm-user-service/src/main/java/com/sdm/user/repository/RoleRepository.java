package com.sdm.user.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.sdm.user.model.Role;

@Repository
public interface RoleRepository extends MongoRepository<Role, Long> {

	List<Role> findAll();

}
