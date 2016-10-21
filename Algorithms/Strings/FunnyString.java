package Strings;

import java.util.Scanner;

/**
 *	Algorithms -> Strings -> Funny String
 *	Easy
 */
public class FunnyString {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int numCases = in.nextInt();
		for(int i = 0; i < numCases; i++ ) {
			String toTest = in.next();
			String result = "Not Funny";
			boolean isFunny = testIfFunny(toTest);
			if(isFunny) {
				result = "Funny";
			}
			System.out.println(result);
		}
		in.close();
	}

	public static boolean testIfFunny(String toTest) 
	{
		boolean isFunny = true;
		String toTestReverse = new StringBuffer(toTest).reverse().toString();
		for(int i = 0; i < toTest.length() - 1; i++) {
			int difference = Math.abs(Character.toLowerCase(toTest.charAt(i)) - Character.toLowerCase(toTest.charAt(i + 1)));
			int differenceReversed = Math.abs(Character.toLowerCase(toTestReverse.charAt(i)) - Character.toLowerCase(toTestReverse.charAt(i + 1)));
			if(difference != differenceReversed) {
				isFunny = false;
				break;
			}
		}
		return isFunny;
	}
}
