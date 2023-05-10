package com.diginamic.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
@JsonIgnoreProperties(value={"height", "roles"})
public class Actor {
	@Id
	private String id;

	private String identity;

	@Column(name="birth_date")
	private String birthDate;

	@Column(name="birth_place")
	private String birthPlace;

	private String url;

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