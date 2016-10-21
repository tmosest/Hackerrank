package Strings;

import java.util.HashMap;
import java.util.Scanner;

/**
 *	Algorithms -> Strings -> Making Anagrams
 *	Easy
 */
public class MakingAnagrams {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s1 = in.next();
		String s2 = in.next();
		int count = countLettersToRemove(s1 , s2);
		System.out.println(count);
		in.close();
	}

	public static int countLettersToRemove(String s1, String s2)
	{
		int count = 0;
		
		HashMap<Character, Integer> wordCountS1 = new HashMap<Character, Integer>();
		HashMap<Character, Integer> wordCountS2 = new HashMap<Character, Integer>();
		
		for(int i = 0; i < s1.length(); i++) {
			char letter = s1.charAt(i);
			int letterCount = wordCountS1.get(letter) != null ? wordCountS1.get(letter) : 0;
			wordCountS1.put(letter, ++letterCount);
		}
		
		for(int i = 0; i < s2.length(); i++) {
			char letter = s2.charAt(i);
			int letterCount = wordCountS2.get(letter) != null ? wordCountS2.get(letter) : 0;
			wordCountS2.put(letter, ++letterCount);
		}
		
		char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		
		for(char letter : alphabet) {
			int letterCount1 = wordCountS1.get(letter) != null ? wordCountS1.get(letter) : 0;
			int letterCount2 = wordCountS2.get(letter) != null ? wordCountS2.get(letter) : 0;
			//System.out.println("Letter: " + letter + " wc1 " + letterCount1 + " wc2 " + letterCount2);
			count += Math.abs(letterCount1 - letterCount2);
		}
		
		return count;
	}
}
