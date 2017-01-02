package HackerEarth;

import java.util.Scanner;

/**
 * Factorial!
 * Very-Easy
 * @author tmosest
 *
 */
public class Factorial {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		in.close();
		System.out.println(factorial(num));
	}
	
	public static int factorial(int n)
	{
		int res = 1;
		for(int i = 2; i <= n; i++)
			res *= i;
		return res;
	}
}
