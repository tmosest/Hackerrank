package WeekOfCode.Week27;

import java.util.Scanner;

/**
 *	Algorithms -> Week of Code 27 -> Zero-Move Nim
 *	Medium
 *
 *Game Theory:
 *https://web.stanford.edu/class/cs97si/05-combinatorial-games.pdf
 *https://www.topcoder.com/community/data-science/data-science-tutorials/algorithm-games/
 *http://www.cs.ubbcluj.ro/~moltean/oltean_nim.pdf
 *http://letuskode.blogspot.com.br/2014/08/grundy-numbers.html
 *http://math.stackexchange.com/questions/416042/why-xor-operator-works
 *http://web.mit.edu/sp.268/www/nim.pdf
 *https://www.youtube.com/watch?v=Owz6aNzGID4
 *https://www.youtube.com/watch?v=Pys4p6qPnFE
 *https://letuskode.blogspot.ch/2014/08/grundy-numbers.html
 */
public class ZeroMoveNim {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int games = in.nextInt();

		for(int g = 0; g < games; g++) {

			int numOfStacks = in.nextInt();

			long[] stacksOfStones = new long[numOfStacks];

			for(int s = 0; s < numOfStacks; s++) {
				stacksOfStones[s] = in.nextLong();
				if(stacksOfStones[s] != 0 && stacksOfStones[s] % 2 == 0) {
					stacksOfStones[s]--;
				} else if(stacksOfStones[s] != 0 && stacksOfStones[s] % 2 == 1) {
					stacksOfStones[s]++;
				}
			}

			int winner = GameOfNim.determineWinnderOfGame(stacksOfStones);

			String output = (winner == 1) ? "W" : "L";
			System.out.println(output);
		}

		in.close();
	}

	private static class GameOfNim
	{

		public static int determineWinnderOfGame(long[] stacks)
		{
			int winner = 1;

			long stackXOR = stacks[0];

			for(int i = 1; i < stacks.length; i++) {
				stackXOR ^= stacks[i];
			}

			if(stackXOR == 0) winner = 2;

			return winner;
		}
	}
}
