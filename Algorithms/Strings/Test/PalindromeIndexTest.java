package Strings.Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Strings.PalindromeIndex;

public class PalindromeIndexTest {

	@Test
	public void testDetermineIndexToRemove0() {
		String test = "aaab";
		int index =  PalindromeIndex.determineIndexToRemove(test);
		assertEquals(3, index);
	}
	
	@Test
	public void testDetermineIndexToRemove1() {
		String test = "baa";
		int index =  PalindromeIndex.determineIndexToRemove(test);
		assertEquals(0, index);
	}
	
	@Test
	public void testDetermineIndexToRemove2() {
		String test = "aaa";
		int index =  PalindromeIndex.determineIndexToRemove(test);
		assertEquals(-1, index);
	}

}
