package DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

/**
 *	Algorithms -> Dynamic Programming -> The Coin Change Problem
 *	Hard
 */
public class TheCoinChangeProblem {
	private static long[][] memo;
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		int amount = in.nextInt();
		int coinCount = in.nextInt();
		
		long[] coins = new long[coinCount];
		
		for(int i = 0; i < coinCount; i++)
			coins[i] = in.nextLong();
		
		in.close();
		
		memo = new long[amount + 1][coinCount + 1];
		
		for(int i = 0; i < memo.length; i++)
			for(int j = 0; j < memo[i].length; j++)
				memo[i][j] = -1;
		
		long count = count((int) amount, coins, coinCount);
		
		System.out.println(count);
	}
	
	public static long count(long sum, long[] coins, int coin_count)
	{
		if(sum == 0)
			return 1;
		else if(sum < 0 || coin_count <= 0)
			return 0;
		else if(memo[(int)sum][coin_count] != -1)
			return memo[(int)sum][coin_count];
		else {
			memo[(int)sum][coin_count] = 
					count(sum, coins, coin_count - 1) + 
					count(sum - coins[coin_count - 1], coins, coin_count);
	        return memo[(int)sum][coin_count];
		}
	}
}
