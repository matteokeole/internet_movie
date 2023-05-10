package com.diginamic;

import java.util.Scanner;

import com.diginamic.locales.ReaderLocale;
import com.diginamic.services.MovieService;

public class Reader {
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(final String[] args) {
		System.out.println(ReaderLocale.WELCOME);

		String input;
		int action = 0;

		loop: for (;;) {
			printMenu();

			input = scanner.nextLine().trim();

			System.out.println();

			try {
				action = Integer.parseInt(input);
			} catch (final NumberFormatException exception) {
				action = 0;
			}

			switch (action) {
				case 1:
					System.out.println(MovieService.findAll("tt0058796"));

					break;
				case 2:
					//

					break;
				case 3:
					//

					break;
				case 4:
					//

					break;
				case 5:
					//

					break;
				case 6:
					//

					break;
				case 7:
					break loop;
				default:
					System.out.println(String.format(ReaderLocale.ERROR_INPUT_MISMATCH.toString(), input));

					break;
			}
		}

		System.out.println(ReaderLocale.QUIT);

		scanner.close();
	}

	private static void printMenu() {
		System.out.println();
		System.out.println(ReaderLocale.OPTION_1);
		System.out.println(ReaderLocale.OPTION_2);
		System.out.println(ReaderLocale.OPTION_3);
		System.out.println(ReaderLocale.OPTION_4);
		System.out.println(ReaderLocale.OPTION_5);
		System.out.println(ReaderLocale.OPTION_6);
		System.out.println(ReaderLocale.OPTION_7);
		System.out.print(ReaderLocale.CURSOR);
	}
}