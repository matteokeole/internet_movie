package com.diginamic.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Role {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String character;

	@ManyToOne(cascade=CascadeType.PERSIST)
	private Actor actor;

	@ManyToOne(cascade=CascadeType.PERSIST)
	private Movie movie;

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