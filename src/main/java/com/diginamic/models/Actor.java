package com.diginamic.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id", scope=Actor.class, resolver=CustomObjectIdResolver.class)
@JsonIgnoreProperties(value={"roles"})
public class Actor {
	@Id
	private String id;

	private String identity;

	@Embedded
	private Birth birth;

	private String url;

	private Float height;

	// @ManyToMany(mappedBy="casting")
	// private List<Movie> movies = new ArrayList<>();

	@OneToMany(mappedBy="actor")
	private List<Role> roles = new ArrayList<>();

	@JsonProperty("id")
	public String getId() {
		return id;
	}

	@JsonProperty("identite")
	public String getIdentity() {
		return identity;
	}

	@JsonProperty("naissance")
	public Birth getBirth() {
		return birth;
	}

	@JsonProperty("url")
	public String getUrl() {
		return url;
	}

	@JsonProperty("height")
	public Float getHeight() {
		return height;
	}

	/* public List<Movie> getMovies() {
		return movies;
	} */

	public List<Role> getRoles() {
		return roles;
	}
}