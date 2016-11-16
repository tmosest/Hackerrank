package Sorting;

import java.util.Arrays;
import java.util.Scanner;

/**
 *	Algorithms -> Sorting -> Find the Median
 *	Easy
 */
public class FindTheMedian {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int arraySize = in.nextInt();
		int[] array = new int[arraySize];
		for(int i = 0; i < arraySize; i++) {
			array[i] = in.nextInt();
		}
		in.close();
		Arrays.sort(array);
		int median = 0;
		if(arraySize % 2 == 1) {
			median = array[arraySize/2];
		} else {
			median = ( array[arraySize/2] + array[arraySize/2 - 1] ) / 2;
		}
		System.out.println(median);
	}

}
