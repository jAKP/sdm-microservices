package com.sdm_client.user.service;

public interface SecurityService {

	String findLoggedInUsername();

	void autologin(String username, String password);
}
