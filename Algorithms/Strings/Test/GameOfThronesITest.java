package Strings.Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Strings.GameOfThronesI;

public class GameOfThronesITest {

	@Test
	public void testIsAnagramOfPalindrome0() {
		String word = "aaabbbb";
		boolean isAnagramPalidrome = GameOfThronesI.isAnagramOfPalindrome(word);
		assertEquals(true, isAnagramPalidrome);
	}
	
	
	@Test
	public void testIsAnagramOfPalindrome1() {
		String word = "cdefghmnopqrstuvw";
		boolean isAnagramPalidrome = GameOfThronesI.isAnagramOfPalindrome(word);
		assertEquals(false, isAnagramPalidrome);
	}
	
}
