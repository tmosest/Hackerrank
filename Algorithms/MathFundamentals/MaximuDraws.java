package MathFundamentals;

import java.util.Scanner;

/**
 *	Mathematics -> Fundamentals -> Maximum Draws
 *	Easy
 */
public class MaximuDraws {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int numCases = in.nextInt();
		for(int i = 0; i < numCases; i++) {
			int numPairsSocks = in.nextInt();
			numPairsSocks++;
			System.out.println(numPairsSocks);
		}
		
		in.close();
	}

}
