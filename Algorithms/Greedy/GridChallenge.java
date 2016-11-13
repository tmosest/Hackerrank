package Greedy;

import java.util.Scanner;

/**
 *	Algorithms ->  Greedy -> Grid Challenge
 *	Easy
 */
public class GridChallenge {
	
	/**
	 * The only real question is if the max char in the last row is less than the smallest char in the next row;
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int testCases = in.nextInt();
		
		for(int t = 0; t < testCases; t++) {
			int arraySize = in.nextInt();
			char[] maxs = new char[arraySize];
			char[] mins = new char[arraySize];
			boolean isOrderable = true;
			for(int i = 0; i < arraySize; i++) {
				String line = in.next();
				System.out.println("line: " + line);
				char min = 'z';
				char max = 'a';
				for(char letter: line.toCharArray()) {
					if(letter > max) max = letter;
					if(letter < min) min = letter;
				}
				maxs[i] = max;
				mins[i] = min;
				System.out.println("min " + i + " " + min);
				System.out.println("max " + i + " " + max);
				if(i > 0) {
					System.out.println("max " + (i - 1) + " " + maxs[i - 1] + " min " + i + " " + mins[i]);
					if(maxs[i - 1] > mins[i]) {
						isOrderable = false;
						break;
					}
				}
			}
			String result = "NO";
			if(isOrderable) result = "YES";
			System.out.println(result);
		} // end for testCases
		
		in.close();
	}
	
	
}
