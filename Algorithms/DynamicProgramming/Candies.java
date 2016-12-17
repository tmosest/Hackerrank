package DynamicProgramming;

import java.util.Scanner;

/**
 *	Algorithms -> Dynamic Programming -> Candies
 *	Medium
 */
public class Candies {

	private static boolean debugMode = false;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int numStudents = in.nextInt();
		
		int[] studentRatings = new int[numStudents];
		int[] candy = new int[numStudents];
		
		for(int  s = 0; s < numStudents; s++) {
			studentRatings[s] = in.nextInt();
			candy[s] = 1;
		}
		
		in.close();
				
		for(int  s = 1; s < numStudents; s++) {
			if(studentRatings[s] > studentRatings[s - 1]) {
				if(candy[s] < candy[s - 1] + 1)
					candy[s] = candy[s - 1] + 1; 
				if(debugMode)
					System.out.println("child: " + (s + 1) + " rank: " + studentRatings[s] + " candy: " + candy[s]);
			} 
		}
				
		for(int  s = numStudents - 2; s >= 0; s--) {
			if(studentRatings[s] > studentRatings[s + 1]) {
				if(candy[s] < candy[s + 1] + 1)
					candy[s] = candy[s + 1] + 1; 
			} 
		}
		
		long numberOfCandies = 0;
		
		for(int c : candy) {
			numberOfCandies += c;
			if(debugMode)
				System.out.println(c);
		}
		
		System.out.println(numberOfCandies);
	}

}
