package com.diginamic.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="filming_location")
public class FilmingLocation {
	@Id
	private String city;

	private String department;

	private String country;

	@JsonProperty("ville")
	public String getCity() {
		return city;
	}

	@JsonProperty("etatDept")
	public String getDepartment() {
		return department;
	}

	@JsonProperty("pays")
	public String getCountry() {
		return country;
	}
}