package ProjectEuler;

import java.util.Scanner;

/**
 * Project Euler #10: Summation of primes
 * Medium
 */
public class Project10 {
	
	private static boolean debugMode = false;
	
	private static boolean[] seive;
	private static long primeSum;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int cases = in.nextInt();
		
		for(int c = 0; c < cases; c++) {
			int number = in.nextInt();
			fillSieve(number);
			System.out.println(primeSum);
		}
		
		in.close();
	}
	
	public static void fillSieve(int number) 
	{	
		seive = new boolean[number + 1];
		primeSum = 0;
		
		seive[0] = true;
		seive[1] = true;
		
		for(int i = 2; i <= number; i++) {
			if(!seive[i]) {
				primeSum += i;
				for(int j = 1; j * i <= number; j++) {
					seive[i * j] = true;
				}
			}
		}
	}
}
