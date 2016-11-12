package Implementation;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 *	Algorithms -> Implementations -> Happy Ladybugs
 *	Easy
 */
public class HappyLadybugs {
	
	public static boolean isSame(String str) {
		 boolean isSame = true;
		 
		 for (int i = 1; i < str.length() - 1; i++) {
			 if (str.charAt(i) != str.charAt(i - 1)) {
				 isSame = false;
		 		break;
		 	 }
		 }
		 return isSame;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int numCases = in.nextInt();

		for(int i = 0; i < numCases; i++) {
			int arraySize = in.nextInt();
			
			HashMap<Character, Integer> wordCount = new HashMap();
			
			String bugArray = in.next();
			boolean hasUnderscore = false;
			for(int a_i = 0; a_i < arraySize; a_i++) {
				char bugLetter = bugArray.charAt(a_i);
				if(bugLetter == '_') {
					hasUnderscore = true;
				}
				int letterCount = (wordCount.get(bugLetter) == null) ? 0 : wordCount.get(bugLetter);
				wordCount.put(bugLetter, ++letterCount);
			} //end for a_i
			
			boolean canBeHappy = true;
			if(!hasUnderscore) {
				canBeHappy = isSame(bugArray);
			} else {
				for(char letter: wordCount.keySet()) {
					if(letter != '_') {
						int count = wordCount.get(letter);
						if(count < 2) {
							canBeHappy = false;
							break;
						}
					}
				}
			}
			
			String output = "NO";
			if(canBeHappy) output = "YES";
			
			System.out.println(output);
			
		} //end for i
		
		in.close();
	}

}
