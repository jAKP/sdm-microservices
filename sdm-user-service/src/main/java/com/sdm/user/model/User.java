package com.sdm.user.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;

@Entity
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String username;
	private String password;
	private String email;
	private String passwordConfirm;
	private Set<Role> roles;

	private User() {

	}

	private User(UserBuilder builder) {
		this.id = builder.id;
		this.username = builder.username;
		this.email = builder.email;
		this.password = builder.password;
	}
	
	public static class UserBuilder {
		private Long id;
		private String username;
		private String email;
		private String password;

		public UserBuilder(String username, String email) {
			this.username = username;
			this.email = email;
		}

		public UserBuilder id(long id) {
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

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	@Transient
	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	@ManyToMany
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
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
