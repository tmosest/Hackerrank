package Sorting;

import java.util.Scanner;

/**
 *	Algorithms -> Sorting -> Counting Sort 1
 *	Easy
 */
public class CountingSort1 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int[] countArray = new int[100];
		
		int arraySize = in.nextInt();
		
		for(int i = 0; i < arraySize; i++) {
			int input = in.nextInt();
			countArray[input] += 1;
		}
		
		in.close();
		
		for(int i = 0; i < countArray.length; i++) {
			System.out.print(countArray[i] + " ");
		}
		
	}

}
