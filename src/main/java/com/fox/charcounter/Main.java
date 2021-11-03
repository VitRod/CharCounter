package com.fox.charcounter;

import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a string : ");
		String inputOfSentence = scanner.nextLine();

		printCharsCalculation(inputOfSentence);
	}

	public static void printCharsCalculation(String sentenceInput) {
		CachingCharCounterDecorator counterDecorator = new CachingCharCounterDecorator(new BasicCharCounter());

		Map<Character, Integer> result = counterDecorator.countChars(sentenceInput);

		for (char symbol : result.keySet()) {
			System.out.println("\"" + symbol + "\"" + " - " + result.get(symbol));
		}
	}
}
