package WeekOfCode.Week26;

import java.util.Scanner;

/**
 *	Algorithms -> Week of Code 26 -> Army Game
 *	Easy
 */
public class ArmyGame {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int rows = in.nextInt();
		int columns = in.nextInt();
			
		in.close();
		
		int supplyDropsNeeded = calculateSupplyDropsNeeded(rows, columns);
		
		System.out.println(supplyDropsNeeded);
	}
	
	public static int calculateSupplyDropsNeeded(int rows, int columns)
	{
		int dropsNeeded = 0;
		
		if(rows <= 2) {
			dropsNeeded = columns / 2 + columns % 2;
		} else if(columns <= 2) { 
			dropsNeeded = rows / 2 + rows % 2;
		} else {
			dropsNeeded = (rows / 2 + rows % 2) + (columns / 2 + columns % 2);
		}
		
		return dropsNeeded;
	}
}


