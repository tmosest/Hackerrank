package MathFundamentals;

import java.util.Scanner;

/**
 *	Mathematics -> Fundamentals -> Handshake
 *	Easy
 */
public class Handshake {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int numCases = in.nextInt();
		for(int i = 0; i < numCases; i++) {
			int numPeople = in.nextInt();
			long handshakes = gaussFormula(numPeople - 1);
			System.out.println(handshakes);
		}
		
		in.close();
	}

	public static long gaussFormula(int number)
	{
		long result = (number * (number + 1)) /2;
		return result;
	}
}
