package com.diginamic.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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

	@Column(name="character_name")
	private String characterName;

	@ManyToOne
	private Movie movie;

	@ManyToOne(cascade=CascadeType.ALL)
	private Actor actor;

	public Long getId() {
		return id;
	}

	@JsonProperty("characterName")
	public String getCharacterName() {
		return characterName;
	}

	public Movie getMovie() {
		return movie;
	}

	@JsonProperty("acteur")
	public Actor getActor() {
		return actor;
	}
}