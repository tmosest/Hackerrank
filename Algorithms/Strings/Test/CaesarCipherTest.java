package Strings.Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Strings.CaesarCipher;

public class CaesarCipherTest {

	@Test
	public void testEncyrpt0() {
		String input = "middle-Outz";
		int shift =	2;
		String output = CaesarCipher.encyrpt(input, shift);
		assertEquals("okffng-Qwvb", output);
	}

}
