package com.diginamic.locales;

public enum ParserLocale {
	WELCOME("Welcome to the Internet Movie database setup.\nPlease enter the path of the JSON database file."),
	FILE_PATH_PROMPT("JSON file path [%s]:"),
	IMPORT_STARTED("Importing '%s'... "),
	PARSING_STARTED("Parsing '%s'... "),
	CURSOR("> "),
	DONE("Done."),
	ERROR_FILE("File '%s' not found, please retry."),
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