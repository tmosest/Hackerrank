package Sorting;

import java.util.Scanner;

/**
 *	Algorithms -> Sorting -> Counting Sort 3
 *	Easy
 */
public class CountingSortIII {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int[] countArray = new int[100];
		
		int arraySize = in.nextInt();
		
		for(int i = 0; i < arraySize; i++) {
			int input = in.nextInt();
			String string = in.next();
			countArray[input] += 1;
		}
		
		in.close();
		
		int total = 0;
		for(int i = 0; i < countArray.length; i++) {
			int count = countArray[i];
			total += count;
			System.out.print(total + " ");
		}
		
	}
	
}
