package com.fox.charcounter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BasicCharCounterTest {

	BasicCharCounter counter = new BasicCharCounter();

	@Test
	@DisplayName("Given several words return unique chars")
	void givenSeveralWords_whenCountChars_thenReturnNumberOfUniqueChars() {
		Map<Character, Integer> expected = new LinkedHashMap<>();
		expected.put('h', 1);
		expected.put('e', 1);
		expected.put('l', 3);
		expected.put('o', 2);
		expected.put(' ', 1);
		expected.put('w', 1);
		expected.put('r', 1);
		expected.put('d', 1);
		expected.put('!', 1);

		Map<Character, Integer> actual = counter.countChars("hello world!");

		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("If null parameter then IllegalArgumentException is  thrown")
	void givenNullParameter_whenCountChars_thenThrowIllegalArgumentException() {
		assertThrows(IllegalArgumentException.class, () -> counter.countChars(null));
	}

	@Test
	@DisplayName(" Given empty string then return empty map")
	void givenEmptyString_whenCountChars_thenReturnEmptyMap() {
		Map<Character, Integer> expected = new LinkedHashMap<>();

		Map<Character, Integer> actual = counter.countChars("");

		assertEquals(expected, actual);
	}

	@Test
	@DisplayName(" Given space then return space")
	void givenSpace_whenCountChars_thenReturnSpace() {
		Map<Character, Integer> expected = new LinkedHashMap<>();
		expected.put(' ', 1);

		Map<Character, Integer> actual = counter.countChars(" ");

		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("Given same char several times then return char and  its occurances number")
	void givenSameCharSeveralTimes_whenCountChars_thenReturnCharAndItsOccurancesNumber() {
		Map<Character, Integer> expected = new LinkedHashMap<>();
		expected.put('a', 5);

		Map<Character, Integer> actual = counter.countChars("aaaaa");

		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("Given same words with different capital and small letters then return they are not same")
	void givenSameWordsWithDifferentCapitalAndSmallLetters_whenCountChars_thenReturnTheyAreNotSame() {
		Map<Character, Integer> expected = counter.countChars("hello");

		Map<Character, Integer> actual = counter.countChars("HeLLo");

		assertNotSame(expected, actual);
	}
}
