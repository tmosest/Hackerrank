package Implementation.Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Implementation.DivisibleSumPairs;

public class DivisibleSumPairsTest {

	@Test
	public void calculateNumberOfDivisiblePaisTest() {
		int a[] = {
				1, 3, 2, 6, 1, 2
		};
		int k = 3;
		int result = DivisibleSumPairs.calculateNumberOfDivisiblePais(a, k);
		assertEquals(5, result);
	}

}
