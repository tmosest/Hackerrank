package Strings.Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Strings.SuperReducedString;

public class SuperReducedStringTest {

	@Test
	public void testReduceString0() {
		String toReduced = "aaabccddd";
		String reduced = SuperReducedString.reduceString(toReduced);
		assertEquals("abd", reduced);
	}
	
	@Test
	public void testReduceString1() {
		String toReduced = "baab";
		String reduced = SuperReducedString.reduceString(toReduced);
		assertEquals("Empty String", reduced);
	}
	
	@Test
	public void testReduceString2() {
		String toReduced = "aa";
		String reduced = SuperReducedString.reduceString(toReduced);
		assertEquals("Empty String", reduced);
	}
	
	@Test
	public void testReduceString3() {
		String toReduced = "zztqooauhujtmxnsbzpykwlvpfyqijvdhuhiroodmuxiobyvwwxupqwydkpeebxmfvxhgicuzdealkgxlfmjiucasokrdznmtlwh";
		String reduced = SuperReducedString.reduceString(toReduced);
		assertEquals("tqauhujtmxnsbzpykwlvpfyqijvdhuhirdmuxiobyvxupqwydkpbxmfvxhgicuzdealkgxlfmjiucasokrdznmtlwh", reduced);
	}
}
