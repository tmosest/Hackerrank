package Strings.Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Strings.TwoStrings;

public class TwoStringsTest {

	@Test
	public void testDoStringsHaveCommonLetter() {
		String pair1 = "hello";
		String pair2 = "world";
		boolean doStringsHaveCommonLetter = TwoStrings.doStringsHaveCommonLetter(pair1, pair2);
		assertEquals(true, doStringsHaveCommonLetter);
	}

}
