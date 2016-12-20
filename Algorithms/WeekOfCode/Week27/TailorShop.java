package WeekOfCode.Week27;

import java.util.HashMap;
import java.util.Scanner;

/**
 *	Algorithms -> Week of Code 27 -> Tailor Shop
 *	Easy
 */
public class TailorShop {

	private static boolean debugMode = true;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		HashMap<Integer, Integer> distinceTracker = new HashMap<Integer, Integer> ();
		
		int numClusters = in.nextInt();
		int pricePerButton = in.nextInt();
		
		long buttonCount = 0;
		
		for(int b = 0; b < numClusters; b++) {
			int minCostForClust = in.nextInt();
			int numberOfButtons = (int) Math.ceil((double) minCostForClust / pricePerButton);
			while(distinceTracker.get(numberOfButtons) != null) {
				numberOfButtons++;
			}
			distinceTracker.put(numberOfButtons, 1);
			buttonCount += numberOfButtons;
		}
		
		in.close();
	
		System.out.println(buttonCount);
	}

}
