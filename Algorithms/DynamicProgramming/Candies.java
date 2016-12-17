package DynamicProgramming;

import java.util.Scanner;

/**
 *	Algorithms -> Dynamic Programming -> Candies
 *	Medium
 */
public class Candies {

	private static boolean debugMode = true;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int numStudents = in.nextInt();
		
		int[] studentRatings = new int[numStudents];
		
		for(int  s = 0; s < numStudents; s++) {
			studentRatings[s] = in.nextInt();
		}
		
		in.close();
		
		int numberOfCandies = numStudents;
				
		for(int  s = 0; s < numStudents - 1; s++) {
			if(studentRatings[s + 1] > studentRatings[s]) {
				numberOfCandies += 1;
			} 
		}
				
		for(int  s = numStudents - 1; s > 0; s--) {
			if(studentRatings[s - 1] > studentRatings[s]) {
				numberOfCandies += 1;
			} 
		}
		
		System.out.println(numberOfCandies);
	}

}
