package com.diginamic.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Country {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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