package com.sdm_client.repository;

import java.util.List;

import com.sdm_client.model.User;

public interface UserRepository {

	User findByUsername(String username);

	List<User> getAllUsers();
	
	User save(User user);

}
