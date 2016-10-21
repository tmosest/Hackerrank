package Strings;

import java.util.Scanner;

/**
 *	Algorithms -> Strings -> Palindrome Index
 *	Easy
 */
public class PalindromeIndex {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int numCases = in.nextInt();
		for(int i = 0; i < numCases; i++) {
			String input = in.next();
			int indexToRemove = determineIndexToRemove(input);
			System.out.println(indexToRemove);
		}
		in.close();
	}

	public static int determineIndexToRemove(String input)
	{
		int indexToRemove = -1;
		String inputReverse = new StringBuffer(input).reverse().toString();
		if(!input.equals(inputReverse)) {
			char[] inputArray = input.toCharArray();
			char[] inputReverseArray = inputReverse.toCharArray();
			for(int i = 0; i < inputArray.length; i++) {
				if(inputArray[i] != inputReverseArray[i]) {
					char tmp = inputReverseArray[i];
					int reversedIndex = inputArray.length - i - 1;
					inputArray[reversedIndex] = '1';
					inputReverseArray[i] = '1';
					input = String.copyValueOf(inputArray).replace("1", "");
					inputReverse = String.copyValueOf(inputReverseArray).replace("1", "");
					//System.out.println(input);
					//System.out.println(inputReverse);
					if(input.equals(inputReverse)) {
						indexToRemove = reversedIndex;
					} else {
						inputArray[reversedIndex] = tmp;
						inputReverseArray[i] = tmp;
						//System.out.println(inputArray);
						//System.out.println(inputReverseArray);
						inputArray[i] = '1';
						inputReverseArray[reversedIndex] = '1';
						//System.out.println(inputArray);
						//System.out.println(inputReverseArray);
						input = String.copyValueOf(inputArray).replace("1", "");
						inputReverse = String.copyValueOf(inputReverseArray).replace("1", "");
						//System.out.println(input);
						//System.out.println(inputReverse);
						if(input.equals(inputReverse)) {
							indexToRemove = i;
						}
					}
					break;
				}
			}
		}
		return indexToRemove;
	}
}
