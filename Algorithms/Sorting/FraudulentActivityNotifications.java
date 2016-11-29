package Sorting;

import java.util.Scanner;
import java.util.TreeMap;

/**
 *	Algorithms -> Sorting -> Fraudulent Activity Notifications
 *	Medium
 */
public class FraudulentActivityNotifications {
	
	static boolean debugMode;
	
	public static void main(String[] args) {
		
		debugMode = false;
		
		Scanner in = new Scanner(System.in);
		
		int days = in.nextInt();
		int daysNeeded = in.nextInt();
		
		CountMedianCalculator cmc = new CountMedianCalculator(daysNeeded);
				
		int[] bankTransactions = new int[days];
		for(int i = 0; i < days; i++) {
			bankTransactions[i] = in.nextInt();
			if(debugMode) 
				System.out.println("Added transacion: " + i + " : " + bankTransactions[i]);
		}
		
		in.close();
		
		int notification = 0;
		if(debugMode) 
			System.out.println("Set nofitications to zero");
		for(int i = 0; i < days - 1; i++) {
            double median = cmc.getMedian(bankTransactions[i]);
            if(debugMode) 
				System.out.println("median for day " + (i + 1) + " : " + median);
            if(i >= daysNeeded - 1) {
                if(debugMode) 
				    System.out.println("Compairing " + (2 * median) + " to day " + (i + 2) + " : " + bankTransactions[i + 1]);
                if(bankTransactions[i + 1] >= 2 * median) {
                   notification += 1; 
                   if(debugMode) 
				    System.out.println("Notification increased on day " + (i + 2));
                }
            }
        }
		System.out.println(notification);
	}
	
	private static class CountMedianCalculator
	{
		private int count;
		private int limit;
		private TreeMap<Integer, Integer> numberFrequencies;
		private int[] daysArray;
		private boolean hasEvenDays;
		private int medianIndex;
		
		public CountMedianCalculator(int days)
		{
			this.limit = days;
			this.count = 0;
			this.numberFrequencies = new TreeMap<Integer, Integer>();
			this.daysArray = new int[days];
			this.hasEvenDays = days % 2 == 0;
			this.medianIndex = (days - 1) / 2;
		}
		
		/*
		 * Calculate the new median after adding the new number and removing an old number if needed.
		 */
		public double getMedian(int number) {
			double median = 0;
			
			int daysArrayIndex = this.count % this.limit;
			
			//Check to see If I need to remove a number
			if(this.count >= this.limit) {
				//get frequency
				int numberCount = this.numberFrequencies.get(this.daysArray[daysArrayIndex]);
				this.numberFrequencies.put(this.daysArray[daysArrayIndex], --numberCount);
			}
			
			//Set the new number slot for to remove
			this.daysArray[daysArrayIndex] = number;
			
			//Update number frequency for new number
			int numberCount = (this.numberFrequencies.get(number) == null) ? 0 : this.numberFrequencies.get(number);
			this.numberFrequencies.put(number, ++numberCount);
			
			//Actually Calculate the Median
			if(this.count >= this.limit - 1) {
				if(this.hasEvenDays) {
					int medianCount = 0;
					boolean needsNext = false;
					for(int num : this.numberFrequencies.keySet()) {
						medianCount += this.numberFrequencies.get(num);
						
						if(medianCount >= medianIndex && medianCount <= medianIndex + 1) {
							needsNext = true;
							median = (double) num;
						}
						
						if(medianCount > medianIndex + 1) {
							median += (double) num;
							break;
						}
						
					}
					if(needsNext) {
						median /= 2.0;
					}
				} else {
					int medianCount = 0;
					for(int num : this.numberFrequencies.keySet()) {
						medianCount += this.numberFrequencies.get(num);
						if(debugMode)
							System.out.println(num + " : " + this.numberFrequencies.get(num));
						if(medianCount > medianIndex) {
							median = (double) num;
							break;
						}
					}
				}
			}
			
			//increment count
			this.count += 1;
			
			return median;
		} //end getMedian
		
	}
}
