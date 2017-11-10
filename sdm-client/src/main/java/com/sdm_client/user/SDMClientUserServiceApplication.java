package com.sdm_client.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.sdm_client.user.repository.RemoteRoleRepository;
import com.sdm_client.user.repository.RemoteUserRepository;
import com.sdm_client.user.repository.RoleRepository;
import com.sdm_client.user.repository.UserRepository;

@SpringBootApplication
@EnableDiscoveryClient
public class SDMClientUserServiceApplication {

	public static final String SDM_USER_SERVICE_URL = "http://sdm-user-microservice";

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	public UserRepository userRepository() {
		return new RemoteUserRepository(SDM_USER_SERVICE_URL);
	}
	
	@Bean
	public RoleRepository roleRepository() {
		return new RemoteRoleRepository(SDM_USER_SERVICE_URL);
	}

	public static void main(String[] args) {
		SpringApplication.run(SDMClientUserServiceApplication.class, args);
	}

}