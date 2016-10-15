package Warmup.Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Warmup.TimeConversion;

public class TimeConversionTest {

	@Test
	public void test() {
		String time = TimeConversion.convertTime("07:05:45PM");
		assertEquals("19:05:45", time);
	}

}
