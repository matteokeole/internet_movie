package com.diginamic;

import com.diginamic.locales.ParserLocale;
import com.diginamic.models.Movie;
import com.diginamic.services.MovieService;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Parser {
	private static final String defaultFilePath = "database.json";
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(final String[] args) {
		System.out.println(ParserLocale.WELCOME);

		String filePath = null;

		while (filePath == null) filePath = getFilePath();

		scanner.close();

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
				movies = MovieService.parse(file);
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
				MovieService.persist(movies);
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

		String filePath = scanner.nextLine().trim();

		System.out.println();

		if (filePath.isEmpty()) return defaultFilePath;

		return filePath;
	}
}