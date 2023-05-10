package com.diginamic.repository;


import java.util.List;

import com.diginamic.JPA;
import com.diginamic.models.Actor;

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

	public static List<Actor> findByMovie(final String movieId) {
		return JPA
			.getInstance()
			.getEntityManager()
			.createNamedQuery("Actor.findByMovie", Actor.class)
			.setParameter("movieId", movieId)
			.getResultList();
	}
}