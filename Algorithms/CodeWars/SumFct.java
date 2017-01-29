package CodeWars;

import java.math.BigInteger;

/**
 * Perimeter of squares in a rectangle
 * @author tmosest
 */
public class SumFct {
	
	private static final boolean debugMode = false;
	
	public static BigInteger perimeter(BigInteger n) {
		if(debugMode)
			System.out.println("n: " + n);
		
		BigInteger sum = new BigInteger("2");
		
		if(n.compareTo(sum) <= 0) 
			return BigInteger.ONE;
		
		BigInteger fib = BigInteger.ONE;
		BigInteger fib1 = BigInteger.ONE;
		BigInteger fib2 = BigInteger.ONE;
		BigInteger four = new BigInteger("4");
		
		for(BigInteger i = new BigInteger("2"); i.compareTo(n) <= 0; i = i.add(BigInteger.ONE)) {
			fib = fib2.add(fib1);
			fib1 = fib2;
			fib2 = fib;
			sum = sum.add(fib);
		}
		
		if(debugMode)
			System.out.println("sum: " + sum);
		
		return four.multiply(sum);
	}
}
