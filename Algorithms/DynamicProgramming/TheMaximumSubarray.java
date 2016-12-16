package DynamicProgramming;

import java.util.Scanner;

/**
 *	Algorithms -> Dynamic Programming -> The Maximum Subarray
 *	Medium
 */
public class TheMaximumSubarray {
	static int maxSumPossible;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int cases = in.nextInt();
		
		for(int c = 0; c < cases; c++) {
			int size = in.nextInt();
			int[] array = new int[size];
			
			for(int i = 0; i < size; i++) {
				array[i] = in.nextInt();
			}
			
			System.out.println(max_subarray(array) + " " + maxSumPossible);
		}
		
		in.close();
	}

	/**
	 * Kadane's algorithm
	 * With a few modifications to allow it to handle all negative contiguous arrays.
	 * And to allow it to compute the max non-contiguous subarrays.
	 */
	private static int max_subarray(int[] array)
	{
		maxSumPossible = 0;
		int largestElement = Integer.MIN_VALUE;
		
		int max_ending_here = 0, 
			max_so_far = 0;
		
		for(int i : array) {
			max_ending_here = Math.max(0, max_ending_here + i);
			max_so_far = Math.max(max_so_far, max_ending_here);
			/*
			 * Extra code to get max sum possible
			 */
			maxSumPossible += Math.max(0, i);
			largestElement = Math.max(largestElement, i);
		}
		
		if(maxSumPossible == 0 && largestElement < 0) { 
			maxSumPossible = largestElement;
			max_so_far = largestElement;
		}
		
		return max_so_far;
	}
}
