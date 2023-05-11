package com.diginamic.repository;


import java.util.List;

import com.diginamic.JPA;
import com.diginamic.models.Actor;
import com.diginamic.models.Movie;

public class ActorRepository {
	public static Actor find(final String actorId) {
		return JPA
			.getInstance()
			.getEntityManager()
			.createNamedQuery("Actor.find", Actor.class)
			.setParameter("actorId", actorId)
			.getResultList()
			.stream()
			.findFirst()
			.orElse(null);
	}

	public static List<Actor> findByMovie(final Movie movie) {
		return JPA
			.getInstance()
			.getEntityManager()
			.createNamedQuery("Actor.findByMovie", Actor.class)
			.setParameter("movieId", movie.getId())
			.getResultList();
	}

	public static List<Actor> findByTwoMovies(final Movie firstMovie, final Movie secondMovie) {
		return JPA
			.getInstance()
			.getEntityManager()
			.createNamedQuery("Actor.findByTwoMovies", Actor.class)
			.setParameter("firstMovieId", firstMovie.getId())
			.setParameter("secondMovieId", secondMovie.getId())
			.getResultList();
	}
}