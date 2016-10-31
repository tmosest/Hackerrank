package ProjectEuler;

import java.util.Scanner;

/**
 * Project Euler #3: Largest prime factor
 * Easy
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
		if(num == 1) {
			return 1;
		}
		long minPrime = Integer.MAX_VALUE;
		for(int i = 1; i <= (int) Math.sqrt( (double) num ); i++) {
			boolean isPrime = true;
			if(i == 1) {
				isPrime = false;
			} else {
				for(int j = 1; j < i; j++) {
					if(i % j == 0 && j != 1) {
						isPrime = false;
						break;
					}
				}
			}
			//System.out.println(i + " isPrime: " + isPrime);
			if(isPrime && num % i == 0 && i < minPrime) {
				minPrime = i;
				break;
			}
		}
		if(minPrime == Integer.MAX_VALUE) minPrime = 1;
		return num / minPrime;
	}
}
