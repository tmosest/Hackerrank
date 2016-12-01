package Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *	Algorithms -> Sorting -> Closest Numbers
 *	Medium
 */
public class ClosestNumbers {

	public static void main(String[] args) { 
		Scanner in = new Scanner(System.in);
		
		int arraySize = in.nextInt();
		int[] array = new int[arraySize];
		
		for(int i = 0; i < arraySize; i++) {
			array[i] = in.nextInt();
		}
		
		in.close();
		
		Arrays.sort(array);
		
		long smallestDifference = Integer.MAX_VALUE;
		long[] differences = new long[arraySize - 1]; 
		for(int i = 1; i < arraySize; i++) {
			long difference = array[i] - array[i - 1];
			differences[i - 1] = difference;
			if(difference < smallestDifference) {
				smallestDifference = difference;
			}
		}
		
		for(int i=0; i<array.length-1 ;i++) {
            if(array[i+1] - array[i] == smallestDifference)
                System.out.print(""+array[i]+' '+array[i+1]+' ');
        }
	}
	
}
