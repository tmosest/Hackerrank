package ProjectEuler;

import java.util.Scanner;

/**
 * Project Euler #3: Largest prime factor
 * Easy
 * Something is wrong wiht my code tried it in C and still misses test case 1
 */
public class Problem3 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for(int i = 0; i < testCases; i++) {
			long prime = getLargestPrimeFactorOfNum(in.nextLong());
			System.out.println(prime);
		}
		in.close();
	}

	public static long getLargestPrimeFactorOfNum(long num)
	{
		long maxi = -1;
		long temp = num;
		for(long j = 2; j <= Math.sqrt(temp) + 1; j++) {
			while(num % j == 0) {
				if(j > maxi) maxi = j;
				num /= j;
			}
		}
		if(num > 1 && num > maxi) maxi = num;
		return maxi;
	}
}
