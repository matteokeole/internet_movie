package com.diginamic.repository;

import java.util.List;

import com.diginamic.JPA;
import com.diginamic.models.Movie;

public class MovieRepository {
	public static List<Movie> findByActor(final String actorId) {
		return JPA
			.getInstance()
			.getEntityManager()
			.createNamedQuery("Movie.findByActor", Movie.class)
			.setParameter("actorId", actorId)
			.getResultList();
	}
}