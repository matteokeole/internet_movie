package com.diginamic.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Producer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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