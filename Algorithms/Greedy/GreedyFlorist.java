package Greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 *	Algorithms ->  Greedy -> Greedy Florist
 *	Medium
 */
public class GreedyFlorist {

	static private boolean debugMode = false;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int numberOfFlowers = in.nextInt();
		int numberOfPeople = in.nextInt();
		
		int[] flowerCosts = new int[numberOfFlowers];
		int[] flowersBought = new int[numberOfPeople];
		
		for(int i = 0; i < numberOfFlowers; i++)
			flowerCosts[i] = in.nextInt();
		
		in.close();
		
		Arrays.sort(flowerCosts);
		
		int totalCost = 0;
		
		for(int i = 0; i < flowerCosts.length; i++) {
			int flowerCost = flowerCosts[flowerCosts.length - i - 1];
			int numberAlreadyBought = flowersBought[i % numberOfPeople];
			int cost = calculateCost(flowerCost, numberAlreadyBought);
			totalCost += cost;
			flowersBought[i % numberOfPeople]++;
		}
		
		System.out.println(totalCost);
	}
	
	private static int calculateCost(int cost, int numberBought)
	{
		int total = 0;
		total = (numberBought + 1) * cost;
		return total;
	}
}
