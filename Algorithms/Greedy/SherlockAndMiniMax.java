package Greedy;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *	Algorithms ->  Greedy -> Sherlock and MiniMax
 *	Hard
 */
public class SherlockAndMiniMax {
	
	private static boolean debugMode = false;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int arraySize = in.nextInt();
		
		int[] array = new int[arraySize];
		
		for(int i = 0; i < arraySize; i++) {
			array[i] = in.nextInt();
		}
		
		int lowerBounds = in.nextInt();
		int upperBounds = in.nextInt();
		
		int ans = divideAndConquer(array, lowerBounds, upperBounds)[1];
		
		System.out.println(ans);
		
		in.close();
	}
	
	
	
	/**
	 * This works now, but it is still too slow.
	 * 
	 * @param array
	 * @param lowerBounds
	 * @param upperBounds
	 * @return
	 */
	public static int[] divideAndConquer(int[] array, int lowerBounds, int upperBounds)
	{
		if(upperBounds == lowerBounds) {
			int ans = 0;
			int minmax = 0;
			int min = Integer.MAX_VALUE;
			int temp = 0;
			
			for(int a = 0; a < array.length; a++) {
				int difference = Math.abs(array[a] - lowerBounds);
				if(debugMode)
					System.out.println(array[a] + " - " + lowerBounds + " = " + difference);
				if(difference < min) {
					temp = lowerBounds;
					min = difference;
					if(debugMode)
						System.out.println("temp: " + temp + " min: " + min);
				}
			}
			
			if(min > minmax) {
				minmax = min;
				ans = temp;
			}
			
			int[] arr = {minmax, ans};
			
			return arr;
		}
		
		int mid = lowerBounds + (upperBounds - lowerBounds) / 2;
		
		if(debugMode)
			System.out.println("mid: " + mid);
		
		
		int[] left = divideAndConquer(array, lowerBounds, mid);
		int[] right = divideAndConquer(array, mid + 1, upperBounds);
		
		int a[] = new int[2];
		
		if(left[0] > right[0]) {
			a = left;
		} else if(left[0] < right[0]) {
			a = right;
		} else {
			a = (left[1] < right[1]) ? left : right;
		}
		
		return a;
	}
	
	/**
	 * This is really bad approach because it has to loop through.
	 * It has to not only loop through the n elements in array
	 * but also the upperbounds - lowerbounds elements.
	 * 
	 * This works but it takes too slow.
	 * 
	 * @param array
	 * @param lowerBounds
	 * @param upperBounds
	 * @return
	 */
	public static int bruteForeMethod(int[] array, int lowerBounds, int upperBounds)
	{
		int ans = 0;
		int minmax = 0;
		
		for(int i = lowerBounds; i <= upperBounds; i++) {
			int min = Integer.MAX_VALUE;
			int temp = 0;
			for(int a = 0; a < array.length; a++) {
				int difference = Math.abs(array[a] - i);
				if(debugMode)
					System.out.println(array[a] + " - " + i + " = " + difference);
				if(difference < min) {
					temp = i;
					min = difference;
					if(debugMode)
						System.out.println("temp: " + temp + " min: " + min);
				}
			}
			if(min > minmax) {
				minmax = min;
				ans = temp;
			}
		}
		
		return ans;
	}
}
