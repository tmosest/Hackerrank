package GameTheory;

import java.util.Scanner;

/**
 *	Algorithms -> Game Theory -> Tower Breakers
 *	Easy
 */
public class TowerBreakers {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int games = in.nextInt();
		
		for(int g = 0; g < games; g++) {
			int numberOfTowers = in.nextInt();
			int heightOfTowers = in.nextInt();
			
			int winner = (heightOfTowers == 1 || numberOfTowers % 2 == 0) ? 2 : 1;
			System.out.println(winner);
		}
		
		in.close();
	}

}
