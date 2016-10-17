package Implementation.Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Implementation.JumpingOnTheClouds;

public class JumpingOnTheCloudsTest {

	@Test
	public void testCountJumps0() {
		int clouds[] = {
				0, 0, 1, 0, 0, 1, 0
		};
		int jumps = JumpingOnTheClouds.countJumps(clouds);
		assertEquals(4, jumps);
	}

	@Test
	public void testCountJumps1() {
		int clouds[] = {
				0, 0, 0, 0, 1, 0
		};
		int jumps = JumpingOnTheClouds.countJumps(clouds);
		assertEquals(3, jumps);
	}
}
