package com.sdm_client.service;

public interface SecurityService {

	String findLoggedInUsername();

	void autologin(String username, String password);
}
