package com.sdm.config.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Set;

//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Transient;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Group implements Serializable {

	private static final long serialVersionUID = 1L;
	private BigInteger id;
	private String groupKey;
	private String groupValue;
	private Set<Config> configs;

	private Group() {

	}

	private Group(GroupBuilder builder) {
		this.id = builder.id;
		this.groupKey = builder.groupKey;
		this.groupValue = builder.groupValue;
	}

	public static class GroupBuilder {
		private BigInteger id;
		private String groupKey;
		private String groupValue;

		public GroupBuilder(String groupKey, String groupValue) {
			this.groupKey = groupKey;
			this.groupValue = groupValue;
		}

		public GroupBuilder id(BigInteger id) {
			this.id = id;
			return this;
		}

		public GroupBuilder groupKey(String groupKey) {
			this.groupKey = groupKey;
			return this;
		}

		public GroupBuilder groupValue(String groupValue) {
			this.groupValue = groupValue;
			return this;
		}

		public Group build() {
			return new Group(this);
		}

	}

	@Id
	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getGroupKey() {
		return groupKey;
	}

	public void setGroupKey(String groupKey) {
		this.groupKey = groupKey;
	}

	public String getGroupValue() {
		return groupValue;
	}

	public void setGroupValue(String groupValue) {
		this.groupValue = groupValue;
	}

	public Set<Config> getGroups() {
		return configs;
	}

	public void setGroups(Set<Config> configs) {
		this.configs = configs;
	}

}
