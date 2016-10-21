package Strings;

import java.util.HashMap;
import java.util.Scanner;

/**
 *	Algorithms -> Strings -> Game of Thrones - I
 *	Easy
 */
public class GameOfThronesI {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String input = in.next();
		String result = "NO";
		boolean isAnagramOfPalindrome = isAnagramOfPalindrome(input);
		if(isAnagramOfPalindrome) {
			result = "YES";
		}
		System.out.println(result);
		in.close();
	}
	
	public static boolean isAnagramOfPalindrome(String word)
	{
		boolean result = true;
		HashMap<Character, Integer> wordCount = new HashMap<Character, Integer>();
		for(int i = 0; i < word.length(); i++) {
			char letter = word.charAt(i);
			int count = wordCount.get(letter) != null ? wordCount.get(letter) : 0;
			wordCount.put(letter, ++count);
		}
		int oddCount = 0;
		for(char letter : wordCount.keySet()) {
			int count = wordCount.get(letter);
			//System.out.println("Letter: " + letter + " count: " + count);
			if(count % 2 == 1) oddCount++;
		}
		//System.out.println("Odd Count: " + oddCount);
		if( (oddCount > 1) || (word.length() % 2 == 1 && oddCount != 1) ) {
			result = false;
		}
		return result;
	}
}
