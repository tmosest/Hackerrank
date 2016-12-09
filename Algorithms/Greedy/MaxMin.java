package Greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 *	Algorithms ->  Greedy -> Max Min
 *	Medium
 */
public class MaxMin {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int arraySize = in.nextInt();
		int k = in.nextInt();
		
		int[] array = new int[arraySize];
		
		//O(n) complex
		for(int i = 0; i < arraySize; i++)
			array[i] = in.nextInt();
		
		Arrays.sort(array);
		
		
		int min = Integer.MAX_VALUE;
		
		//O(n - k) complex
		for(int i = 0; i <= arraySize - k; i++) {
			int diff = array[i + k - 1] - array[i];
			if(diff < min) min = diff;
		}
		
		System.out.println(min);
		
		in.close();
	}

}
