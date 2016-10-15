package Warmup.Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Warmup.SimpleArraySum;

public class SimpleArraySumTest {

	@Test
	public void shouldSumIntArray() {
		int[] arry = {1, 2, 3, 4, 10, 11};
		int sum = SimpleArraySum.sumArray(arry);
		assertEquals(31, sum);
	}

}
