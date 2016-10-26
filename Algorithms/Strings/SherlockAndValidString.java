package Strings;

import java.util.HashMap;
import java.util.Scanner;

/**
 *	Algorithms -> Strings -> Sherlock and Valid String
 *	Hard
 */
public class SherlockAndValidString {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		in.close();
		boolean isValidString = testIfValidString(input);
		String result = "NO";
		if(isValidString) 
			result = "YES";
		System.out.println(result);
	}

	public static boolean testIfValidString(String input) {
		boolean isValid = false;
		
		HashMap<Character, Integer> letterCounts = new HashMap<Character, Integer>();
		
		int max = 0, count = 0;
		int mostCommon = 0;
		
		for(char c : input.toCharArray()) {
			int letterCount = (letterCounts.get(c) == null) ? 
					0 : letterCounts.get(c);
			letterCounts.put(c, ++letterCount);
		}
		
		//System.out.println(letterCounts);
		
		HashMap<Integer, Integer> countOfCount = new HashMap<Integer, Integer>();
		
		for(int i : letterCounts.values()) {
			int letterCount = (countOfCount.get(i) == null) ? 
					0 : countOfCount.get(i);
			countOfCount.put(i, ++letterCount);
			if(letterCount > max) {
				max = letterCount;
				mostCommon = i;
			}
		}
		
		//System.out.println("Most Common: " + mostCommon);
		
		//System.out.println(countOfCount);
		
		for(int i : letterCounts.values()) {
			if(i != mostCommon) count++;
		}
		
		isValid = (count < 2);
		
		return isValid;
	}

}
