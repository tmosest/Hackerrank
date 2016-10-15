package Implementation.Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Implementation.Kangaroo;

public class KangarooTest {

	@Test
	public void willKagarooCatchUpTest() {
		double[] test = {
				0, 2, 5, 3
		};
		String r = Kangaroo.willKagarooCatchUp(test[0], test[1], test[2], test[3]);
		assertEquals("NO", r);
	}

}
