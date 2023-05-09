package com.diginamic.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
// @JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id", scope=Movie.class, resolver=CustomObjectIdResolver.class)
@JsonIgnoreProperties(value={"castingPrincipal", "genres"})
public class Movie {
	@Id
	private String id;

	@ManyToOne(cascade=CascadeType.ALL)
	private Country country;

	private String name;

	private String url;

	private String description;

	private String language;

	@ManyToOne(cascade=CascadeType.ALL)
	private FilmingLocation filmingLocation;

	@ManyToMany(cascade=CascadeType.ALL)
	private List<Producer> producers = new ArrayList<>();

	private String releaseDate;

	@OneToMany(mappedBy="movie", cascade=CascadeType.MERGE)
	private List<Role> roles = new ArrayList<>();

	@ManyToMany(cascade=CascadeType.ALL)
	private List<Genre> genres = new ArrayList<>();

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
	public List<Producer> getProducers() {
		return producers;
	}

	@JsonProperty("anneeSortie")
	public String getReleaseDate() {
		return releaseDate;
	}

	@JsonProperty("roles")
	public List<Role> getRoles() {
		return roles;
	}

	// @JsonProperty("genres")
	public List<Genre> getGenres() {
		return genres;
	}
}