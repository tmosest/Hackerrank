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
		char[] inputArray = input.toCharArray();
		//Arrays.sort(inputArray);
		char toLook = inputArray[0];
		int pairs = 1;
		int  k = 1;
		boolean foundPairs = true;
		while(foundPairs) {
			boolean pairsFound = false;
			for(int i = 1; i < input.length(); i++) {
				if(inputArray[i] == toLook) {
					pairs++;
					if(pairs % 2 == 0) {
						int toTestStart = chars.indexOf(inputArray[i]);
						chars.remove(toTestStart);
						toTestStart = chars.indexOf(inputArray[i]);
						chars.remove(toTestStart);
						pairsFound = true;
					}
				} else {
					pairs = 1;
					toLook = inputArray[i];
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
