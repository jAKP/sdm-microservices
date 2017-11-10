package com.sdm_client.user.repository;

import java.util.List;

import com.sdm_client.user.model.Role;

public interface RoleRepository {

	Role findByRoleid(Long roleid);

	List<Role> getAllRole();

}
