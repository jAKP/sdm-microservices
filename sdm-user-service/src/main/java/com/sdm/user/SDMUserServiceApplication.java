package com.sdm.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SDMUserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SDMUserServiceApplication.class, args);
	}

}