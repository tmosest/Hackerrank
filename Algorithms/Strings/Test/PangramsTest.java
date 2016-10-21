package Strings.Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Strings.Pangrams;

public class PangramsTest {

	@Test
	public void testIsPangram0() {
		String input0 = "We promptly judged antique ivory buckles for the next prize";
		boolean isPangram = Pangrams.isPangram(input0);
		assertEquals(true, isPangram);
	}
	
	@Test
	public void testIsPangram1() {
		String input0 = "We promptly judged antique ivory buckles for the prize";
		boolean isPangram = Pangrams.isPangram(input0);
		assertEquals(false, isPangram);
	}

}
