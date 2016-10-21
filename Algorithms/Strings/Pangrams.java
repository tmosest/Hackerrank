package Strings;

import java.util.HashMap;
import java.util.Scanner;

/**
 *	Algorithms -> Strings -> Pangrams
 *	Easy
 */
public class Pangrams {
		
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String sentence = in.nextLine();
		in.close();
		boolean isPangram = isPangram(sentence);
		String result = "not pangram";
		if(isPangram) {
			result= "pangram";
		}
		System.out.println(result);
	}
	
	public static boolean isPangram(String input)
	{
		boolean isPangram = true;
		char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		HashMap<Character, Integer> hmap = new HashMap<Character, Integer>();
		for(char letter : alphabet) {
			hmap.put(letter, 0);
		}
		String trimmedInput = input.replace(" ", "");
		//System.out.println(trimmedInput);
		for(int letter_i = 0; letter_i < trimmedInput.length(); letter_i++) {
			char letter = Character.toLowerCase(trimmedInput.charAt(letter_i));
			int letterCount = hmap.get(letter);
			hmap.put(letter, ++letterCount);
		}
		for(char letter : alphabet) {
			int letterCount = hmap.get(letter);
			if(0 == letterCount) {
				isPangram = false;
				break;
			}
		}
		return isPangram;
	}

}
