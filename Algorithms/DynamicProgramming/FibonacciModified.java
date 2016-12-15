package DynamicProgramming;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *	Algorithms -> Dynamic Programming -> Fibonacci Modified
 *	Medium
 */
public class FibonacciModified {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
    	int a = in.nextInt();
    	int b = in.nextInt();
    	int n = in.nextInt();
    	in.close();
    	BigInteger r = calculateModifiedFib(a,b,n);
    	System.out.println(r);
    }
    
    public static BigInteger calculateModifiedFib(int a0, int a1, int n)
    {	
    	BigInteger s = BigInteger.valueOf(a1 * a1 + a0);
    	BigInteger t = BigInteger.valueOf(a1);
    	BigInteger r = BigInteger.valueOf(0);
    	for(int i = 2; i < n - 1; i++) {
    		r = s.multiply(s).add(t);
    		//System.out.println(r);
    		t = s;
    		s = r;
    	}
    	return r;
    }

}
