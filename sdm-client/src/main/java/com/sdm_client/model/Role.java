package com.sdm_client.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Set;

public class Role implements Serializable {

	private static final long serialVersionUID = 1L;
	private BigInteger id;
	private String name;
	private Set<User> users;

	public Role(BigInteger id, String name) {
		this.id = id;
		this.name = name;
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}
}
