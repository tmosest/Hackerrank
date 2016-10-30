package Walmart;

import java.util.Scanner;

public class HikingSelfies {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int numPeople = in.nextInt();
		int numPhotosLeft = in.nextInt();
		in.close();
		int numOfPeopleCombinations = (int) Math.pow( 2.0, (double) numPeople) - 1;
        int numNeeded = Math.abs(numOfPeopleCombinations - numPhotosLeft);
		System.out.println(numNeeded);
	}

}
