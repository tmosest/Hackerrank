package Strings;

import java.util.Scanner;

public class AlternatingCharacters {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int numCases = in.nextInt();
		for(int i = 0; i < numCases; i++) {
			String ABs = in.next();
			int numDeletions = calculateNumDeletions(ABs);
			System.out.println(numDeletions);
		}
		in.close();
	}
	
	public static int calculateNumDeletions(String ABs) 
	{
		int numDeletions = 0;
		char[] ABsArray = ABs.toCharArray();
		for(int i = 0; i < ABsArray.length; i++) {
			int j = i + 1;
			if(j < ABsArray.length && ABsArray[i] == ABsArray[j]) numDeletions++;
		}
		return numDeletions;
	}
}
