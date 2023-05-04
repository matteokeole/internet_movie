package com.diginamic;

public enum Locale {
	WELCOME("Welcome to the Internet Movie database setup. This will help you to populate the database with a JSON file."),
	FILE_PATH_PROMPT("JSON file path [%s]:"),
	FILE_PATH_INVALID("Invalid file path '%s', please retry."),
	IMPORT_STARTED("Importing file '%s'..."),
	CURSOR("> ");

	private final String value;

	private Locale(final String value) {
		this.value = value;
	}

	public String toString() {
		return value;
	}
}