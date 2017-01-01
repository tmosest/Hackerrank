package ProjectEuler;

import java.util.Scanner;

/**
 * Project Euler #12: Highly divisible triangular number 
 * Easy
 */
public class Problem12 {
	private static boolean debugMode = false;
	
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
				
		int cases = in.nextInt();
		
		for(int c = 0; c < cases; c++) {
			int divisorsToCheckFor = in.nextInt();
			int n = first_triangle_with_more_than_n_divisors(divisorsToCheckFor);
			System.out.println(triangleNumber(n));
		}
		
		in.close();
	}
	
	// triangle(n) = (n + 1) * n / 2
	// only one of them has a factor of two, and they have no prime factors in common
	// we can cache one of the divisor counts while iterating over triangle numbers
	private static int first_triangle_with_more_than_n_divisors(int n)
	{
	    int i = 1;
	    for (int f1 = unique_divisors(i), f2 = unique_divisors(i + 1); f1 * f2 <= n; ++i)   {
	        f1 = f2;                        // re-use result from previous iteration
	        f2 = unique_divisors(i + 2);    // only one new computation
	    }
	    return i;
	}

	
	private static int countDivisors(int num)
	{
		int divisors = 1;  // 1 has one divisor
	    {
	    	int f = 2;
	    	int count = 0;
	        while (num % f == 0) {
	            ++count;
	            num /= f;     // divide by factor of 2
	        }
	        divisors *= (count + 1);
	    }

	    // <= n guarantees that a prime has 2 divisors
	    for (int f = 3; f <= num; f += 2) {
	    	int count = 0;
	        while (num % f == 0) {
	            ++count;
	            num /= f;     // divide by odd factor
	        }
	        divisors *= (count + 1);
	    }
	    return divisors;
	}
	
	private static int unique_divisors(int n)
	{
	    if (n % 2 == 0)
	        n /= 2;
	    return countDivisors(n);
	}
	
	/**
	 * Generate nth triangle number using Gauss sum
	 * @param nth
	 * @return
	 */
	private static int triangleNumber(int nth)
	{
		return ((nth) * (nth + 1)) / 2;
	}
}
