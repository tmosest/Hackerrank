package Warmup.Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Warmup.PlusMinus;

public class PlusMinusTest {

	@Test
	public void testCaclulatePlusMinus() {
		int arr[] = {-4, 3, -9, 0, 4, 1};
		double[] r = PlusMinus.caclulatePlusMinus(arr);
        assertEquals(0.5, r[0], .1);
        assertEquals(0.333333, r[1], .1);
        assertEquals(0.166667, r[2], .1);
	}

}
