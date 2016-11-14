package Sorting;

import java.util.Scanner;
import java.util.TreeMap;

/**
 *	Algorithms -> Sorting -> Counting Sort 3
 *	Medium
 */
public class TheFullCountingSort {

	public static void main(String[] args) {
		TreeMap<String, Integer> countToWord = new TreeMap<String, Integer>();
		
		Scanner in = new Scanner(System.in);
		int listSize = in.nextInt();
		for(int i = 0; i < listSize; i++) {
			int count = in.nextInt();
			String line = in.next();
			if(i < listSize / 2) {
				line = "-";
			}
			countToWord.put(line, count);
		}
		
		for(String line: countToWord.keySet()) {
			System.out.print(line + " ");
		}
		
		in.close();
	}

}
