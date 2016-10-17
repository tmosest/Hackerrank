package Implementation;

import java.util.Scanner;

/**
 *	Algorithms -> Implementations -> Sherlock and Squares
 *	Easy
 */
public class SherlockAndSquares {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int cases = in.nextInt();
		for(int i = 0; i < cases; i++) {
			int min = in.nextInt();
			int max = in.nextInt();
			System.out.println(
					calculateSquaresInInterval(min, max)
			);
		}
		in.close();
	}
	
	public static int calculateSquaresInInterval(int min, int max)
	{
		int numSquares = 0;
		int start = (int) Math.floor(Math.sqrt((double) min));
		int end = (int) Math.ceil(Math.sqrt((double) max));
		for(int i = start; i <= end; i++) {
			int iSquared = i*i;
			if(iSquared >= min && iSquared <= max) numSquares++;
		}
		return numSquares;
	}

}
