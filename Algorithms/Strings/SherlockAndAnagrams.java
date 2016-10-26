package Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class SherlockAndAnagrams {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int numCases = in.nextInt();
		for(int i = 0; i < numCases; i++) {
			String test = in.next();
			int count = countAnagramsOfSubStrings(test);
			System.out.println(count);
		}
		in.close();
	}

	public static HashMap<Integer, ArrayList<String>> createAllPossibleSubStrings(String input)
	{
		HashMap<Integer, ArrayList<String>> listWordsWithLength = new HashMap<Integer, ArrayList<String>>();
		int n = input.length();
		for(int i = 0; i < n; i++) {
			for(int j = i + 1; j < n + 1; j++) {
				String substring = input.substring(i, j);
				//System.out.println(substring);
				int subStringLength = substring.length();
				ArrayList<String> words = (listWordsWithLength.get(subStringLength) == null) ? 
						new ArrayList<String>() : listWordsWithLength.get(subStringLength);
				words.add(substring);
				listWordsWithLength.put(subStringLength, words);
			}
		}
		return listWordsWithLength;
	}
	
	public static int countAnagramsOfSubStrings(String input)
	{
		int count = 0;
		HashMap<Integer, ArrayList<String>> listWordsWithLength = createAllPossibleSubStrings(input);
		for(ArrayList<String> arrayList : listWordsWithLength.values()) {
			ArrayList<HashMap<Character, Integer>> letterCounts = new ArrayList<HashMap<Character, Integer>>();
			for(String s : arrayList) {
				HashMap<Character, Integer> lettersCount = new HashMap<Character, Integer>();
				for(char c : s.toCharArray()) {
					int letterCount = (lettersCount.get(c) == null) ? 
							0 : lettersCount.get(c);
					lettersCount.put(c, ++letterCount);
				}
				letterCounts.add(lettersCount);
			}
			
			for(int i = 0; i < letterCounts.size() - 1; i++) {
				HashMap<Character, Integer> lCount = letterCounts.get(i);
				for(int j = i + 1; j < letterCounts.size(); j++) {
					HashMap<Character, Integer> lCount2 = letterCounts.get(j);
					if(lCount.equals(lCount2)) {
						//System.out.println("Real Pairs: " + lCount + " " + lCount2);
						count++;
					}
				}
			}
		}
		return count;
	}
}
