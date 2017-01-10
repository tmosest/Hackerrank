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
			BigInteger num = in.nextBigInteger();
			//long num = in.nextLong();
			System.out.println(greatXorCount(num));
		}
		
		in.close();
	}
	
	public static BigInteger greatXorCount(BigInteger num)
	{
		BigInteger count = BigInteger.ZERO;
		
		for(BigInteger i = BigInteger.ONE; i.compareTo(num) < 0; i = i.add(BigInteger.ONE)) {
			BigInteger xor = i.xor(num);
			if(xor.compareTo(num) > 0) count = count.add(BigInteger.ONE);
		}
		
		return count;
	}
	
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
