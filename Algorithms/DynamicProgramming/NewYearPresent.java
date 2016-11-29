package DynamicProgramming;

import java.util.Scanner;

/**
 *	Algorithms -> Dynamic Programming -> New Year Present 
 *	Hard
 */
public class NewYearPresent {
	
	static int maxSizeForArray = (int) (2 * 1e7 + 5);
	
	static long dp1[] = new long[maxSizeForArray];
	static long dp2[] = new long[maxSizeForArray];
	static long dp3[] = new long[maxSizeForArray];
	
	static long ans, ans1, ans2, ans3, pom;
	
	static int arraySize, idx;
	
	static int[] sticks;
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		arraySize = in.nextInt();
		sticks = new int[arraySize];
		
		for(int i = 0; i < arraySize; i++) {
			sticks[i] = in.nextInt();
		}
		
		
		
		in.close();
	}

}
