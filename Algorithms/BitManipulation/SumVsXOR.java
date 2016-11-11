package BitManipulation;

import java.util.Scanner;

/**
 *	Algorithms -> Bit Manipulation -> Sum vs XOR
 *	Easy
 */
public class SumVsXOR {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long n = in.nextLong();
		in.close();
		long c = 0;
		while(n > 0) {
			c += (n % 2 == 1) ? 0 : 1;
			n /= 2;
		}
		c = (long) Math.pow(2.0, c);
		System.out.println(c);
	}
	
	/*
	    long c = 0
		while(n){
		     c += n%2?0:1;
		     n/=2; 
		}
		c=pow(2,c);
	 */
}
