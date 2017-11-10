package com.sdm.user.controller;

import java.util.HashSet;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Example;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sdm.user.model.User;
import com.sdm.user.repository.RoleRepository;
import com.sdm.user.repository.UserRepository;

@RestController
public class UserController {
	protected Logger logger = Logger.getLogger(UserController.class.getName());

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private UserRepository userRepository;

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@GetMapping("/users")
	public User[] all() {
		List<User> users = userRepository.findAll();
		return users.toArray(new User[users.size()]);
	}

	@RequestMapping(value = "/users/{username}", method = RequestMethod.GET)
	public User findByUsername(@PathVariable(value = "username") String username) {
		logger.info("####### UserController ## findByName ## username = " + username);
		return userRepository.findOne(Example.of(new User.UserBuilder(username, null).build()));
	}

	@PostMapping(value = "/users")
	public User save(@RequestBody User user) {
		user.setPassword(bCryptPasswordEncoder().encode(user.getPassword()));
		user.setRoles(new HashSet<>(roleRepository.findAll()));
		return userRepository.save(user);
	}

}
