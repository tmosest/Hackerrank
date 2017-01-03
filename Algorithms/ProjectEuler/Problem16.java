package ProjectEuler;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Project Euler #16: Power digit sum
 * Easy
 */
public class Problem16 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int qs = in.nextInt();
		
		for(int q = 0; q < qs; q++) {
			int powerOfTwo = in.nextInt();
			System.out.println(sumDigitsOfPowerOfTwo(powerOfTwo));
		}
		
		in.close();
	}
	
	public static BigInteger sumDigitsOfPowerOfTwo(int power)
	{
		BigInteger sum = BigInteger.ZERO;
		
		BigInteger num = new BigInteger("2");
		
		num = num.pow(power);
		
		while(num.compareTo(BigInteger.ZERO) > 0) {
			sum = sum.add(num.mod(BigInteger.TEN));
			num = num.divide(BigInteger.TEN);
		}
		
		return sum;
	}
}
