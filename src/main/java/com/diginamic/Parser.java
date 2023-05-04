package com.diginamic;

import com.diginamic.models.Movie;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Scanner;

public class Parser {
	// private static final String host = "localhost";
	// private static final String username = "root";
	// private static final String password = "";
	private static final String defaultFilePath = "database.json";
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(final String[] args) throws Exception {
		System.out.println(Locale.WELCOME);

		String filePath = null;

		while (filePath == null) filePath = getFilePath();

		System.out.println(String.format(Locale.IMPORT_STARTED.toString(), filePath));

		final File file = new File(filePath);

		final ObjectMapper mapper = new ObjectMapper();

		mapper
			.setDateFormat(new SimpleDateFormat("yyyy-M-dd"))
			.setSerializationInclusion(Include.NON_NULL);

		final Movie[] movies = mapper.readValue(file, Movie[].class);

		System.out.println(Arrays.toString(movies));

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