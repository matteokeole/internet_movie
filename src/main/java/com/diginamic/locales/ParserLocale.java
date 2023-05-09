package com.diginamic.locales;

public enum ParserLocale {
	WELCOME("Welcome to the Internet Movie database setup. This will help you to populate the database with a JSON file."),
	FILE_PATH_PROMPT("JSON file path [%s]:"),
	IMPORT_STARTED("Importing file '%s'..."),
	CURSOR("> "),
	ERROR_INVALID_FILE_PATH("Invalid file path '%s', please retry.");

	private final String value;

	private ParserLocale(final String value) {
		this.value = value;
	}

	public String toString() {
		return value;
	}
}