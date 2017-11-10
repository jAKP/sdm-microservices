package com.sdm_client.user.repository;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.sdm_client.user.model.User;

/**
 * @author Alok.Pandey
 *
 */
public class RemoteUserRepository implements UserRepository {

	@Autowired
	protected RestTemplate restTemplate;

	protected String serviceUrl;

	protected Logger logger = Logger.getLogger(RemoteUserRepository.class.getName());

	public RemoteUserRepository(String serviceUrl) {
		this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl : "http://" + serviceUrl;
	}

	@Override
	public User findByUsername(String username) {
		logger.info("####### RemoteUserRepository ## findByUsername ##");
		return restTemplate.getForObject(serviceUrl + "/users/{username}", User.class, username);
	}

	@Override
	public List<User> getAllUsers() {
		User[] users = restTemplate.getForObject(serviceUrl + "/users", User[].class);
		return Arrays.asList(users);
	}

	@Override
	public User save(User user) {
		logger.info("####### RemoteUserRepository ## save ##");
		return restTemplate.postForObject(serviceUrl + "/users", user, User.class);
	}

	// @Override
	// public User findByEmail(String email) {
	// logger.info("####### UserController ## findByEmail ##");
	// return restTemplate.getForObject(serviceUrl + "/users/{email}", User.class,
	// email);
	// }

}
