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
	@NamedQuery(name="Movie.findBetween", query="SELECT movie FROM Movie movie WHERE movie.releaseDate >= :startYear AND movie.releaseDate <= :endYear ORDER BY movie.releaseDate"),
	@NamedQuery(name="Movie.findByActor", query="SELECT movie FROM Movie movie JOIN movie.roles role JOIN role.actor actor WHERE actor.id = :actorId"),
	@NamedQuery(name="Movie.findByTwoActors", query="SELECT movie FROM Movie movie JOIN movie.roles role1 JOIN role1.actor actor1 JOIN movie.roles role2 JOIN role2.actor actor2 WHERE actor1.id = :firstActorId AND actor2.id = :secondActorId"),
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
	private Integer releaseDate;

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

	public Integer getReleaseDate() {
		return releaseDate;
	}

	@JsonProperty("anneeSortie")
	public void setReleaseDate(final String releaseString) {
		if (releaseString.isBlank()) return;

		try {
			releaseDate = Integer.parseInt(releaseString.split("-|/")[0]);
		} catch (final Exception exception) {
			return;
		}
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