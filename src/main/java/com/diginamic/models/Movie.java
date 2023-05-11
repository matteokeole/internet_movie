package com.diginamic.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;

@Entity
@JsonIgnoreProperties(value={"castingPrincipal"})
@NamedQueries({
	@NamedQuery(name="Movie.find", query="SELECT movie FROM Movie movie WHERE movie.id = :movieId"),
	@NamedQuery(name="Movie.findByActor", query="SELECT movie FROM Movie movie JOIN movie.roles role JOIN role.actor actor WHERE actor.id = :actorId")
})
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

	@Column(name="release_date")
	private String releaseDate;

	@OneToMany(mappedBy="movie", cascade=CascadeType.ALL)
	private List<Role> roles = new ArrayList<>();

	@ManyToMany(cascade=CascadeType.ALL)
	private List<Genre> genres = new ArrayList<>();

	public String toString() {
		if (releaseDate == null) return name;

		return String.format("%s (%s)", name, releaseDate);
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

	public List<Genre> getGenres() {
		return genres;
	}

	@JsonProperty("genres")
	public void setGenres(final String[] names) {
		if (names == null) return;

		Genre genre;

		for (final String name : names) {
			genre = new Genre();
			genre.setName(name);
			genre.getMovies().add(this);
			genres.add(genre);
		}
	}
}