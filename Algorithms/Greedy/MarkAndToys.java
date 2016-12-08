package Greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 *	Algorithms ->  Greedy -> Mark and Toys
 *	Easy
 */
public class MarkAndToys {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int arraySize = in.nextInt();
		int money = in.nextInt();
		
		int[] toyPrices = new int[arraySize];
		for(int i = 0; i < arraySize; i++) {
			toyPrices[i] = in.nextInt();
		}
		
		in.close();
		
		Arrays.sort(toyPrices);
		
		int numberOfToys = 0;
		for(int i = 0; i < arraySize; i++) {
			if(money >= toyPrices[i]) {
				money -= toyPrices[i];
				numberOfToys++;
			} else {
				break;
			}
		}
		
		System.out.println(numberOfToys);
	}

}
