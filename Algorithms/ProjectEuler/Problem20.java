package ProjectEuler;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Project Euler #20: Factorial digit sum
 * Easy
 */
public class Problem20 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int qs = in.nextInt();
		
		for(int q = 0; q < qs; q++) {
			System.out.println(digitSum(factorial(in.nextInt())));
		}
		
		in.close();
	}
	
	public static BigInteger factorial(int number)
	{
		BigInteger res = BigInteger.ONE;
		
		for(int i = 2; i <= number; i++) {
			res = res.multiply(new BigInteger(String.valueOf(i)));
		}
		
		return res;
	}
	
	public static BigInteger digitSum(BigInteger num)
	{
		BigInteger sum = BigInteger.ZERO;
		while(num.compareTo(BigInteger.ZERO) > 0) {
			sum = sum.add(num.mod(BigInteger.TEN));
			num = num.divide(BigInteger.TEN);
		}
		return sum;
	}

}
