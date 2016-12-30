package GameTheory;

import java.util.Scanner;

/**
 *	Algorithms -> Game Theory -> Misère Nim
 *	Easy
 *  http://mathoverflow.net/questions/71802/analysis-of-misere-nim
 */
public class MisèreNim {	

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int games = in.nextInt();
		
		for(int g = 0; g < games; g++) {
			
			int numOfStacks = in.nextInt();
			
			int[] stacksOfStones = new int[numOfStacks];
			
			for(int s = 0; s < numOfStacks; s++) {
				stacksOfStones[s] = in.nextInt();
			}
			
			int winner = GameOfNim.determineWinnderOfGame(stacksOfStones);
			
			String output = (winner == 1) ? "First" : "Second";
			System.out.println(output);
		}
		
		in.close();
	}

	private static class GameOfNim
	{
		private static int determineWinnderOfGame(int[] stacks)
		{
			boolean hasStackGreaterThanOne = false;
			
			int winner = 1;
			
			int stackXOR = stacks[0];
			
			if(stacks[0] > 1) hasStackGreaterThanOne = true;
			
			for(int i = 1; i < stacks.length; i++) {
				stackXOR ^= stacks[i];
				if(stacks[i] > 1) hasStackGreaterThanOne = true;
			}
			
			if( (stackXOR == 0 && hasStackGreaterThanOne) ||  (stackXOR == 1 && !hasStackGreaterThanOne)) 
				winner = 2;
			
			return winner;
		}
	}

}
