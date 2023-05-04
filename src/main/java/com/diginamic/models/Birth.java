package com.diginamic.models;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Birth {
	private Long id;
	private Date birthDate;
	private String birthPlace;
	
	public String toString() {
		return birthPlace;
	}

	public Long getId() {
		return id;
	}

	@JsonProperty("dateNaissance")
	public Date getBirthDate() {
		return birthDate;
	}

	@JsonProperty("lieuNaissance")
	public String getBirthPlace() {
		return birthPlace;
	}
}