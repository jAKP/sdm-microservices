package com.sdm.config.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sdm.config.model.Config;
import com.sdm.config.repository.ConfigRepository;

@RestController
public class ConfigController {

	protected Logger logger = Logger.getLogger(ConfigController.class.getName());

	@Autowired
	private ConfigRepository configRepository;

	@GetMapping("/configs")
	public Config[] all() {
		List<Config> configs = configRepository.findAll();
		return configs.toArray(new Config[configs.size()]);
	}

	@GetMapping("/configs/{config}")
	public Config findByUsername(@PathVariable(value = "config") String username) {
		return configRepository.findOne(Example.of(new Config.ConfigBuilder(username, null).build()));
	}

	@PostMapping(value = "/configs")
	public Config save(@RequestBody Config config) {
		return configRepository.save(config);
	}

}
