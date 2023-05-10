package com.diginamic;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPA {
	private final static EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("internet_movie");
	private final static EntityManager manager = managerFactory.createEntityManager();
	private final static JPA instance = new JPA();

	private JPA() {}

	public static JPA getInstance() {
		return instance;
	}

	public EntityManager getEntityManager() {
		return manager;
	}
}