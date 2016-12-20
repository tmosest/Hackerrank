package ProjectEuler;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Project Euler #15: Lattice paths  
 * Easy
 */
public class Problem15 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int cases = in.nextInt();
		
		for(int c = 0; c < cases; c++) {
			int rows = in.nextInt();
			int cols = in.nextInt();
			
			System.out.println(countRoutes(rows, cols));
		}
		
		in.close();
	}
	
	/**
	 * Using a similar method to the one below.
	 * Except where m != n;
	 * @param m
	 * @param n
	 * @return
	 */
	public static int countRoutes(int n, int m)
	{
		int routes = 1;
		
		for(int i = 1; i <= m; i++)
			routes *= ( ( (double) (n + i) / i ) % 1000000007 );
		
		return (int) routes % 1000000007;
	}
	
	/**
	 * Counts the number of routes using 2n choose n.
	 * which is the product from i = 1 to n of (n + i) / n
	 * @param n
	 * @return
	 */
	public static int countRoutes(int n)
	{
		int routes = 1;
		
		for(int i = 1; i <= n; i++)
			routes *= ((n + i) / i);
		
		return routes;
	}
	
	/**
	 * n! / k! * (n - k)!
	 * This approach takes too long and isn't the right way to think about it.
	 */
	public static long choose(int n, int k)
	{
		if(k == 0) return 1;
	    return (n * choose(n - 1, k - 1)) / k;

	}
}
