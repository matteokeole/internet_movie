package com.diginamic.repository;

import java.util.List;

import com.diginamic.JPA;
import com.diginamic.models.Movie;

public class MovieRepository {
	public static Movie find(final String movieId) {
		return JPA
			.getInstance()
			.getEntityManager()
			.createNamedQuery("Movie.find", Movie.class)
			.setParameter("movieId", movieId)
			.getResultList()
			.stream()
			.findFirst()
			.orElse(null);
	}

	public static List<Movie> findByActor(final String actorId) {
		return JPA
			.getInstance()
			.getEntityManager()
			.createNamedQuery("Movie.findByActor", Movie.class)
			.setParameter("actorId", actorId)
			.getResultList();
	}

	public static List<Movie> findBetween(final int startYear, final int endYear) {
		return JPA
			.getInstance()
			.getEntityManager()
			.createNamedQuery("Movie.findBetween", Movie.class)
			.setParameter("startYear", startYear)
			.setParameter("endYear", endYear)
			.getResultList();
	}
}