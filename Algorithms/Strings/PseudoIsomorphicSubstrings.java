package Strings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

/**
 *	Algorithms -> Strings -> Pseudo-Isomorphic Substrings
 *	Expert
 */
public class PseudoIsomorphicSubstrings {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		in.close();
		countPseudoIsomorphicSubstring(input);
	}
	
	public static boolean isPsuedoIsoMorphic(String word1, String word2)
	{
		boolean isPuedoIsomorphic = true;
		int n = word1.length();
		int m = word2.length();
		
		//System.out.println(word1);
		//System.out.println(word2);
		
		if(n != m) {
			isPuedoIsomorphic = false;
		} else if(n == 1) {
			isPuedoIsomorphic = true;
		} else {
			for(int i = 0; i < n - 1; i++) {
				char word1LetterI = word1.charAt(i);
				char word2LetterI = word2.charAt(i);
				for(int j = i + 1; j < n; j++) {
					char word1LetterJ = word1.charAt(j);
					char word2LetterJ = word2.charAt(j);
					if(word1LetterI != word1LetterJ) {
						if(word2LetterI == word2LetterJ) {
							return false;
						}
					} else {
						if(word2LetterI != word2LetterJ) {
							return false;
						}
					}
				}
			}
		}
		return isPuedoIsomorphic;
	}
	
	public static ArrayList<Integer> countPseudoIsomorphicSubstring(String input) 
	{
		ArrayList<Integer> setSizes = new ArrayList<Integer>();
		
		ArrayList<ArrayList<String>> stringSets = new ArrayList<ArrayList<String>>();
		
		
		for(int i = 1; i <= input.length(); i++) {
			
			ArrayList<String> words = new ArrayList<String>();
			
			String word = input.substring(0, i);
			
			for (int from = 0; from < word.length(); from++) {
		        for (int to = from + 1; to <= word.length(); to++) {
		        	String subWord = word.substring(from, to);
		            //System.out.println(word.substring(from, to));
		        	words.add(subWord);
		        }
		    }
			
			stringSets.add(words);
			//System.out.println(words);
		}
		
		for(ArrayList<String> set: stringSets) {
			//int setCount = set.size();
			
			//int i = 0;
			
			ArrayList<String> uniqueSet = (ArrayList<String>) set.clone();
			/*
			for (Iterator<String> iterator = set.iterator(); iterator.hasNext();) {
			    String string = iterator.next();
			    System.out.println(string);
			    iterator.c
			    if (string.isEmpty()) {
			        // Remove the current element from the iterator and the list.
			        iterator.remove();
			    }
			}
			*/
		
			for(int i = 0; i < set.size() - 1; i++) {
				String s1 = set.get(i);
				if(set.size() > 1) {
					for(int j = i + 1; j < set.size(); j++) {
						String s2 = set.get(j);
						boolean isPsuedoIsoMorphic = isPsuedoIsoMorphic(s1, s2);
						if(isPsuedoIsoMorphic) { 
							//setCount--;
							int index = uniqueSet.indexOf(s2); 
							if(index > -1) uniqueSet.remove(index);
							break;
						}
						//System.out.println(s1 + " " + s2 + " isIso: " + isPsuedoIsoMorphic);
					}
				}
				//System.out.println("");
			}
			//System.out.println(setCount);
			System.out.println(uniqueSet.size());
			//System.out.println(uniqueSet);
		}
		
		return setSizes;
	}
}
