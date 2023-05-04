package com.diginamic.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Producer {
	private Long id;
	private String identity;
	private String url;

	public String toString() {
		return identity;
	}

	public Long getId() {
		return id;
	}

	@JsonProperty("identite")
	public String getIdentity() {
		return identity;
	}

	@JsonProperty("url")
	public String getUrl() {
		return url;
	}
}