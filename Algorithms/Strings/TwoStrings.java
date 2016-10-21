package Strings;

import java.util.Scanner;

/**
 *	Algorithms -> Strings -> Two Strings
 *	Easy
 */
public class TwoStrings {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int numCases = in.nextInt();
		for(int i = 0; i < numCases; i++) {
			String pair1 = in.next();
			String pair2 = in.next();
			String result = "NO";
			boolean doStringsHaveCommonLetter = doStringsHaveCommonLetter(pair1, pair2);
			if(doStringsHaveCommonLetter) result = "YES";
			System.out.println(result);
		}
		in.close();
	}

	public static boolean doStringsHaveCommonLetter(String pair1, String pair2) 
	{
		boolean result = false;
		char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		for(char c : alphabet) {
			if(pair1.indexOf(c) != -1 && pair2.indexOf(c) != -1) {
				result = true;
				break;
			}
		}
		return result;
	}

}
