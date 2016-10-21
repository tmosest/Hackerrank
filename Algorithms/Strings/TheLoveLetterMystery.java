package Strings;

import java.util.Scanner;

/**
 *	Algorithms -> Strings -> The Love-Letter Mystery
 *	Easy
 */
public class TheLoveLetterMystery {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int numCases = in.nextInt();
		for(int i = 0; i < numCases; i++) {
			String input = in.next();
			int indexToRemove = determineCostToMakePalidrone(input);
			System.out.println(indexToRemove);
		}
		in.close();
	}
	
	public static int determineCostToMakePalidrone(String input)
	{
		int cost = 0;
		String inputReverse = new StringBuffer(input).reverse().toString();
		for(int i = 0; i < input.length() / 2; i++) {
			cost += Math.abs(input.charAt(i) - inputReverse.charAt(i));
		}
		return cost;
	}
}
