package com.fox.charcounter;

import java.util.HashMap;
import java.util.Map;

public class CachingCharCounterDecorator implements CharCounter {

	private Map<String, Map<Character, Integer>> cache = new HashMap<>();
	private CharCounter counter;

	public CachingCharCounterDecorator(CharCounter counter) {
		this.counter = counter;
	}

	@Override
	public Map<Character, Integer> countChars(String sentence) {
		return cache.computeIfAbsent(sentence, key -> counter.countChars(sentence));
	}
}
