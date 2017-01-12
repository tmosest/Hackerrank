package HackerEarth;

import java.util.Scanner;

/**
 * Square Transaction
 * Algorithms  Searching  Linear Search
 * Easy
 * @author tmosest
 *
 */
public class SquareTransaction {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int[] a = new int[n];
		
		for(int i = 0; i < n; i++)
			a[i] = in.nextInt();
		
		int qs = in.nextInt();
		
		for(int q = 0; q < qs; q++)
			System.out.println(determineIndexTransactionMet(a, in.nextLong()));
		
		in.close();
	}
	

	public static int determineIndexTransactionMet(int[] a, long target)
	{
		long sum = 0;
		
		for(int i = 0; i < a.length; i++) {
			sum += a[i];
			
			if(sum >= target) 
				return i + 1;
		}
		
		return -1;
	}
}
