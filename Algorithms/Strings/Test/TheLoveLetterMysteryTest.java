package Strings.Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Strings.TheLoveLetterMystery;

public class TheLoveLetterMysteryTest {

	@Test
	public void testDetermineCostToMakePalidrone() {
		String input = "abc";
		int indexToRemove = TheLoveLetterMystery.determineCostToMakePalidrone(input);
		assertEquals(2, indexToRemove);
	}

}
