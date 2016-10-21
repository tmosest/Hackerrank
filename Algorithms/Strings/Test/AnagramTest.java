package Strings.Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Strings.Anagram;

public class AnagramTest {

	@Test
	public void testCountLettersToChangeToMakeAnagram0() {
		String input = "hhpddlnnsjfoyxpciioigvjqzfbpllssuj";
		int indexToRemove = Anagram.countLettersToChangeToMakeAnagram(input);
		assertEquals(10, indexToRemove);
	}
	
	@Test
	public void testCountLettersToChangeToMakeAnagram1() {
		String input = "gqdvlchavotcykafyjzbbgmnlajiqlnwctrnvznspiwquxxsiwuldizqkkaawpyyisnftdzklwagv";
		int indexToRemove = Anagram.countLettersToChangeToMakeAnagram(input);
		assertEquals(-1, indexToRemove);
	}

}
