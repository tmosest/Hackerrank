package Greedy;

import java.util.Scanner;

/**
 *	Algorithms ->  Greedy -> Chief Hopper
 *	Hard
 */
public class ChiefHopper {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int numBuildings = in.nextInt();
		int[] jumpHeights = new int[numBuildings + 1];
		
		for(int i = 1; i <= numBuildings; i++) {
			jumpHeights[i] = in.nextInt();
		}
		
		in.close();
		
		int energy = 0;
		
		for(int i = numBuildings; i >= 1; i--) {
			energy = (jumpHeights[i] + energy + 1) / 2;
		}		
		
		System.out.println(energy);
	}

}
