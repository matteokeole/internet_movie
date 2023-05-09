package com.diginamic.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Genre {
	@Id
	private Long id;

	private String name;

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}