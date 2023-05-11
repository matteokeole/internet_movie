package com.diginamic.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Genre {
	@Id
	private String name;

	@ManyToMany(mappedBy="genres")
	private List<Movie> movies = new ArrayList<>();

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public List<Movie> getMovies() {
		return movies;
	}
}