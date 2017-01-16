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
			long res = 0;
			long f = 1;
			for(int i = s.length() - 1; i >= 0; i--) {
			    res = (res + (s.charAt(i) - '0') * f * (i+1)) % mod;
			    f = (f * 10 + 1) % mod;
			}
			sum = res;
		}
		
		public long getSum()
		{ return this.sum; }
		
	}// end CountSumOfAllSubStrings
}
