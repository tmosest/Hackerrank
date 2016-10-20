package Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *	Algorithms -> Strings -> Super Reduced String
 *	Easy
 */
public class SuperReducedString {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String stringToReduce = in.next();
		String result = reduceString(stringToReduce);
		System.out.println(result);
		in.close();
	}
	
	public static String reduceString(String input)
	{
		String result = "Empty String";
		ArrayList<Character> chars = new ArrayList<Character>();
		for(char c : input.toCharArray()) {
		  chars.add(c);
		}
		boolean foundPairs = true;
		while(foundPairs) {
			int pairs = 1;
			boolean pairsFound = false;
			if(chars.size() > 0) {
				char toLook = chars.get(0);
				for(int i = 1; i < chars.size(); i++) {
					char test = chars.get(i);
					if(test == toLook) {
						pairs++;
						if(pairs % 2 == 0) {
							chars.remove(i - 1);
							chars.remove(i - 1);
							pairsFound = true;
							pairs = 1;
							break;
						}
					} else {
						pairs = 1;
						toLook = test;
					}
				}
			}
			foundPairs = pairsFound;
		}
		if(chars.size() > 0) {
			char[] rArray = new char[chars.size()];
			for(int i = 0; i < chars.size(); i++) {
				rArray[i] = chars.get(i);
			} 
			result = String.copyValueOf(rArray);
		}
		return result;
	}
}
