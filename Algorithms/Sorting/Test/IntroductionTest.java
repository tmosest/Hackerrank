package Sorting.Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Sorting.Introduction;

public class IntroductionTest {

	@Test
	public void testIndexOfSearchElement() {
		/*
		 	4
			6
			1 4 5 7 9 12
		 */
		int[] array = {
				1, 4, 5, 7, 9, 12	
		};
		int indexFound = Introduction.indexOfSearchElement(array, 4);
		assertEquals(1, indexFound);
	}

}
