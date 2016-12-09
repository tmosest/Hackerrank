package ProjectEuler;

import java.math.BigInteger;
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
			if(in.hasNextBigInteger()) {
				BigInteger prime = getLargestPrimeFactorOfNum(in.nextBigInteger());
				System.out.println(prime);
			} else {
				long prime = getLargestPrimeFactorOfNum(in.nextLong());
				System.out.println(prime);
			}
		}
		in.close();
	}

	private static BigInteger getLargestPrimeFactorOfNum(BigInteger num) {
		if(num.compareTo(BigInteger.ONE) <= 0) 
			return num;
		BigInteger i = BigInteger.ONE.add(BigInteger.ONE);
		while(i.multiply(i).compareTo(num)  <= 0) {
			while(num.mod(i) == BigInteger.ZERO) {
				num = num.divide(i);
			}
			i = i.add(BigInteger.ONE);
		}
		return num;
	}

	public static long getLargestPrimeFactorOfNum(long num)
	{
		if(num <= 1) {
			return num;
		}
		long i = 2;
		while(i * i  <= num) {
			while(num % i == 0) {
				num /= i;
			}
			i += 1;
		}
		return num;
	}
}
