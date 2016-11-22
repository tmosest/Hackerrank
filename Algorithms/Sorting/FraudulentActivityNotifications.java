package Sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 *	Algorithms -> Sorting -> Fraudulent Activity Notifications
 *	Medium
 */
public class FraudulentActivityNotifications {

	public static void main(String[] args) {
		boolean debugMode = false;
		
		Scanner in = new Scanner(System.in);
		
		int days = in.nextInt();
		int daysNeeded = in.nextInt();
		
		RunningMedian runningMedian = new RunningMedianWithDayLimits(daysNeeded);
		
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
			double median = runningMedian.getMedian(bankTransactions[i]);
			if(debugMode) 
				System.out.println("median for day " + i + " : " + median);
			if(i >= daysNeeded - 1) {
				double threshold = median * 2;
				if(debugMode) { 
					System.out.println("Threshold for day " + i + " : " + threshold);
					System.out.println("Checking against: " + bankTransactions[i + 1]);
				}
				if(bankTransactions[i + 1] >= threshold) {
					notification++;
				}
			}
		}
		
		System.out.println(notification);
	}
	
	// start class RunningMedian
	private static class RunningMedian
	{
		PriorityQueue<Integer> upperQueue;
	    PriorityQueue<Integer> lowerQueue;

	    public RunningMedian()
	    {
	        lowerQueue=new PriorityQueue<Integer>(
	          20,new Comparator<Integer>()
	        {

	            @Override
	            public int compare(Integer o1, Integer o2)
	            {

	                return -o1.compareTo(o2);
	            }

	        });
	        upperQueue=new PriorityQueue<Integer>();
	        upperQueue.add(Integer.MAX_VALUE);
	        lowerQueue.add(Integer.MIN_VALUE);
	    }
	    
	    public double getMedian(int num)
	    {
	        //adding the number to proper heap
	            if(num>=upperQueue.peek())
	                upperQueue.add(num);
	            else
	                lowerQueue.add(num);
	        //balancing the heaps
	        if(upperQueue.size()-lowerQueue.size()==2)
	            lowerQueue.add(upperQueue.poll());
	        else if(lowerQueue.size()-upperQueue.size()==2)
	            upperQueue.add(lowerQueue.poll());
	        //returning the median
	        if(upperQueue.size()==lowerQueue.size())
	            return(upperQueue.peek()+lowerQueue.peek())/2.0;
	        else if(upperQueue.size()>lowerQueue.size())
	            return upperQueue.peek();
	        else
	            return lowerQueue.peek();

	    }
	} //end class RunningMedian
	
	// start class RunningMedian with day limits
	private static class RunningMedianWithDayLimits extends RunningMedian
	{
		private int count = 0;
		private int numberOfDays = 0;
		private int[] toRemove;
		
		public RunningMedianWithDayLimits(int numberOfDays)
	    {
			this.numberOfDays = numberOfDays;
			toRemove = new int[numberOfDays];
			
	        lowerQueue=new PriorityQueue<Integer>(
	          20,new Comparator<Integer>()
	        {

	            @Override
	            public int compare(Integer o1, Integer o2)
	            {

	                return -o1.compareTo(o2);
	            }

	        });
	        upperQueue=new PriorityQueue<Integer>();
	        upperQueue.add(Integer.MAX_VALUE);
	        lowerQueue.add(Integer.MIN_VALUE);
	    }
		
		public double getMedian(int num)
	    {
			//System.out.println("On day " + (1 + count));
	        //adding the number to proper heap
	            if(num>=upperQueue.peek())
	                upperQueue.add(num);
	            else
	                lowerQueue.add(num);
	    
	        //balancing the heaps
	        if(upperQueue.size()-lowerQueue.size()==2)
	            lowerQueue.add(upperQueue.poll());
	        else if(lowerQueue.size()-upperQueue.size()==2)
	            upperQueue.add(lowerQueue.poll());
	        //remove elements if needed
	        if(count > numberOfDays - 1) {
				if(count != 0) {
					int indexToRemove = (count) % numberOfDays;
					//System.out.println("Removing toRemove[" + indexToRemove +"] : " + toRemove[indexToRemove]);
					if(toRemove[indexToRemove]>=upperQueue.peek())
		                upperQueue.remove(toRemove[indexToRemove]);
		            else
		                lowerQueue.remove(toRemove[indexToRemove]);
				}
			}
			toRemove[count % numberOfDays] = num;
			//increment count
			 count++;
			//System.out.println("toRemove[" + count % numberOfDays + "] set to " + num);
			//System.out.println("");
	        //printQues();
	        //returning the median
	        if(upperQueue.size()==lowerQueue.size())
	            return(upperQueue.peek()+lowerQueue.peek())/2.0;
	        else if(upperQueue.size()>lowerQueue.size())
	            return upperQueue.peek();
	        else
	            return lowerQueue.peek();

	    }
		
		public void printQues() 
		{
			System.out.println("Lower");
			for(int num : lowerQueue) {
				System.out.print(num + " ");
			}
			System.out.println("");
			System.out.println("Upper");
			for(int num : upperQueue) {
				System.out.print(num + " ");
			}
			System.out.println("");
		}
	}
	// end class RunningMedian with day limits
}
