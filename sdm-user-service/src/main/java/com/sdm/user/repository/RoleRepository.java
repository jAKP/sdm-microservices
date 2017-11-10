package com.sdm.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sdm.user.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

	List<Role> findAll();

}
