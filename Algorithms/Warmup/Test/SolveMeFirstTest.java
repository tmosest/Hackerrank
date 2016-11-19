package Warmup.Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Warmup.SolveMeFirst;

public class SolveMeFirstTest {

	@Test
	public void testSolveMeFirstShouldSumTwoIntegers() {
		int sum = SolveMeFirst.solveMeFirst(5, 4);
		assertEquals(9, sum);
	}

}
