package com.sdm_client.repository;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.sdm_client.model.Role;

/**
 * @author Alok.Pandey
 *
 */
public class RemoteRoleRepository implements RoleRepository {

	@Autowired
	protected RestTemplate restTemplate;

	protected String serviceUrl;

	public RemoteRoleRepository(String serviceUrl) {
		this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl : "http://" + serviceUrl;
	}

	@Override
	public Role findByRoleid(Long roleid) {
		return restTemplate.getForObject(serviceUrl + "/roles/{id}", Role.class, roleid);
	}

	@Override
	public List<Role> getAllRole() {
		Role[] users = restTemplate.getForObject(serviceUrl + "/roles", Role[].class);
		return Arrays.asList(users);
	}

}
