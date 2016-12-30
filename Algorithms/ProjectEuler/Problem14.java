package ProjectEuler;

import java.util.Scanner;

/**
 * Project Euler #14: Longest Collatz sequence  
 * Easy
 */
public class Problem14 {
	
	private static boolean debugMode = false;
	
	private static int max = 5000001;
	private static long[] maxCollatzLengths = new long[max];
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		generateCollaztLengths();
		
		int cases = in.nextInt();
		
		for(int c = 0; c < cases; c++) {
			int num = in.nextInt();
			System.out.println(longestCollazChain(num));
		}			
		
		in.close();
	}
	
	public static long longestCollazChain(int number)
	{
		return maxCollatzLengths[number];
	}
	
	public static void generateCollaztLengths()
	{
		long longest = 0;
		long longestVal = Integer.MIN_VALUE;
		
		for(int i = 1; i < max; i++) {
			long length = lengthOfCollatzChain(i);
			if(length >= longestVal) {
				longestVal = length;
				longest = i;
			}
			maxCollatzLengths[i] = longest;
		}
	}
	
	public static long lengthOfCollatzChain(long number)
	{
		int length = 0;
		while(number > 1) {
			if(debugMode)
				System.out.print(number + " -> ");
			if(number % 2 == 0) {
				number /= 2;
			} else {
				number = 3 * number + 1;
			}
			length++;
		}
		if(debugMode)
			System.out.println("");
		return length;
	}
}
