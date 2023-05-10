package com.diginamic.services;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.diginamic.JPAManager;
import com.diginamic.models.Movie;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.persistence.EntityManager;

public class MovieService {
	private static final EntityManager manager = JPAManager.getInstance().getEntityManager();

	public static Movie[] parse(final File file) throws IOException {
		final ObjectMapper mapper = new ObjectMapper();

		return mapper
			.setDateFormat(new SimpleDateFormat("yyyy-M-dd"))
			.setSerializationInclusion(Include.NON_NULL)
			.readValue(file, Movie[].class);
	}

	public static void persist(final Movie[] movies) {
		for (final Movie movie : movies) {
			manager.getTransaction().begin();
			manager.merge(movie);
			manager.getTransaction().commit();
		}

		manager.close();
	}

	public static List<Movie> findOne(final String id) {
		return manager
			.createNamedQuery("Movie.findOne", Movie.class)
			.setParameter("id", id)
			.getResultList();
	}
}