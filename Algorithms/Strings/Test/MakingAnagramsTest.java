package Strings.Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Strings.MakingAnagrams;

public class MakingAnagramsTest {

	@Test
	public void testCountLettersToRemove() {
		String s1 = "cde";
		String s2 = "abc";
		int count = MakingAnagrams.countLettersToRemove(s1 , s2);
		assertEquals(4, count);
	}

}
