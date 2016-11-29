package WeekOfCode.Week26;

import java.util.Scanner;

/**
 *	Algorithms -> Week of Code 26 -> Best Divisor
 *	Easy
 */
public class BestDivisor {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int number = in.nextInt();
		in.close();
		int best = determineBestDivisor(number);
		System.out.println(best);
	}
	
	public static int determineBestDivisor(int number)
	{
		long maxSum = 0;
		int bestDivisor = Integer.MAX_VALUE;
		
		for(int i = 1; i <= number; i++) {
			if(isADivisor(number, i)) {
				long sum = sumDigits(i);
				if(sum > maxSum) {
					maxSum = sum;
					bestDivisor = i;
				} else if(sum == maxSum) {
					if(i < bestDivisor) {
						maxSum = sum;
						bestDivisor = i;
					}
				}
			}
		}
		
		return bestDivisor;
	}
	
	public static boolean isADivisor(int number, int divisor)
	{
		return number % divisor == 0;
	}
	
	public static long sumDigits(int number)
	{
		 long sum;
		 for(sum = 0; number > 0; number = number / 10) {
			 sum = sum + ( number % 10);
		 }
		 return sum;
	}
}
