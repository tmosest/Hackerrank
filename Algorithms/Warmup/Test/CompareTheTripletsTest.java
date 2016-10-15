package Warmup.Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Warmup.CompareTheTriplets;

public class CompareTheTripletsTest {

	@Test
	public void testCompareTriplets() {
		int amy[] = new int[] {
		    5, 6, 7
		};
		int bob[] = new int[] {
		   3, 6, 10  
		};
		int[] result = CompareTheTriplets.compareTriplets(amy, bob);
		assertEquals(1, result[0]);
		assertEquals(1, result[1]);
	}


}
