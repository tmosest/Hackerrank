package Strings.Test;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.Test;

import Strings.RichieRich;

public class RichieRichTest {
	
	BufferedReader in = null;
	BufferedReader out = null;
	
	
	@Test
	public void superPalindromeOptimizer0() {
		/**
		  4 1
		  3943
		 */
		String num = "3943";
		String largePalidrome = RichieRich.superPalindromeOptimizer(num, 1);
		assertEquals("3993", largePalidrome);
	}
	
	@Test
	public void superPalindromeOptimizer1() {
		String num = "092282";
		String largePalidrome = RichieRich.superPalindromeOptimizer(num, 3);
		assertEquals("992299", largePalidrome);
	}
	
	@Test
	public void superPalindromeOptimizer2() {
		String num = "5";
		String largePalidrome = RichieRich.superPalindromeOptimizer(num, 1);
		assertEquals("9", largePalidrome);
	}
	
	@Test
	public void superPalindromeOptimizer3() {
		String num = "932239";
		String largePalidrome = RichieRich.superPalindromeOptimizer(num, 2);
		assertEquals("992299", largePalidrome);
	}
	
	@Test
	public void superPalindromeOptimizer5() {
		/**
		    5 4
		 	11331
		 */
		String num = "11331";
		String largePalidrome = RichieRich.superPalindromeOptimizer(num, 4);
		assertEquals("99399", largePalidrome);
	}
	
	@Test
	public void superPalindromeOptimizer6() {
		/*
		 5 1
		 12321
		 */
		String num = "12321";
		String largePalidrome = RichieRich.superPalindromeOptimizer(num, 1);
		assertEquals("12921", largePalidrome);
	}
	
	@Test
	public void superPalindromeOptimizer10() throws IOException {
		in = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("data/RichieRich/TestCase10Input.txt")));
		out = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("data/RichieRich/TestCase10Output.txt")));
		
		String answer = out.readLine();
		
		System.out.print(answer.length());
		
		String line1 = in.readLine();
		String num = in.readLine();
		String largePalidrome = RichieRich.superPalindromeOptimizer(num, Integer.parseInt(line1.split(" ")[1]));
		
		System.out.println(answer.substring(21702, 21802));
		System.out.println(largePalidrome.substring(21702, 21802));
		
		for(int i = 0; i < num.length(); i++)
		{
			assertEquals("("+i+","+answer.charAt(i)+")","("+i+","+largePalidrome.charAt(i)+")");
		}
		
		assertEquals(answer, largePalidrome);
	}
}
