package com.diginamic.models;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAManager {
	private final static EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("internet_movie");
	private final static EntityManager manager = managerFactory.createEntityManager();
	private final static JPAManager instance = new JPAManager();

	public static JPAManager getInstance() {
		return instance;
	}

	public EntityManager getEntityManager() {
		return manager;
	}
}