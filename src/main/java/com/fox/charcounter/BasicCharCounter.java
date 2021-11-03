package com.fox.charcounter;

import java.util.LinkedHashMap;
import java.util.Map;

public class BasicCharCounter implements CharCounter {

	@Override
	public Map<Character, Integer> countChars(String sentence) {
		if (sentence == null) {
			throw new IllegalArgumentException("Input string cannot be  null");
		}

		Map<Character, Integer> uniqueChars = new LinkedHashMap<>();

		for (char symbol : sentence.toCharArray()) {
			if (!uniqueChars.containsKey(symbol)) {
				uniqueChars.put(symbol, 1);
			} else {
				uniqueChars.put(symbol, uniqueChars.get(symbol) + 1);
			}
		}

		return uniqueChars;
	}
}
