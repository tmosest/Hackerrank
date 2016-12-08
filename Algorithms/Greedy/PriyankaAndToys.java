package Greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 *	Algorithms ->  Greedy -> Priyanka and Toys
 *	Easy
 */
public class PriyankaAndToys {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int arraySize = in.nextInt();
		int[] toyWeights = new int[arraySize];
		
		for(int i = 0; i < arraySize; i++) {
			toyWeights[i] = in.nextInt();
		}
		
		in.close();
		
		Arrays.sort(toyWeights);
		
		int lastBought = toyWeights[0];
		int count = 1;
		
		for(int i = 1; i < arraySize; i++) {
			if(toyWeights[i] - lastBought <= 4) {
				
			} else {
				count++;
				lastBought = toyWeights[i];
			}
		}
		
		System.out.println(count);
	}

}
