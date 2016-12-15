package GameTheory;

import java.util.Scanner;

/**
 *	Algorithms -> Game Theory -> Game of Stones
 *	Easy
 */
public class GameOfStones {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int cases = in.nextInt();
		
		for(int c = 0; c < cases; c++) {
			int stones = in.nextInt();
			System.out.println(stones % 7 < 2 ? "Second ": "First");
		}
		
		in.close();
	}

}
