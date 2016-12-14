package ProjectEuler;

import java.util.Scanner;

/**
 * Project Euler #7: 10001st prime
 * Easy
 */
public class Problem7 {
	
	private static boolean debugMode = false;
	
	private static boolean[] seive;
	private static int primeCount;
	
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int cases = in.nextInt();
		
		for(int c = 0; c < cases; c++) {
			int number = in.nextInt();
			int prime = fillSieve(number);
			System.out.println(prime);
		}
		
		in.close();
	}
	
	public static int fillSieve(int number) 
	{	
		seive = new boolean[number * 1000 + 1];
		primeCount = 0;
		
		seive[0] = true;
		seive[1] = true;
		
		for(int i = 2; i <= number * 1000; i++) {
			if(!seive[i]) {
				primeCount++;
				//System.out.println("prime: " + i);
				if(primeCount == number) {
					return i;
				}
				for(int j = 1; j * i <= number * 1000; j++) {
					seive[i * j] = true;
				}
			}
		}
		return 0;
	}
}
