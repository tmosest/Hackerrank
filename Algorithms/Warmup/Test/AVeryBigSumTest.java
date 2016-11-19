package Warmup.Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Warmup.AVeryBigSum;

public class AVeryBigSumTest {

	@Test
	public void testSumBigArray() {
		int[] arry = {1000000001, 1000000002, 1000000003, 1000000004, 1000000005};
		long total = AVeryBigSum.sumArray(arry);
		String result = "5000000015";
		assertEquals(Long.parseLong(result), total);
	}

}
