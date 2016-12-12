package ProjectEuler;

import java.util.Scanner;

/**
 * Project Euler #5: Smallest multiple
 * Medium
 */
public class Problem5 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int cases = in.nextInt();
		
		for(int c = 0; c < cases; c++) {
			
			int number = in.nextInt();
			int smallest = calculateSmallestMultiple(number);
			
			System.out.println(smallest);
		}
		
		in.close();
	}
	
	public static int calculateSmallestMultiple(int number)
	{
		int smallest = 1;
		for(int i = 2; i <= number; i++) {
			smallest = lcm(smallest, i);
		}
		return smallest;
	}
	
	public static int lcm(int a, int b)
	{
		return (a * b) / gcd(a, b);
	}
	
	public static int gcd(int a, int b)
	{
		if(b == 0) return a;
		return gcd(b, a % b);
	}
}
