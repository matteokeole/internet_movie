package com.diginamic.models;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = Movie.class, resolver = CustomObjectIdResolver.class)
public class Movie {
	private String id;
	private Country country;
	private String name;
	private String url;
	private String description;
	private String language;
	private FilmingLocation filmingLocation;
	private Producer[] producers;
	private Actor[] casting;
	private Date releaseDate;
	private Role[] roles;
	private String[] genres;

	public String toString() {
		return String.format("%s - %s", id, name);
	}

	@JsonProperty("id")
	public String getId() {
		return id;
	}

	@JsonProperty("pays")
	public Country getCountry() {
		return country;
	}

	@JsonProperty("nom")
	public String getName() {
		return name;
	}

	@JsonProperty("url")
	public String getUrl() {
		return url;
	}

	@JsonProperty("plot")
	public String getDescription() {
		return description;
	}

	@JsonProperty("langue")
	public String getLanguage() {
		return language;
	}

	@JsonProperty("lieuTournage")
	public FilmingLocation getFilmingLocation() {
		return filmingLocation;
	}

	@JsonProperty("realisateurs")
	public Producer[] getProducers() {
		return producers;
	}

	@JsonProperty("castingPrincipal")
	public Actor[] getCasting() {
		return casting;
	}

	@JsonProperty("anneeSortie")
	public Date getReleaseDate() {
		return releaseDate;
	}

	@JsonProperty("roles")
	public Role[] getRoles() {
		return roles;
	}

	@JsonProperty("genres")
	public String[] getGenres() {
		return genres;
	}
}