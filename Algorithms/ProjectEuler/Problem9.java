package ProjectEuler;

import java.util.Scanner;

/**
 * Project Euler #9: Special Pythagorean triplet 
 * Medium
 */
public class Problem9 {

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		int cases = in.nextInt();
		
		for(int c = 0; c < cases; c++) {
			
			int number = in.nextInt();
			printPythagoreanSumProduct(number);
		}
		
		in.close();
	}
	
	public static void printPythagoreanSumProduct(int sum)
	{
		if(sum % 2 == 1) {
			System.out.println(-1);
			return;
		}
		
		int maxProduct = -1;
		int a;
	    for (a = 1; a <= sum/3; a++) {
	        int b;
	        for (b = a + 1; b <= sum/2; b++) {
	            int c = sum - a - b;
	            if ( a*a + b*b == c*c ) {
	            	int product = a * b * c;
	            	maxProduct = Math.max(product, maxProduct);
	            }
	        }
	    }
	   	System.out.println(maxProduct);
	}
	
	public static int gcd(int a, int b)
	{
		if(b == 0) return a;
		return gcd(b, a % b);
	}
}