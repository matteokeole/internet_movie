package com.diginamic;

import java.util.Scanner;

import com.diginamic.locales.ReaderLocale;

public class Reader {
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(final String[] args) {
		System.out.println(ReaderLocale.WELCOME);

		String input;
		int action = 0;

		while (action != 7) {
			printMenu();

			input = scanner.nextLine().trim();

			try {
				action = Integer.parseInt(input);
			} catch (final NumberFormatException exception) {
				action = 0;
			}

			switch (action) {
				case 1:
					//

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
		System.out.println();
		System.out.print(ReaderLocale.CURSOR);
	}
}