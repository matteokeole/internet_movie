package com.diginamic;

import java.util.Scanner;

import com.diginamic.services.ParserService;
import com.diginamic.services.ReaderService;

public class App {
	public static final Scanner scanner = new Scanner(System.in);

	public static void main(final String[] args) {
		ParserService.main(args);

		System.out.println();

		ReaderService.main(args);
	}
}