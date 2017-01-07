package HackerEarth;

import java.util.Scanner;

/**
 * Factorial! This is the Dynamic Programming Edition.
 * Very-Easy
 * @author tmosest
 *
 */
public class FactorialDP {
	
	private static long mod = (long) Math.pow(10, 9) + 7;
	private static int limit = (int) Math.pow(10, 5);
	private static long[] factorials = new long[limit + 1];
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		int qs = in.nextInt();
		
		for(int q = 0; q < qs; q++) 
			System.out.println(factorial(in.nextInt()));
		
		in.close();
	}
	
	private static long factorial(int n)
	{
		if(n < 1)
			return 1;
		else if(factorials[n] != 0)
			return factorials[n];
		else {
			factorials[n] = ((n % mod) * (factorial(n - 1))) % mod;
			return factorials[n];
		}
	}
}
