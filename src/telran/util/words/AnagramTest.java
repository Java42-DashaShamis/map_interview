package telran.util.words;

import static org.junit.jupiter.api.Assertions.*;
import static telran.util.words.Anagram.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AnagramTests {
String word = "Hello";
	

	@Test
	void testTrue() {
		assertTrue(isAnagram(word, "hello"));
		assertTrue(isAnagram(word, "olleh"));
		assertTrue(isAnagram(word, "helol"));
		assertTrue(isAnagram(word, "lelho"));
		assertTrue(isAnagram(word, "ellho"));
	
	}
	@Test
	void testFalse() {
		assertFalse(isAnagram(word, "helll"));
		assertFalse(isAnagram(word, "hell"));
		assertFalse(isAnagram(word, "heloo"));
		assertFalse(isAnagram(word, "hella"));
		assertFalse(isAnagram(word, "oleho"));
		
	}

}