package com.diginamic.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String character;

	@OneToOne
	private Actor actor;

	@ManyToOne
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