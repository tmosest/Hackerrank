package Strings.Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Strings.AlternatingCharacters;

public class AlternatingCharactersTest {

	@Test
	public void testCalculateNumDeletions0() {
		String test = "ABABBABAAB";
		int numDeletions = AlternatingCharacters.calculateNumDeletions(test);
		assertEquals(2, numDeletions);
	}
	
	@Test
	public void testCalculateNumDeletions1() {
		String test = "BABAABBAAB";
		int numDeletions = AlternatingCharacters.calculateNumDeletions(test);
		assertEquals(3, numDeletions);
	}
	
	@Test
	public void testCalculateNumDeletions2() {
		String test = "BABAAABBBB";
		int numDeletions = AlternatingCharacters.calculateNumDeletions(test);
		assertEquals(5, numDeletions);
	}

}
