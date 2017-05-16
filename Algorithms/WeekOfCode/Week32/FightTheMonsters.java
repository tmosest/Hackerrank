package WeekOfCode.Week32;

import java.util.Arrays;
import java.util.Scanner;

/**
 *	Algorithms -> Week of Code 32 -> Fight the Monsters
 *	Easy
 */
public class FightTheMonsters {
	
	private static boolean debugMode = false;
	
	private static int getMaxMonsters(int n, int hit, int t, int[] h){
		if(debugMode) {
			System.out.println("Inputs:");
			System.out.println("#Monsters: " + n);
			System.out.println("Gun Power: " + hit);
			System.out.println("#Shots: " + t);
		}
		int totalKilled = 0;
		Arrays.sort(h);
		for(int i = 0; i < h.length; i++) {
			int zombiesHealth = h[i];
			int shotsToKill = (int) Math.ceil(zombiesHealth / ((double) hit));
			// Debugger
			if(debugMode) {
				System.out.println("Zombie: " + i);
				System.out.println("Zombies Health");
				System.out.println(zombiesHealth);
				System.out.println("It will take " + shotsToKill + " shots to kill.");
			}
			// end Debugger
			if(t - shotsToKill >= 0) {
				++totalKilled;
				t -= shotsToKill;
			} else {
				break;
			}
		}
		
		return totalKilled;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int hit = in.nextInt();
        int t = in.nextInt();
        int[] h = new int[n];
        for(int h_i=0; h_i < n; h_i++){
            h[h_i] = in.nextInt();
        }
        int result = getMaxMonsters(n, hit, t, h);
        System.out.println(result);
    }
	
}