package Greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 *	Algorithms ->  Greedy -> Jim and the Orders
 *	Easy
 */
public class JimAndTheOrders {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int numberOfOrders = in.nextInt();
		
		Pair[] orders = new Pair[numberOfOrders];
		
		for(int i = 0; i < numberOfOrders; i++) {
			
			int timeOfOrder = in.nextInt();
			int durationOfOrder = in.nextInt();
			int timeFinished = timeOfOrder + durationOfOrder;
			int orderNumber = i + 1;
			
			Pair order = new Pair(timeFinished, orderNumber);
			orders[i] = order;
		}
		
		Arrays.sort(orders);
		
		for(Pair order: orders) {
			System.out.print(order.second + " ");
		}
		
		in.close();
	}
	
	private static class Pair implements Comparable<Pair>
	{
		public final int first;
	    public final int second;
		
	    public Pair(int first, int second) {
	        this.first = first;
	        this.second = second;
	    }
	    
	    @Override
	    public int compareTo(Pair o) {
	        int cmp = compare(first, o.first);
	        return cmp == 0 ? compare(second, o.second) : cmp;
	    }

		private int compare(int first1, int first2) {
			if(first1 < first2) return -1;
			if(first1 > first2) return 1;
			return 0;
		}
	    
	    
	}

}
