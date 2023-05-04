package com.diginamic.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Country {
	private Long id;
	private String name;
	private String url;

	public String toString() {
		return name;
	}

	public Long getId() {
		return id;
	}

	@JsonProperty("nom")
	public String getName() {
		return name;
	}

	@JsonProperty("url")
	public String getUrl() {
		return url;
	}
}