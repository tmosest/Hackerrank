package Strings;

import java.util.Arrays;
import java.util.Scanner;

/**
 *	Algorithms -> Strings -> String Construction
 *	Easy
 */
public class StringConstruction {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int numCases = in.nextInt();
		for(int i = 0; i < numCases; i++) {
			String toConstruct = in.next();
			int costOfConstruction = calculateCostOfConstruction(toConstruct);
			System.out.println(costOfConstruction);
		}
		in.close();
	}

	public static int calculateCostOfConstruction(String toMatch)
	{
		int cost = 0;
		char[] toMatchArray = toMatch.toCharArray();
		Arrays.sort(toMatchArray);;
		char tempChar = '1';
		for(int i = 0; i < toMatchArray.length; i ++) {
			if(toMatchArray[i] != tempChar) {
				cost++;
				tempChar = toMatchArray[i];
			}
		}
		return cost;
	}
}
