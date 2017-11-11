package com.sdm_client.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Set;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	private BigInteger id;
	private String username;
	private String email;
	private String password;
	private String passwordConfirm;
	private Set<Role> roles;

	private User(UserBuilder builder) {
		this.id = builder.id;
		this.username = builder.username;
		this.email = builder.email;
		this.password = builder.password;
	}

	public static class UserBuilder {
		private BigInteger id;
		private String username;
		private String email;
		private String password;

		public UserBuilder(String username, String email) {
			this.username = username;
			this.email = email;
		}

		public UserBuilder id(BigInteger id) {
			this.id = id;
			return this;
		}

		public UserBuilder username(String username) {
			this.username = username;
			return this;
		}

		public UserBuilder email(String email) {
			this.email = email;
			return this;
		}

		public User build() {
			return new User(this);
		}

	}

	private User() {

	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
