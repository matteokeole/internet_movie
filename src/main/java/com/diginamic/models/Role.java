package com.diginamic.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
@JsonIgnoreProperties(value={"film"})
public class Role {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String character;

	@ManyToOne(fetch=FetchType.LAZY)
	private Movie movie;

	@ManyToOne(cascade=CascadeType.MERGE)
	private Actor actor;

	public Long getId() {
		return id;
	}

	@JsonProperty("characterName")
	public String getCharacter() {
		return character;
	}

	public Movie getMovie() {
		return movie;
	}

	@JsonProperty("acteur")
	public Actor getActor() {
		return actor;
	}
}