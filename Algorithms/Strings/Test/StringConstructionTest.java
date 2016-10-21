package Strings.Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Strings.StringConstruction;

public class StringConstructionTest {

	@Test
	public void testCalculateCostOfConstruction0() {
		String toConstruct = "abcd";
		int costOfConstruction = StringConstruction.calculateCostOfConstruction(toConstruct);
		assertEquals(4, costOfConstruction);
	}
	
	@Test
	public void testCalculateCostOfConstruction1() {
		String toConstruct = "abab";
		int costOfConstruction = StringConstruction.calculateCostOfConstruction(toConstruct);
		assertEquals(2, costOfConstruction);
	}

}
