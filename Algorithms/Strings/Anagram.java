package Strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 *	Algorithms -> Strings -> Anagram
 *	Easy
 */
public class Anagram {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int numCases = in.nextInt();
		for(int i = 0; i < numCases; i++) {
			String input = in.next();
			int indexToRemove = countLettersToChangeToMakeAnagram(input);
			System.out.println(indexToRemove);
		}
		in.close();
	}
	
	public static int countLettersToChangeToMakeAnagram(String input) 
	{
		int count = -1;
		if(input.length() % 2 == 0) {
			String inputReverse = new StringBuffer(input).reverse().toString();
			HashMap<Character, Integer> input1Hmap = new HashMap<Character, Integer>();
			HashMap<Character, Integer> input2Hmap = new HashMap<Character, Integer>();
			char[] input1Array = input.substring(0, input.length()/2).toCharArray();
			char[] input2Array = inputReverse.substring(0, input.length()/2).toCharArray();
			Arrays.sort(input1Array);
			Arrays.sort(input2Array);
			count = 0;
			if(!input1Array.equals(input2Array)) {
				for(int i = 0; i < input1Array.length; i++) {
					int count1 = input1Hmap.get(input1Array[i]) != null ? input1Hmap.get(input1Array[i]) : 0;
					int count2 = input2Hmap.get(input2Array[i]) != null ? input2Hmap.get(input2Array[i]) : 0;
					input1Hmap.put(input1Array[i], ++count1);
					input2Hmap.put(input2Array[i], ++count2);
				}
			}
			char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
			for(char c : alphabet) {
				int count1 = input1Hmap.get(c) != null ? input1Hmap.get(c) : 0;
				int count2 = input2Hmap.get(c) != null ? input2Hmap.get(c) : 0;
				//System.out.println("letter: " + c + " S1: " + count1 + " S2: " + count2);
				count += Math.abs(count1 - count2);
			}
			count /= 2;
		}
		return count;
	}
}
