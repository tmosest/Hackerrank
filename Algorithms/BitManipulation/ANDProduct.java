package BitManipulation;

import java.util.Scanner;

/**
 *	Algorithms -> Bit Manipulation -> AND Product
 *	Medium
 *  The key is you don't need to check every number between a and b but only a + powers of 2 up to b.
 */
public class ANDProduct {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int cases = in.nextInt();
		
		for(int c = 0; c < cases; c++) {
			long a = in.nextLong();
			long b = in.nextLong();
			
			long product = a;
			
			for(long i = 0; a + (int) Math.pow(2, i) <= b; i++) {
				product = product & (a + (int) Math.pow(2, i));
			}
			
			product = product & b;
			
			System.out.println(product);
		}
		
		in.close();
	}

}
