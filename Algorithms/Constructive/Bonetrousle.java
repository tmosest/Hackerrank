package Constructive;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *	Algorithms -> Constructive Algorithms -> Bonetrousle 
 *	Medium
 *  This isn't finished
 */
public class Bonetrousle {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int tc, b;
		BigInteger n, k, tmin, tmax, sum, mxset;
		
		tc = in.nextInt();
		
		for(int t = 0; t < tc; t++) {
			b = in.nextInt();
			n = in.nextBigInteger();
			k = in.nextBigInteger();
			
			tmin = BigInteger.ZERO;
			tmax = BigInteger.ZERO;
			/*
			for(int i = 0; i < b; i++) {
				tmin += i+1;
				tmin.add(new BigInteger(i + 1));
			}
			
			for (int i = 0; i < b; i++) {
	            tmax += k-i;
	            if (tmax >= n) break;
	        }
	        */
		}
		
		in.close();
	}

}
