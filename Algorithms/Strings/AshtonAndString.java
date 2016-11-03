package Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 *	Algorithms -> Strings -> Ashton and String
 *	Advanced
 */
public class AshtonAndString {

	
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int numTests = in.nextInt();
		
		for(int i = 0; i < numTests; i++) {
			String input = in.next();
			int indexToPrint = in.nextInt();
			char result = determinNthCharInOrderedSubstringConcatenation(input, indexToPrint);
			System.out.println(result);
		}
		
		in.close();
	}
	
	/**
	 * Takes a string a returns the char at index of the concatenated sorted string of all substrings
	 * 
	 * Example:
	 * dbac, 3
	 * 
	 * would make:
	 * aacbbabaccddbdbadbac
	 * 
	 *  so the answer would be 
	 *  c
	 *  
	 * @param input
	 * @param index
	 * @return
	 */
	public static char determinNthCharInOrderedSubstringConcatenation(String input, int index)
	{
		char result = 'a';
		
		//System.out.println("factorial: " + factorial);
		
		ArrayList<String> subStrings = new ArrayList<String>();
		
		for(int i = 0; i < input.length(); i++) {
			for(int j = i + 1; j < input.length() + 1; j++) {
				String subStr = input.substring(i, j);
				//System.out.println("subStr: " + subStr);
				subStrings.add(subStr);
			}
		}
		
		Collections.sort(subStrings);
		
		int k = 1;
		for(String s : subStrings) {
			for(int j = 0; j < s.length(); j++) {
				if(k == index) {
					return s.charAt(j);
				}
				k++;
			}
		}
		
		return result;
	}
	
	
	
}
