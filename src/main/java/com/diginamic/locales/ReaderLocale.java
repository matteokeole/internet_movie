package com.diginamic.locales;

public enum ReaderLocale {
	WELCOME("Welcome to the Internet Movie database reader. What do you want to get?"),
	ACTION_1("[1] Display an actor's filmography"),
	ACTION_1_ERROR_NO_RESULT("No actor found with the ID %s."),
	ACTION_1_PROMPT_ACTOR_ID("Enter an actor ID:"),
	ACTION_1_RESULT("%s played in the following %s movie(s):"),
	ACTION_2("[2] Display a movie's casting"),
	ACTION_2_ERROR_NO_RESULT("No movie found with the ID %s."),
	ACTION_2_PROMPT_MOVIE_ID("Enter a movie ID:"),
	ACTION_2_RESULT("Here is the casting of %s:"),
	ACTION_3("[3] Display movies released within a given interval"),
	ACTION_3_ERROR_GREATER_START_YEAR("The starting year must be less than the end year."),
	ACTION_3_ERROR_INVALID_YEAR("Invalid year %s, please retry."),
	ACTION_3_PROMPT_END_YEAR("Enter the end year:"),
	ACTION_3_PROMPT_START_YEAR("Enter the starting year:"),
	ACTION_3_RESULT("Here are the %s movies released within %s-%s:"),
	ACTION_4("[4] Display movies that share 2 actors"),
	ACTION_4_ERROR_ACTOR_NOT_FOUND("No actor found with the ID %s."),
	ACTION_4_ERROR_SAME_ACTORS("The actors must be different."),
	ACTION_4_PROMPT_FIRST_ACTOR_ID("Enter the first actor ID:"),
	ACTION_4_PROMPT_SECOND_ACTOR_ID("Enter the second actor ID:"),
	ACTION_4_RESULT("Here are the %s movies having %s and %s in the casting:"),
	ACTION_5("[5] Display actors that played in 2 given movies"),
	ACTION_6("[6] Display movies released within a given interval and that include the given actor in their casting"),
	ACTION_7("[7] Quit"),
	CURSOR("> "),
	DASH("- %s"),
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