package com.diginamic.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = Actor.class, resolver = CustomObjectIdResolver.class)
@JsonIgnoreProperties(value = {"roles"})
public class Actor {
	private String id;
	private String identity;
	private Birth birth;
	private String url;
	private float height;

	public String toString() {
		return identity;
	}

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
	public float getHeight() {
		return height;
	}
}