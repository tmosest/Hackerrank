package ProjectEuler;

import java.util.Scanner;

/**
 * Project Euler #14: Longest Collatz sequence  
 * Easy
 */
public class Problem14 {
	
	private static boolean debugMode = false;
	
	private static int max = 5000001;
	private static int[] maxCollatzLengths = new int[max];
	
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
	
	public static int longestCollazChain(int number)
	{
		return maxCollatzLengths[number];
	}
	
	public static void generateCollaztLengths()
	{
		int longest = 0;
		int longestVal = Integer.MIN_VALUE;
		
		for(int i = 1; i < max; i++) {
			int length = lengthOfCollatzChain(i);
			if(length >= longestVal) {
				longestVal = length;
				longest = i;
			}
			maxCollatzLengths[i] = longest;
		}
	}
	
	public static int lengthOfCollatzChain(int number)
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
