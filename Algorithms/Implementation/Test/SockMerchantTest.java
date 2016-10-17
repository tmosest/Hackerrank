package Implementation.Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Implementation.SockMerchant;

public class SockMerchantTest {

	@Test
	public void testCountSockPairs() {
		int[] c = {
				10, 20, 20, 10, 10, 30, 50, 10, 20
		};
		int pairs = SockMerchant.countSockPairs(c);
		assertEquals(3, pairs);
	}

}
