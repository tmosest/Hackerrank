package Implementation.Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Implementation.RepeatedString;

public class RepeatedStringTest {

	@Test
	public void testCountAsInInfiniteString() {
		long n0 = 10;
		String s0 = "aba";
		long result0 = RepeatedString.countAsInInfiniteString(s0, n0);
		assertEquals(7, result0);
		
		//This test case is failing!
		long n1 = Long.parseLong("1000000000000");
		String s1 = "aba";
		long result1 = RepeatedString.countAsInInfiniteString(s1, n1);
		assertEquals(n1, result1);
	}

}
