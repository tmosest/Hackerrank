package Strings.Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Strings.FunnyString;

public class FunnyStringTest {

	@Test
	public void testTestIfFunny0() {
		String toTest = "acxz";
		boolean isFunny = FunnyString.testIfFunny(toTest);
		assertEquals(true, isFunny);
	}
	
	@Test
	public void testTestIfFunny1() {
		String toTest = "bcxz";
		boolean isFunny = FunnyString.testIfFunny(toTest);
		assertEquals(false, isFunny);
	}

}
