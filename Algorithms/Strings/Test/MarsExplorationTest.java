package Strings.Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Strings.MarsExploration;

public class MarsExplorationTest {

	@Test
	public void testCountNumberOfIncorrectSOS0() {
		String test = "SOSSPSSQSSOR";
		int count = MarsExploration.countNumberOfIncorrectSOS(test);
		assertEquals(3, count);
	}
	
	@Test
	public void testCountNumberOfIncorrectSOS1() {
		String test = "SOSOOSOSOSOSOSSOSOSOSOSOSOS";
		int count = MarsExploration.countNumberOfIncorrectSOS(test);
		assertEquals(12, count);
	}

}
