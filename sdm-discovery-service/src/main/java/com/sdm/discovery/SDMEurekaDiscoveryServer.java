package com.sdm.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SDMEurekaDiscoveryServer {

	public static void main(String[] args) {
		SpringApplication.run(SDMEurekaDiscoveryServer.class, args);
	}
}
