package HackerEarth;

import java.util.Scanner;

/**
 * Count Divisors
 * Very-Easy
 * @author tmosest
 *
 */
public class CountDivisors {
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int left = in.nextInt();
		int right = in.nextInt();
		int k = in.nextInt();
		in.close();
		int count = 0;
		for(int i = left; i <= right; i++)
			if(i % k == 0) count++;
		System.out.println(count);
	}
	
}
