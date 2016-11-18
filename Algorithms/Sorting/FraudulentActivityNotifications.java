package Sorting;

import java.util.Arrays;
import java.util.Scanner;

/**
 *	Algorithms -> Sorting -> Find the Median
 *	Medium
 */
public class FraudulentActivityNotifications {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int days = in.nextInt();
		int daysNeeded = in.nextInt();
		
		int[] bankingTransactions = new int[days];
		
		for(int i = 0; i < days; i++) {
			bankingTransactions[i] = in.nextInt();
		}
		in.close();
		
		int notifications = calculateBankingNotifications(bankingTransactions, daysNeeded);
		System.out.println(notifications);
	}
	
	public static int calculateBankingNotifications(int[] array, int daysNeeded)
	{
		int notifications = 0;
		
		for(int i = 0; i < array.length; i++) {
			if(i > daysNeeded - 1) {
				double median = calculateMedianOfSubArray(array, i - daysNeeded, i);
				//System.out.println("Median: " + median);
				double notificationThreshold = median * 2;
				//System.out.println("Notification Threshold: " + notificationThreshold);
				if(array[i] >= notificationThreshold) {
					notifications++;
				}
			}
		}
		
		return notifications;
	}
	
	public static double calculateMedianOfSubArray(int[] array, int start, int end) 
	{
		int[] subArray = new int[end - start]; 
		for(int i = start; i < end; i++) {
			subArray[i - start] = array[i];
			//System.out.print(subArray[i - start] + " ");
		}
		double median = calculateMeidan(subArray);
		return median;
	}
	
	public static double calculateMeidan(int[] array) 
	{
		int arraySize = array.length;
		double median = 0;
		if(arraySize % 2 == 1) {
			median = (double) selectIterative(array, arraySize/2);
		} else {
			median =  (double) ( selectIterative(array, arraySize/2) + selectIterative(array, arraySize/2 - 1) ) / 2;
		}
		return median;
	}
	
	public static int selectIterative(int[] array, int n) {
		return iterative(array, 0, array.length - 1, n);
	}
	
  	public static int iterative(int[] array, int left, int right, int n) {
  		if(left == right) {
  			return array[left];
  		}
  		
  		for(;;) {
  			int pivotIndex = randomPivot(left, right);
  			pivotIndex = partition(array, left, right, pivotIndex);
  			
  			if(n == pivotIndex) {
  				return array[n];
  			} else if(n < pivotIndex) {
  				right = pivotIndex - 1;
  			} else {
  				left = pivotIndex + 1;
  			}
  		}
	}
  	
  	private static int partition(int[] array, int left, int right, int pivotIndex) {
		int pivotValue = array[pivotIndex];
		swap(array, pivotIndex, right); // move pivot to end
		int storeIndex = left;
		for(int i = left; i < right; i++) {
			if(array[i] < pivotValue) {
				swap(array, storeIndex, i);
				storeIndex++;
			}
		}
		swap(array, right, storeIndex); // Move pivot to its final place
		return storeIndex;
	}
	
	private static void swap(int[] array, int a, int b) {
		int tmp = array[a];
		array[a] = array[b];
		array[b] = tmp;
	}

	private static int randomPivot(int left, int right) {
		return left + (int) Math.floor(Math.random() * (right - left + 1));
	}	
}
