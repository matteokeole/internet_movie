package com.diginamic.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FilmingLocation {
	private Long id;
	private String city;
	private String department;
	private String country;

	public String toString() {
		return city;
	}

	public Long getId() {
		return id;
	}

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