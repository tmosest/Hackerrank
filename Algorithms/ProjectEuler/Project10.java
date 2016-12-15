package ProjectEuler;

import java.util.Scanner;

/**
 * Project Euler #10: Summation of primes
 * Medium
 */
public class Project10 {
	
	private static boolean debugMode = false;
	
	private static boolean[] seive;
	private static long[] seiveSum;
	private static long primeSum;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int cases = in.nextInt();
		
		fillSieve();
		
		for(int c = 0; c < cases; c++) {
			int number = in.nextInt();
			long sum = seiveSum[number];
			System.out.println(sum);
		}
		
		in.close();
	}
	
	public static void fillSieve() 
	{	
		seive = new boolean[10001];
		seiveSum = new long[10001];
		primeSum = 0;
		
		seive[0] = true;
		seive[1] = true;
		
		for(int i = 2; i <= 10000; i += 1) {
			if(!seive[i]) {
				primeSum += i;
				for(int j = 1; j * i <= 10000; j++) {
					seive[i * j] = true;
				}
			}
			seiveSum[i] = primeSum;
		}
	}
}
