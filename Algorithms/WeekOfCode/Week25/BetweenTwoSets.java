package WeekOfCode.Week25;

import java.util.Arrays;
import java.util.Scanner;

/**
 *	Algorithms -> Week of Code 25 -> Between Two Sets 
 *	Easy
 *
 * Sample Input:
   2 3
   2 4
   16 32 96
 *
 * Sample Output:
   3
 */
public class BetweenTwoSets {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int m = in.nextInt();
		
		int[] A = new int[n];
		
		int[] B = new int[m];
		
		for(int i = 0; i < n; i++) {
			A[i] = in.nextInt();
		}
		
		for(int i = 0; i < m; i++) {
			B[i] = in.nextInt();
		}
		
		in.close();
		
		Arrays.sort(A);
		Arrays.sort(B);
		
		int gcdB = B[0];
		
		for(int i = 1; i < m; i++) {
			gcdB = GCD(gcdB, B[i]);
		}
		
		//System.out.println("gcd of B: " + gcdB);
		
		int lcmA = A[0];
		
		for(int i = 1; i < n; i++) {
			lcmA = LCM(lcmA, A[i]);
		}
		
		//System.out.println("lcm of A: " + lcmA);
		
		int counter = 0;
		for(int i = lcmA; i <= gcdB; i++) {
			if(isFactor(gcdB, i)) {
				counter++;
				//System.out.println(i);
			}
		}
		
		System.out.println(counter);
	}
	
	// Simple Algorithm to calculate GCD
	public static int GCD(int a, int b) 
	{
		if (b==0) return a;
		return GCD(b,a%b);
	}
	
	// Simple Algorithm to calculate LCM
	public static int LCM(int a, int b) 
	{
		return Math.abs(a * b)/ GCD(a, b);
	}
	
	// Determines if divider is a factor of number
	public static boolean isFactor(int number, int divider)
	{
		return number % divider == 0;
	}
}
