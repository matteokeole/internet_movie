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
		System.out.println(ReaderLocale.ACTION_1_PROMPT_MOVIE_ID);
		System.out.print(ReaderLocale.CURSOR);

		final String actorId = App.scanner.nextLine().trim();
		final Actor actor = ActorRepository.find(actorId);

		System.out.println();

		if (actor == null) {
			System.out.println(String.format(ReaderLocale.ACTION_1_NO_RESULT.toString(), actorId));

			return;
		}

		final List<Movie> movies = MovieRepository.findByActor(actorId);

		System.out.println(String.format(ReaderLocale.ACTION_1_RESULT.toString(), actor));
		for (final Movie movie : movies) System.out.println(String.format(ReaderLocale.ACTION_1_RESULT_ITEM.toString(), movie));
	}

	private static void handleAction2() {
		//
	}

	private static void handleAction3() {
		//
	}

	private static void handleAction4() {
		//
	}

	private static void handleAction5() {
		//
	}

	private static void handleAction6() {
		//
	}
}