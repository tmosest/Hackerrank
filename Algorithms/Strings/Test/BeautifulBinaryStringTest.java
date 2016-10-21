package Strings.Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Strings.BeautifulBinaryString;

public class BeautifulBinaryStringTest {

	@Test
	public void testCountChangesNeededToMakeBeautiful0() {
		String binary = "0101010";
		int count = BeautifulBinaryString.countChangesNeededToMakeBeautiful(binary);
		assertEquals(2, count);
	}
	
	@Test
	public void testCountChangesNeededToMakeBeautiful1() {
		String binary = "01100";
		int count = BeautifulBinaryString.countChangesNeededToMakeBeautiful(binary);
		assertEquals(0, count);
	}
	
	@Test
	public void testCountChangesNeededToMakeBeautiful2() {
		String binary = "0100101010";
		int count = BeautifulBinaryString.countChangesNeededToMakeBeautiful(binary);
		assertEquals(3, count);
	}

}
