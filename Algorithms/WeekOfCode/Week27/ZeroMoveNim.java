package WeekOfCode.Week27;

import java.util.Scanner;

public class ZeroMoveNim {

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
			
			String output = (winner == 1) ? "W" : "L";
			System.out.println(output);
		}
		
		in.close();
	}

	private static class GameOfNim
	{
		private static int determineWinnderOfGame(int[] stacks)
		{
			int winner = 1;
			
			int stackXOR = stacks[0];
			
			for(int i = 1; i < stacks.length; i++) {
				stackXOR ^= stacks[i];
			}
			
			if(stackXOR == 0) winner = 2;
			
			return winner;
		}
	}
}
