package HackerEarth;

import java.util.Scanner;

public class IntelligentGirl {

	private static boolean debugMode = false;
	private static long[] evenCountForString;
		
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		String s = in.next();
		
		if(debugMode)
			System.out.println(s);
		
		in.close();
		
		generateEvenIndexes(s);
		
		for(long l : evenCountForString)
			System.out.print(l + " ");
	}
	
	private static void generateEvenIndexes(String s)
	{
		if(debugMode)
			System.out.println("Start Generating.");
		
		evenCountForString = new long[s.length()];
		int count = 0;
		for(int i = 0; i < s.length(); i++) {
			int digit = Integer.parseInt(String.valueOf(s.charAt(s.length() - i - 1)));
			
			if(debugMode)
				System.out.println(digit);
			
			if(digit % 2 == 0) count++;
			evenCountForString[s.length() - i - 1] = count;
		}
	}
}
