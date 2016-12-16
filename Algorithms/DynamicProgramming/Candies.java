package DynamicProgramming;

import java.util.Scanner;

public class Candies {

	private static boolean debugMode = false;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int numStudents = in.nextInt();
		
		int[] studentRatings = new int[numStudents];
		
		for(int  s = 0; s < numStudents; s++) {
			studentRatings[s] = in.nextInt();
		}
		
		in.close();
		
		int numberOfCandies = numStudents;
		
		int stack = 0;
		
		for(int  s = 1; s < numStudents; s++) {
			if(studentRatings[s] > studentRatings[s - 1]) {
				stack++;
				numberOfCandies += stack;
			} else if(s < numStudents - 1 && studentRatings[s] > studentRatings[s + 1]) {
				numberOfCandies++;
			} else {
				stack = 0;
			}
			if(debugMode) {
				System.out.println("Student: " + (s + 1) + " rating: " + studentRatings[s] + " Extra Cookies: ");
			}
		}
		
		System.out.println(numberOfCandies);
	}

}
