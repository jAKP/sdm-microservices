package com.sdm_client.repository;

import java.util.List;

import com.sdm_client.model.Role;

public interface RoleRepository {

	Role findByRoleid(Long roleid);

	List<Role> getAllRole();

}
