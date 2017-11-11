package com.sdm.config.model;

import java.io.Serializable;
import java.math.BigInteger;

//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Transient;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Config implements Serializable {

	private static final long serialVersionUID = 1L;
	private BigInteger id;
	private String configKey;
	private String configValue;

	private Config() {
	}

	private Config(ConfigBuilder builder) {
		this.id = builder.id;
		this.configKey = builder.configKey;
		this.configValue = builder.configValue;
	}

	public static class ConfigBuilder {
		private BigInteger id;
		private String configKey;
		private String configValue;

		public ConfigBuilder(String configKey, String configValue) {
			this.configKey = configKey;
			this.configValue = configValue;
		}

		public ConfigBuilder id(BigInteger id) {
			this.id = id;
			return this;
		}

		public ConfigBuilder configKey(String configKey) {
			this.configKey = configKey;
			return this;
		}

		public ConfigBuilder configValue(String configValue) {
			this.configValue = configValue;
			return this;
		}

		public Config build() {
			return new Config(this);
		}
	}

	@Id
	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getConfigKey() {
		return configKey;
	}

	public void setConfigKey(String configKey) {
		this.configKey = configKey;
	}

	public String getConfigValue() {
		return configValue;
	}

	public void setConfigValue(String configValue) {
		this.configValue = configValue;
	}
}
