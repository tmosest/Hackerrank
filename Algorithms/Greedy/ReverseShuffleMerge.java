package Greedy;

import java.util.Scanner;

/**
 *	Algorithms ->  Greedy -> Reverse Shuffle Merge
 *	Hard
 */
public class ReverseShuffleMerge {

	private static boolean debugMode = false;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		String input = in.next();
		
		in.close();
		
		// Get letter Counts
		int[] letterCounts = new int[26];
		for(int i = 0; i < input.length(); i++) {
			letterCounts[input.charAt(i) - 'a']++;
			if(debugMode) 
				System.out.println("Letter: " + input.charAt(i) + " count: " + letterCounts[input.charAt(i) - 'a']);
		}
		
		//Determine letter counts:
		int[] requiredCounts = new int[26];
		for(int i = 0; i < letterCounts.length; i++) {
			requiredCounts[i] = letterCounts[i] / 2;
			if(debugMode) 
				System.out.println("requiredCounts: " + i + " count: " + requiredCounts[i]);
		}
		
		//Loop through String backwards and try to find letters.
		int smallest = smallest(requiredCounts);
		if(debugMode) 
			System.out.println("smallest: " + smallest);
		StringBuilder sb = new StringBuilder(input.length()/2);
		for(int i = 0; i < input.length(); i++) {
			char letter =  input.charAt(input.length() - i - 1);
			int index = letter - 'a';
			if(debugMode) 
				System.out.println("letter: " + letter + " index: " + index + " letterCounts: " + letterCounts[index] + " requiredCounts: " + requiredCounts[index]);
			//Decrement the letter we are looking at.
			letterCounts[index]--;
			//Look to see if we need to add letter.
			if(requiredCounts[index] > 0 && letterCounts[index] < requiredCounts[index]) {
				//Then I have to take that letter.
				--requiredCounts[index];
				sb.append(letter);
				if(debugMode) 
					System.out.println("need to append: " + letter);
			} else if(index == smallest){
				//Should always take the smallest letter if I can.
				sb.append(letter);
				--requiredCounts[index];
				smallest = smallest(requiredCounts);
				if(debugMode) {
					System.out.println("append smallest: " + letter);
					System.out.println("smallest: " + smallest);
				}
			}
		}
		
		System.out.println(sb.toString());
	}
	
	private static int smallest(int[] a)
	{
		int i;
	    for(i = 0 ; i < 26 ; i++)
	        if( a[i] != 0 )
	            return i;

	    return 25;
	}

}
