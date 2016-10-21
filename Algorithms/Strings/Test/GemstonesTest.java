package Strings.Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Strings.Gemstones;

public class GemstonesTest {

	@Test
	public void testCalculateTheNumberOFGemElements0() {
		String[] gems = {
				"abcdde",
				"baccd",
				"eeabg"
		};
		int numOFGemElements  = Gemstones.calculateTheNumberOFGemElements(gems);
		assertEquals(2, numOFGemElements);
	}

}
