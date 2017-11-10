package com.sdm_client.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sdm_client.user.model.User;
import com.sdm_client.user.repository.UserRepository;
import com.sdm_client.user.service.SecurityService;
import com.sdm_client.user.validator.UserValidator;

@Controller
public class UserController {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private SecurityService SecurityService;

	@Autowired
	private UserValidator userValidator;

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registration(Model model) {
		model.addAttribute("userForm", new User());
		return "registration";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registration(@ModelAttribute("userForm") User user, BindingResult bindingResult, Model model) {
		userValidator.validate(user, bindingResult);
		if (bindingResult.hasErrors()) {
			return "registration";
		}
		userRepository.save(user);
		SecurityService.autologin(user.getUsername(), user.getPasswordConfirm());
		return "redirect:/welcome";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model, String error, String logout) {
		if (error != null) {
			model.addAttribute("error", "Your username and password is invalid.");
		}
		if (logout != null) {
			model.addAttribute("message", "You have been logged out successfully.");
		}
		return "login";
	}

	@RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
	public String welcome(Model model) {
		return "welcome";
	}
}
