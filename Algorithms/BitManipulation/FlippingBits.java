package BitManipulation;

import java.util.Scanner;

/**
 *	Algorithms -> Bit Manipulation -> Lonely Integer
 *	Easy
 */
public class FlippingBits {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int cases = in.nextInt();
		
		for(int c = 0; c < cases; c++) {
			long number = in.nextLong();
			long complement = complement(number);
			System.out.println(complement);
		}
		
		in.close();
	}
	
	private static long complement(long num){
		
		long maxInt = (long)Math.pow(2, 32)-1;
	    return maxInt - num;
	
	}
}
