package com.diginamic.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;

@Entity
@JsonIgnoreProperties(value={"height", "roles"})
@NamedQueries({
	@NamedQuery(name="Actor.find", query="SELECT actor FROM Actor actor WHERE actor.id = :actorId"),
	@NamedQuery(name="Actor.findByMovie", query="SELECT actor FROM Actor actor JOIN actor.roles role JOIN role.movie movie WHERE movie.id = :movieId"),
	@NamedQuery(name="Actor.findByTwoMovies", query="SELECT actor FROM Actor actor JOIN actor.roles role1 JOIN role1.movie movie1 JOIN actor.roles role2 JOIN role2.movie movie2 WHERE movie1.id = :firstMovieId AND movie2.id = :secondMovieId"),
})
public class Actor {
	@Id
	private String id;

	private String name;

	@Column(name="birth_date")
	private String birthDate;

	@Column(name="birth_place")
	private String birthPlace;

	private String url;

	@OneToMany(mappedBy="actor")
	private List<Role> roles = new ArrayList<>();

	public String toString() {
		return name;
	}

	@JsonProperty("id")
	public String getId() {
		return id;
	}

	@JsonProperty("identite")
	public String getName() {
		return name;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public String getBirthPlace() {
		return birthPlace;
	}

	@JsonProperty("naissance")
	private void setBirth(final Map<String, String> birth) {
		if (birth == null) return;

		birthDate = birth.get("dateNaissance");
		birthPlace = birth.get("lieuNaissance");
	}

	@JsonProperty("url")
	public String getUrl() {
		return url;
	}

	public List<Role> getRoles() {
		return roles;
	}
}