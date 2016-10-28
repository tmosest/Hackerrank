package Implementation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

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
		int m = word1.length();
		
		if(n != m) {
			isPuedoIsomorphic = false;
		} else if(n == 1) {
			isPuedoIsomorphic = false;
		} else {
			
		}
		return isPuedoIsomorphic;
	}
	
	public static ArrayList<Integer> countPseudoIsomorphicSubstring(String input) 
	{
		ArrayList<Integer> setSizes = new ArrayList<Integer>();
		
		ArrayList<ArrayList<String>> stringSets = new ArrayList<ArrayList<String>>();
		
		
		for(int i = 1; i <= input.length(); i++) {
			
			ArrayList<String> words =new ArrayList<String>();  
			
			for(int j = 0; j < i; j++) {
				String subStr = input.substring(0, j);
				//System.out.println(subStr);
				words.add(subStr);
			}
			
			for(int j = 0; j < i; j++) {
				String subStr = input.substring(j, i);
				//System.out.println(subStr);
				words.add(subStr);
			}
			stringSets.add(words);
		}
		
		for(ArrayList<String> set: stringSets) {
			for(int i = 0; i < set.size() - 1; i++) {
				String s1 = set.get(i);
				for(int j = i + 1; j < set.size(); j++) {
					String s2 = set.get(j);
					System.out.println(s1 + " " + s2);
				}
				System.out.println("");
			}
		}
		
		return setSizes;
	}
}
