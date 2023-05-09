package com.diginamic.locales;

public enum ReaderLocale {
	WELCOME("Welcome to the Internet Movie database reader. What do you want to get?"),
	OPTION_1("[1] Display an actor's filmography"),
	OPTION_2("[2] Display a movie's casting"),
	OPTION_3("[3] Display movies released within a given interval"),
	OPTION_4("[4] Display movies that share 2 actors"),
	OPTION_5("[5] Display actors that played in 2 given movies"),
	OPTION_6("[6] Display movies released within a given interval and that include the given actor in their casting"),
	OPTION_7("[7] Quit"),
	CURSOR("> "),
	QUIT("Bye"),
	ERROR_INPUT_MISMATCH("Invalid action '%s', please retry.");

	private final String value;

	private ReaderLocale(final String value) {
		this.value = value;
	}

	public String toString() {
		return value;
	}
}