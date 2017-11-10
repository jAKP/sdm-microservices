package com.sdm.user.controller;

import java.util.HashSet;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	@GetMapping("/users/{username}")
	public User findByName(@PathVariable String username) {
		logger.info("####### UserController ## findByName ##");
		User user = userRepository.findByUsername(username);
		logger.info("####### UserController ## findByName ## username: " + username);
		return user;
	}

	@PostMapping(value = "/users")
	public User save(@RequestBody User user) {
		logger.info("####### UserController ## save ##");
		user.setPassword(bCryptPasswordEncoder().encode(user.getPassword()));
		user.setRoles(new HashSet<>(roleRepository.findAll()));
		User user1 = userRepository.save(user);
		return user1;
	}

	// @RequestMapping("/users/{email}")
	// public User findByEmail(@PathVariable("email") String email) {
	// return userService.findByEmail(email);
	// }
}
