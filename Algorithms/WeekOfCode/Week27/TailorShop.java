package WeekOfCode.Week27;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

/**
 *	Algorithms -> Week of Code 27 -> Tailor Shop
 *	Easy
 */
public class TailorShop {

	private static boolean debugMode = true;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		
		int numClusters = in.nextInt();
		int pricePerButton = in.nextInt();
		
		int[] costs = new int[numClusters];
		
		for(int c = 0; c < numClusters; c++) {
			costs[c] = in.nextInt();
		}
		
		Arrays.sort(costs);
		
		int buttonPointer = 0;
		BigInteger buttonCount = BigInteger.ZERO;
		
		for(int b = 0; b < numClusters; b++) {
			int minCostForClust = costs[b];
			int numberOfButtons = (int) Math.ceil((double) minCostForClust / pricePerButton);
			if(numberOfButtons <= buttonPointer) numberOfButtons = buttonPointer + 1;
			buttonPointer = numberOfButtons;
			buttonCount = buttonCount.add(BigInteger.valueOf(numberOfButtons));
		}
		
		in.close();
	
		System.out.println(buttonCount);
	}
	
	
}
