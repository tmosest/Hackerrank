package ProjectEuler;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Project Euler #25: N-digit Fibonacci 
 * Easy
 * http://www.maths.surrey.ac.uk/hosted-sites/R.Knott/Fibonacci/fibFormula.html#section2
 */
public class Problem25 {

	private static boolean debugMode = false;
	
	private static final double sqrt5 = Math.sqrt(5.0);
	private static final double goldenSection = (1 + sqrt5) / 2; 
	private static final double goldenSectionInverse = (1 - sqrt5) / 2; 
	
	private static final int limit = 5000;
	private static int[] fibWithDivisors = new int[limit + 1];
	
	private static double fibonacciNumber(int nth)
	{
		return (Math.pow(goldenSection, nth) - Math.pow(goldenSectionInverse, nth)) / sqrt5;
	}
	
	private static int numberOfDivisorsFib(int nth)
	{
		return (int) Math.ceil(nth * Math.log10(goldenSection) - Math.log10(5)/2);
	}
	
	private static void fillFibDivisors()
	{
		int divisorsCount = 0;
		
		for(int i = 1; i < limit; i++) {
			int test = numberOfDivisorsFib(i);
			if(test > divisorsCount) {
				divisorsCount = test;
				fibWithDivisors[test] = i;
			}
		}
	}
	
	public static void main(String[] args)
	{
		fillFibDivisors();
		
		Scanner in = new Scanner(System.in);
		
		int qs = in.nextInt();
		
		for(int q = 0; q < qs; q++) {
			System.out.println(fibWithDivisors[in.nextInt()]);
		}
		
		in.close();
	}
	
}
