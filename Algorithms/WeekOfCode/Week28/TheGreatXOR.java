package WeekOfCode.Week28;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *	Algorithms -> Week of Code 28 -> The Great XOR
 *	Easy
 */
public class TheGreatXOR {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int qs = in.nextInt();
		
		for(int q = 0; q < qs; q++) {
			//BigInteger num = in.nextBigInteger();
			long num = in.nextLong();
			System.out.println(greatXorCountConst(num));
		}
		
		in.close();
		
		/*
		for(int i = 1; i < 100; i++) {
			System.out.println("i: " + i + " count : " + greatXorCountConst(i) + " pow 2: " + largestPowerOf2(i));
		}
		*/
	}
	
	/**
	 * Function to return the largest Power Of 2 that is less than a number
	 * @param n
	 * @return
	 */
	public static long largestPowerOf2(long n) {
	    return (long) Math.pow(2, Math.floor(Math.log(n) / Math.log(2)));
	}
	
	/**
	 * Determines the great XOR count using long in constant time.
	 * @param num
	 * @return
	 */
	public static long greatXorCountConst(long num)
	{
		long count = 0;
		
		long powerOfTwo = largestPowerOf2(num);
		
		if(num == powerOfTwo)
			return num - 1;
		
		
		return 2 * powerOfTwo - 1 - num;
	}
	
	public static BigInteger largestPowerOf2(BigInteger n)
	{
		
	}
	
	/**
	 * Determines the great XOR count using BigInteger in linear time.
	 * @param num
	 * @return
	 */
	public static BigInteger greatXorCount(BigInteger num)
	{
		BigInteger count = BigInteger.ZERO;
		
		for(BigInteger i = BigInteger.ONE; i.compareTo(num) < 0; i = i.add(BigInteger.ONE)) {
			BigInteger xor = i.xor(num);
			if(xor.compareTo(num) > 0) count = count.add(BigInteger.ONE);
		}
		
		return count;
	}
	
	/**
	 * Determines the great XOR count using long in linear time.
	 * @param num
	 * @return
	 */
	public static long greatXorCount(long num)
	{
		long count = 0;
		
		for(long i = 1; i < num; i++) {
			long xor = i ^ num;
			if(xor > num) count++;
		}
		
		return count;
	}
}
