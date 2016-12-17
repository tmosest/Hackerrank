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
			
			System.out.println(choose(rows + cols, 2));
		}
		
		in.close();
	}
	
	/*
	 * n! / k! * (n - k)!
	 */
	public static long choose(int n, int k)
	{
		if(k == 0) return 1;
	    return (n * choose(n - 1, k - 1)) / k;

	}
}
