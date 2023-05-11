package com.diginamic.services;

import java.util.List;

import com.diginamic.App;
import com.diginamic.locales.ReaderLocale;
import com.diginamic.models.Actor;
import com.diginamic.models.Movie;
import com.diginamic.repository.ActorRepository;
import com.diginamic.repository.MovieRepository;

public class ReaderService {
	public static void main(final String[] args) {
		System.out.println(ReaderLocale.WELCOME);

		String input;
		int action = 0;

		loop: for (;;) {
			printMenu();

			input = App.scanner.nextLine().trim();

			System.out.println();

			try {
				action = Integer.parseInt(input);
			} catch (final NumberFormatException exception) {
				action = 0;
			}

			switch (action) {
				case 1:
					handleAction1();

					break;
				case 2:
					handleAction2();

					break;
				case 3:
					handleAction3();

					break;
				case 4:
					handleAction4();

					break;
				case 5:
					handleAction5();

					break;
				case 6:
					handleAction6();

					break;
				case 7:
					break loop;
				default:
					System.out.println(String.format(ReaderLocale.ERROR_INPUT_MISMATCH.toString(), input));

					break;
			}
		}

		System.out.println(ReaderLocale.QUIT);

		App.scanner.close();
	}

	private static void printMenu() {
		System.out.println();
		System.out.println(ReaderLocale.ACTION_1);
		System.out.println(ReaderLocale.ACTION_2);
		System.out.println(ReaderLocale.ACTION_3);
		System.out.println(ReaderLocale.ACTION_4);
		System.out.println(ReaderLocale.ACTION_5);
		System.out.println(ReaderLocale.ACTION_6);
		System.out.println(ReaderLocale.ACTION_7);
		System.out.print(ReaderLocale.CURSOR);
	}

	private static void handleAction1() {
		System.out.println(ReaderLocale.ACTION_1_PROMPT_ACTOR_ID);
		System.out.print(ReaderLocale.CURSOR);

		final String actorId = App.scanner.nextLine().trim();
		final Actor actor = ActorRepository.find(actorId);

		System.out.println();

		if (actor == null) {
			System.out.println(String.format(ReaderLocale.ACTION_1_ERROR_NO_RESULT.toString(), actorId));

			return;
		}

		final List<Movie> movies = MovieRepository.findByActor(actor);

		System.out.println(String.format(ReaderLocale.ACTION_1_RESULT.toString(), actor, movies.size()));
		for (final Movie movie : movies) System.out.println(String.format(ReaderLocale.DASH.toString(), movie));
	}

	private static void handleAction2() {
		System.out.println(ReaderLocale.ACTION_2_PROMPT_MOVIE_ID);
		System.out.print(ReaderLocale.CURSOR);

		final String movieId = App.scanner.nextLine().trim();
		final Movie movie = MovieRepository.find(movieId);

		System.out.println();

		if (movie == null) {
			System.out.println(String.format(ReaderLocale.ACTION_2_ERROR_NO_RESULT.toString(), movieId));

			return;
		}

		final List<Actor> actors = ActorRepository.findByMovie(movie);

		System.out.println(String.format(ReaderLocale.ACTION_2_RESULT.toString(), movie));
		for (final Actor actor : actors) System.out.println(String.format(ReaderLocale.DASH.toString(), actor));
	}

	private static void handleAction3() {
		final int startYear, endYear;
		String prompt;

		System.out.println(ReaderLocale.ACTION_3_PROMPT_START_YEAR);
		System.out.print(ReaderLocale.CURSOR);

		prompt = App.scanner.nextLine().trim();

		try {
			startYear = Integer.parseInt(prompt);

			System.out.println();

			if (startYear < 0) throw new NumberFormatException();
		} catch (final NumberFormatException exception) {
			System.out.println(String.format(ReaderLocale.ACTION_3_ERROR_INVALID_YEAR.toString(), prompt));

			return;
		}

		System.out.println(ReaderLocale.ACTION_3_PROMPT_END_YEAR);
		System.out.print(ReaderLocale.CURSOR);

		prompt = App.scanner.nextLine().trim();

		try {
			endYear = Integer.parseInt(prompt);

			System.out.println();

			if (endYear < 0) throw new NumberFormatException();
		} catch (final NumberFormatException exception) {
			System.out.println(String.format(ReaderLocale.ACTION_3_ERROR_INVALID_YEAR.toString(), prompt));

			return;
		}

		if (startYear >= endYear) {
			System.out.println(ReaderLocale.ACTION_3_ERROR_GREATER_START_YEAR);

			return;
		}

		final List<Movie> movies = MovieRepository.findBetween(startYear, endYear);

		System.out.println(String.format(ReaderLocale.ACTION_3_RESULT.toString(), movies.size(), startYear, endYear));
		for (final Movie movie : movies) System.out.println(String.format(ReaderLocale.DASH.toString(), movie));
	}

	private static void handleAction4() {
		System.out.println(ReaderLocale.ACTION_4_PROMPT_FIRST_ACTOR_ID);
		System.out.print(ReaderLocale.CURSOR);

		final String firstActorId = App.scanner.nextLine().trim();
		final Actor firstActor = ActorRepository.find(firstActorId);

		System.out.println();

		if (firstActor == null) {
			System.out.println(String.format(ReaderLocale.ACTION_4_ERROR_ACTOR_NOT_FOUND.toString(), firstActorId));

			return;
		}

		System.out.println(ReaderLocale.ACTION_4_PROMPT_SECOND_ACTOR_ID);
		System.out.print(ReaderLocale.CURSOR);

		final String secondActorId = App.scanner.nextLine().trim();
		final Actor secondActor = ActorRepository.find(secondActorId);

		System.out.println();

		if (secondActor == null) {
			System.out.println(String.format(ReaderLocale.ACTION_4_ERROR_ACTOR_NOT_FOUND.toString(), secondActorId));

			return;
		}

		if (firstActor.getId() == secondActor.getId()) {
			System.out.println(ReaderLocale.ACTION_4_ERROR_SAME_ACTORS);

			return;
		}

		final List<Movie> movies = MovieRepository.findByTwoActors(firstActor, secondActor);

		System.out.println(String.format(ReaderLocale.ACTION_4_RESULT.toString(), movies.size(), firstActor, secondActor));
		for (final Movie movie : movies) System.out.println(String.format(ReaderLocale.DASH.toString(), movie));
	}

	private static void handleAction5() {
		//
	}

	private static void handleAction6() {
		//
	}
}