package com.diginamic.locales;

public enum ParserLocale {
	WELCOME("Welcome to the Internet Movie database setup. This will help you to populate the database with a JSON file."),
	FILE_PATH_PROMPT("JSON file path [%s]:"),
	IMPORT_STARTED("Importing '%s'... "),
	PARSING_STARTED("Parsing '%s'... "),
	CURSOR("> "),
	DONE("Done."),
	ERROR_FILE("Could not open the file: %s"),
	ERROR_IMPORT("An error occurred during import: %s"),
	ERROR_INVALID_FILE_PATH("Invalid file path '%s', please retry."),
	ERROR_PARSING("An error occurred during parsing: %s"),
	EXECUTION_TIME("Execution time: %ss.");

	private final String value;

	private ParserLocale(final String value) {
		this.value = value;
	}

	public String toString() {
		return value;
	}
}