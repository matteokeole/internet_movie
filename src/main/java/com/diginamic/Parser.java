package com.diginamic;

import com.diginamic.models.JPAManager;
import com.diginamic.models.Movie;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.persistence.EntityManager;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Parser {
	private static final String defaultFilePath = "database.json";
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(final String[] args) {
		System.out.println(Locale.WELCOME);

		String filePath = null;

		while (filePath == null) filePath = getFilePath();

		System.out.println(String.format(Locale.IMPORT_STARTED.toString(), filePath));

		final File file;

		try {
			file = new File(filePath);
		} catch (final NullPointerException exception) {
			exception.printStackTrace();

			return;
		}

		final ObjectMapper mapper = new ObjectMapper();

		mapper
			.setDateFormat(new SimpleDateFormat("yyyy-M-dd"))
			.setSerializationInclusion(Include.NON_NULL);

		Movie[] movies = {};

		try {
			movies = mapper.readValue(file, Movie[].class);
		} catch (final IOException exception) {
			exception.printStackTrace();

			return;
		}

		final EntityManager manager = JPAManager.getInstance().getEntityManager();

		manager.getTransaction().begin();

		for (final Movie movie : movies) manager.persist(movie);

		manager.getTransaction().commit();

		scanner.close();
	}

	public static String getFilePath() {
		System.out.println();
		System.out.println(String.format(Locale.FILE_PATH_PROMPT.toString(), defaultFilePath));
		System.out.print(Locale.CURSOR);

		String filePath = scanner.nextLine().trim();

		System.out.println();

		if (filePath.isEmpty()) return defaultFilePath;
		if (!filePath.endsWith(".json")) {
			System.out.println(String.format(Locale.FILE_PATH_INVALID.toString(), filePath));

			return null;
		}

		return filePath;
	}
}