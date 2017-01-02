package ProjectEuler;

import java.util.Scanner;
/**
 * Project Euler #15: Lattice paths  
 * Easy
 */
public class Problem15 {

	private static int[][] pascalTriangle;
	private static int n = 1000;
	
	public static void main(String[] args) {
		generatePascalTriangle();
		
		Scanner in = new Scanner(System.in);
		
		int cases = in.nextInt();
		
		for(int c = 0; c < cases; c++) {
			int rows = in.nextInt();
			int cols = in.nextInt();
			System.out.println(pascalTriangle[rows + cols][cols] % 1000000007);
		}
		
		in.close();
	}
	
	private static void generatePascalTriangle()
	{
		pascalTriangle = new int[n][n];
		// Iterate through every line and print integer(s) in it
		for (int line = 0; line < n; line++) {
			// Every line has number of integers equal to line number
		    for (int i = 0; i <= line; i++) {
		      // First and last values in every row are 1
		      if (line == i || i == 0)
		    	  pascalTriangle[line][i] = 1;
		      else // Other values are sum of values just above and left of above
		    	  pascalTriangle[line][i] = pascalTriangle[line-1][i-1] % 1000000007 + pascalTriangle[line-1][i] % 1000000007;
		    }
		  }
	}
}
