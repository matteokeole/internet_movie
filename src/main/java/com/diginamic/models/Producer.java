package com.diginamic.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Producer {
	@Id
	private String name;

	private String url;

	@ManyToMany(mappedBy="producers")
	private List<Movie> movies = new ArrayList<>();

	@JsonProperty("identite")
	public String getName() {
		return name;
	}

	@JsonProperty("url")
	public String getUrl() {
		return url;
	}

	public List<Movie> getMovies() {
		return movies;
	}
}