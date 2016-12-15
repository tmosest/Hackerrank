package ProjectEuler;

import java.util.Scanner;

/**
 * Project Euler #7: 10001st prime
 * Easy
 */
public class Problem7 {
	
	private static boolean debugMode = false;
	
	private static boolean[] seive;
	private static int[] primes;
	
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int cases = in.nextInt();
		
		fillSieve();
		
		for(int c = 0; c < cases; c++) {
			int number = in.nextInt();
			System.out.println(primes[number - 1]);
		}
		
		in.close();
	}
	
	public static void fillSieve() 
	{	
		int limit = 1000000;
		seive = new boolean[limit + 1];
		primes = new int[10003];
		
		seive[0] = true;
		seive[1] = true;
		
		int primeCount = 0;
		
		for(int i = 2; i <= limit; i += 1) {
			if(!seive[i]) {
				if(primeCount < 10001)
					primes[primeCount++] = i;
				if(debugMode) 
					System.out.println("prime " + primeCount + " is: " + i);
				for(int j = 1; j * i <= limit; j++) {
					seive[i * j] = true;
				}
			}
		}
	}
}
