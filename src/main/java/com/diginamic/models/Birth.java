package com.diginamic.models;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Embeddable;

@Embeddable
public class Birth {
	private Date birthDate;

	private String birthPlace;

	@JsonProperty("dateNaissance")
	public Date getBirthDate() {
		return birthDate;
	}

	@JsonProperty("lieuNaissance")
	public String getBirthPlace() {
		return birthPlace;
	}
}