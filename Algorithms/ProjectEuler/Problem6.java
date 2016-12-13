package ProjectEuler;

import java.util.Scanner;

/**
 * Project Euler #6: Sum square difference
 * Easy
 */
public class Problem6 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int cases = in.nextInt();
	
		for(int t = 0; t < cases; t++) {
			int number = in.nextInt();
			long sum = sumOfDifferenceSquares(number);
			
			System.out.println(sum);
		}
		
		in.close();
	}
	
	public static long sumOfDifferenceSquares(int number)
	{
		long sum = GaussSum(number);
		sum = sum * sum;
		for(int i = 1; i <= number; i++) {
			sum -= i * i;
		}
		return sum;
	}
	
	public static long GaussSum(int number)
	{
		return ( (number) * (number + 1) ) / 2;
	}
}
