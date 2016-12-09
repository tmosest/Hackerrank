package Greedy;

import java.util.Scanner;

/**
 *	Algorithms ->  Greedy -> Sherlock and The Beast
 *	Easy
 */
public class SherlockAndTheBeast {
	public static boolean debugMode = false;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int numTests = in.nextInt();
		
		for(int t = 0; t < numTests; t++) {
			int numDigits = in.nextInt();
			String result = buildDecentNumber(numDigits);
			System.out.println(result);
		}
		
		in.close();
	}
	
	/**
	 * Returns a decent number which is defined to be:
	 * 1) Its digits can only be 3's and/or 5's. 
	 * 2) The number of 3's it contains is divisible by 5. 
	 * 3) The number of 5's it contains is divisible by 3.
	 * 4) If there are more than one such number, we pick the largest one.
	 * 
	 * @param digits
	 * @return
	 */
	public static String buildDecentNumber(int digits)
	{	
		int best3sCount = 0;
		int best5sCount = 0;
		
		// n complex
		for(int i = 0; i <= digits; i++) {
			int threesCount = i;
			int fivesCount = digits - i;
			
			if(debugMode) {
				System.out.println("3's : " + threesCount);
				System.out.println("5's : " + fivesCount);
				System.out.println("");
			}
			
			if(threesCount % 5 == 0 && fivesCount % 3 == 0 && fivesCount >= best5sCount) {
				best3sCount = threesCount;
				best5sCount = fivesCount;
			}
		}
		
		// if we cant build a string return -1
		if(best3sCount == 0 && best5sCount == 0)
			return "-1";
		
		StringBuilder sb = new StringBuilder(digits);
		
		// n complex
		for(int i = 0; i < best5sCount; i++)
			sb.append("5");
		
		for(int i = 0; i < best3sCount; i++)
			sb.append("3");
		
		String result = sb.toString();
		
		return result;
	}

}
