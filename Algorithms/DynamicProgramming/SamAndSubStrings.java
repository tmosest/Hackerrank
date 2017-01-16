package DynamicProgramming;

import java.util.Scanner;

/**
 *	Algorithms -> Dynamic Programming -> Sam and sub-strings
 *	Medium
 */
public class SamAndSubStrings {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		String s = in.next();
		
		in.close();
		
		CountSumOfAllSubStrings ccs = new CountSumOfAllSubStrings(s);
		System.out.println(ccs.getSum());
	}
	
	public static class CountSumOfAllSubStrings
	{
		private static long mod = 1000000007;
		private static long sum;
		
		public CountSumOfAllSubStrings(String s)
		{
			for(int i = 0; i < s.length(); i++) {
				for(int j = i + 1; j <= s.length(); j++) {
					long number = Long.parseLong(s.substring(i, j));
					number %= mod;
					sum += number;
					sum %= mod;
				}
			}
		}
		
		public long getSum()
		{ return this.sum; }
		
	}// end CountSumOfAllSubStrings
}
