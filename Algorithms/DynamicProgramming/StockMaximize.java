package DynamicProgramming;

import java.util.Scanner;

/**
 *	Algorithms -> Dynamic Programming -> Stock Maximize
 *	Medium
 */
public class StockMaximize {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int cases = in.nextInt();
		
		for(int c = 0; c < cases; c++) {
			int numberOfDays = in.nextInt();
			int[] prices = new int[numberOfDays];
			for(int i = 0; i < numberOfDays; i++) 
				prices[i] = in.nextInt();
			System.out.println(getMaxProfit(prices));
		}
		
		in.close();
	}
	
	/*
	 * Wow this is genius.....
	 */
	public static long getMaxProfit(int[] prices) {
        long profit = 0L;
        int maxSoFar = 0;
        for (int i = prices.length - 1; i > -1 ; i--) {
            if (prices[i] >= maxSoFar) {
                maxSoFar = prices[i];
            }
            profit += maxSoFar - prices[i];
        }
        return profit;
    }

}
