package Implementation;

import java.util.Scanner;

/**
 *	Algorithms -> Implementations -> Taum and B'day
 *	Easy
 */
public class TaumAndBday {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
	     int t = in.nextInt();
	     for(int a0 = 0; a0 < t; a0++){
	    	 long b = in.nextLong();
	         long w = in.nextLong();
	         long x = in.nextLong();
	         long y = in.nextLong();
	         long z = in.nextLong();
	         long[] array = {b, w, x, y, z};
	         long cost = calculateTaumBdayGiftCost(array);
	         System.out.println(cost);
	     }	
	     in.close();
	}
	
	public static long calculateTaumBdayGiftCost(long[] array)
	{
		long cost = 0;
		if(array[4] + array[2] < array[3]) {
			cost = array[0] * array[2] + (array[4] + array[2]) * array[1];
		} else if(array[4] + array[3] < array[2]) {
			cost = array[1] * array[3] + (array[4] + array[3]) * array[0];
		}	else {
			cost = array[0] * array[2] + array[1] * array[3];
		}
		return cost;
	}
	
}
