package com.fox.charcounter;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CachingCharCounterDecoratorTest {

	@Mock
	CharCounter charCounter;
	@InjectMocks
	CachingCharCounterDecorator cachingCharCounter;

	@Test
	@DisplayName("Given the same  strings  and  return  cached result")
	void givenSameStrings_whenPrintUniqueChars_thenReturnCachedResult() {
		cachingCharCounter.countChars("hello world!");
		verify(charCounter).countChars("hello world!");

		cachingCharCounter.countChars("hello world!");
		verify(charCounter, times(1)).countChars("hello world!");
	}
}
