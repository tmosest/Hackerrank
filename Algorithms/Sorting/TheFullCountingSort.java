package Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *	Algorithms -> Sorting -> Counting Sort 3
 *	Medium
 */
public class TheFullCountingSort {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int arraySize = in.nextInt();
		
		HashMap<Integer, ArrayList<String>> wordsByCount = new HashMap<Integer, ArrayList<String>>(); 
		
		for(int i = 0 ; i < arraySize; i++) {
			int count = in.nextInt();
			String word = in.next();
			if(i < arraySize / 2) word = "-";
			ArrayList<String> words = (wordsByCount.get(count) == null) ? new ArrayList<String>() : wordsByCount.get(count);
			words.add(word);
			wordsByCount.put(count, words);
		}
				
		for(ArrayList<String> words: wordsByCount.values()) {
			//Collections.sort(words);
			for(String word: words) {
				System.out.print(word + " ");
			}
		}
		
		in.close();
	}
	
	
}
