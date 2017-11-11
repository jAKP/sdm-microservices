package com.sdm.user.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.sdm.user.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, Long> {

	User findByUsername(String username);

	List<User> findAll();

	User findByEmail(String email);

}
