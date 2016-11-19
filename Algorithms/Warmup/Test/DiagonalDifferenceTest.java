package Warmup.Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Warmup.DiagonalDifference;

public class DiagonalDifferenceTest {

	@Test
	public void testComputeDiagnolDifference() {
		/*
		 * 11 2 4
			4 5 6
			10 8 -12
		 * */
		int a[][] = {
				{11, 2, 4},
				{4, 5, 6},
				{10, 8, -12}
		};
		int diagnolDifference = DiagonalDifference.computeDiagnolDifference(a);
		assertEquals(15, diagnolDifference);
	}

}
