package com.diginamic.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Producer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String identity;

	private String url;

	@ManyToMany(mappedBy="producers")
	private List<Movie> movies = new ArrayList<>();

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

	public List<Movie> getMovies() {
		return movies;
	}
}