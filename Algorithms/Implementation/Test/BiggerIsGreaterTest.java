package Implementation.Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Implementation.BiggerIsGreater;

public class BiggerIsGreaterTest {

	@Test
	public void testLargestWord0() {
		String word = "ab";
		String result = BiggerIsGreater.largestWord(word);
		assertEquals("ba", result);
	}
	
	@Test
	public void testLargestWord1() {
		String word = "bb";
		String result = BiggerIsGreater.largestWord(word);
		assertEquals("no answer", result);
	}
	
	@Test
	public void testLargestWord2() {
		String word = "hefg";
		String result = BiggerIsGreater.largestWord(word);
		assertEquals("hegf", result);
	}
	
	@Test
	public void testLargestWord3() {
		String word = "dhck";
		String result = BiggerIsGreater.largestWord(word);
		assertEquals("dhkc", result);
	}

	@Test
	public void testLargestWord4() {
		String word = "dkhc";
		String result = BiggerIsGreater.largestWord(word);
		assertEquals("hcdk", result);
	}

}
