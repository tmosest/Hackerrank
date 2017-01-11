package WeekOfCode.Week28;

import java.util.Scanner;

public class LuckyNumberEight {
	
	private static long mod = 1000000007;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int size = in.nextInt();
		String s = in.next();
		
		in.close();
		
		System.out.println(countSubSequnecesDivisibleByEight(s));
	}

	/**
	 * 
	 * @param s
	 * @return
	 */
	private static long countSubSequnecesDivisibleByEight(String s)
	{
		long count = 0;
		
		for (int i = 0; i < s.length(); i++) {
	        for (int j = i+1; j <= s.length(); j++) {
	        	long number = Integer.parseInt(s.substring(i,j));
	        	if(number % 8 == 0) { 
	        		count++;
	        		count %= mod;
	        	}
	        }
	    }
		
		return count;
	}
	
	private static void printAllSubString(String A)
	{
		for (int i = 0; i < A.length(); i++) {
	        for (int j = i+1; j <= A.length(); j++) {
	            System.out.println(A.substring(i,j));
	        }
	    }
	}
	
}
