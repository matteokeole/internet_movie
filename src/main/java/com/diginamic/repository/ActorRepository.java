package com.diginamic.repository;


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
}