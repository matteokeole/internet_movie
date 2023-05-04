package com.diginamic.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Role {
	private Long id;
	private String character;
	private Actor actor;
	private Movie movie;

	public String toString() {
		return character;
	}

	public Long getId() {
		return id;
	}

	@JsonProperty("characterName")
	public String getCharacter() {
		return character;
	}

	@JsonProperty("acteur")
	public Actor getActor() {
		return actor;
	}

	@JsonProperty("film")
	public Movie getMovie() {
		return movie;
	}
}