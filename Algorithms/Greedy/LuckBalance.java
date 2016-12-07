package Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *	Algorithms ->  Greedy -> Luck Balance
 *	Easy
 */
public class LuckBalance {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int numberOfTests = in.nextInt();
		int numberCanLose = in.nextInt();
		
		ArrayList<Integer> important = new ArrayList<Integer>(); 
		ArrayList<Integer> unimportant = new ArrayList<Integer>();
		
		int total = 0;
		
		for(int t = 0; t < numberOfTests; t++) {
			int luck = in.nextInt();
			int importance = in.nextInt();
			total += luck;
			if(importance == 1) {
				important.add(luck);
			} else {
				unimportant.add(luck);
			}
		}
		
		in.close();
		
		Collections.sort(important);
		Collections.sort(unimportant);
		
		int difference = important.size() - numberCanLose;
		
		if(difference >= 0) {
			for(int i = 0; i < difference; i++) {
				total -= 2 * important.get(i);
			}
		}
		
		System.out.println(total);
	}

}
