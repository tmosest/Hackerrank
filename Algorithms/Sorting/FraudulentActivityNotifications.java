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
		Arrays.sort(subArray);
		double median = calculateMeidan(subArray);
		return median;
	}
	
	public static double calculateMeidan(int[] array) 
	{
		int arraySize = array.length;
		double median = 0;
		if(arraySize % 2 == 1) {
			median = (double) array[arraySize/2];
		} else {
			median =  (double) ( array[arraySize/2] + array[arraySize/2 - 1] ) / 2;
		}
		return median;
	}
}
