package com.diginamic.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;

import jakarta.persistence.Embeddable;

@Embeddable
public class Genres {
	private List<Genre> genres;

	@JsonCreator
	public Genres() {
		//
	}

	public List<Genre> getGenres() {
		return genres;
	}
}