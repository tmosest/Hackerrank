package Strings.Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Strings.TwoCharacters;

public class TwoCharactersTest {

	@Test
	public void testCalculateLengthOfAlternating0() {
		String s = "beabeefeab";
		int count = TwoCharacters.calculateLengthOfAlternating(s);
		assertEquals(5, count);
	}
	
	@Test
	public void testCalculateLengthOfAlternating1() {
		String s = "cwomzxmuelmangtosqkgfdqvkzdnxerhravxndvomhbokqmvsfcaddgxgwtpgpqrmeoxvkkjunkbjeyteccpugbkvhljxsshpoymkryydtmfhaogepvbwmypeiqumcibjskmsrpllgbvc";
		int count = TwoCharacters.calculateLengthOfAlternating(s);
		assertEquals(8, count);
	}

}
