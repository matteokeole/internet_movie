package com.diginamic.services;

import com.diginamic.App;
import com.diginamic.JPA;
import com.diginamic.locales.ParserLocale;
import com.diginamic.models.Movie;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.persistence.EntityManager;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class ParserService {
	private static final String defaultFilePath = "database.json";

	public static void main(final String[] args) {
		System.out.println(ParserLocale.WELCOME);

		String filePath = null;

		while (filePath == null) filePath = getFilePath();

		final File file = new File(filePath);

		if (!file.exists()) {
			System.out.println(String.format(ParserLocale.ERROR_FILE.toString(), file));

			return;
		}

		final long then = System.currentTimeMillis();
		final Movie[] movies;

		// Parsing
		{
			System.out.print(String.format(ParserLocale.PARSING_STARTED.toString(), filePath));

			try {
				movies = parse(file);
			} catch (final IOException exception) {
				System.out.print("\n\n");
				System.out.println(String.format(ParserLocale.ERROR_PARSING.toString(), exception));

				return;
			}

			System.out.println(ParserLocale.DONE);
		}

		// Import
		{
			System.out.print(String.format(ParserLocale.IMPORT_STARTED.toString(), filePath));

			try {
				persist(movies);
			} catch (final Exception exception) {
				System.out.print("\n\n");
				System.out.println(String.format(ParserLocale.ERROR_IMPORT.toString(), exception));

				return;
			}

			System.out.println(ParserLocale.DONE);
		}

		final long executionTime = (System.currentTimeMillis() - then) / 1000;

		System.out.println(String.format(ParserLocale.EXECUTION_TIME.toString(), executionTime));
	}

	private static String getFilePath() {
		System.out.println();
		System.out.println(String.format(ParserLocale.FILE_PATH_PROMPT.toString(), defaultFilePath));
		System.out.print(ParserLocale.CURSOR);

		String filePath = App.scanner.nextLine().trim();

		System.out.println();

		if (filePath.isEmpty()) return defaultFilePath;

		return filePath;
	}

	private static Movie[] parse(final File file) throws IOException {
		final ObjectMapper mapper = new ObjectMapper();

		return mapper
			.setDateFormat(new SimpleDateFormat("yyyy-M-dd"))
			.setSerializationInclusion(Include.NON_NULL)
			.readValue(file, Movie[].class);
	}

	private static void persist(final Movie[] movies) {
		final EntityManager manager = JPA.getInstance().getEntityManager();

		for (final Movie movie : movies) {
			manager.getTransaction().begin();
			manager.merge(movie);
			manager.getTransaction().commit();
		}
	}
}