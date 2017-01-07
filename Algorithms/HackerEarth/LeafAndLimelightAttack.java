package HackerEarth;

import java.util.Scanner;

/**
 * Leaf and Limelight Attack
 * Algorithms  Dynamic Programming  Introduction to Dynamic Programming 1
 * Easy
 * @author tmosest
 *
 */
public class LeafAndLimelightAttack {
	
	private static long mod = (long) Math.pow(10, 9) + 9;
	private static int limit = (int) Math.pow(10, 7);
	private static long[] sumOfDiagnols = new long[limit + 1];
	
	public static void main(String[] args)
	{
		fillDiagnol();
		Scanner in = new Scanner(System.in);
		
		int qs = in.nextInt();
		
		for(int q = 0; q < qs; q++) {
			int n = in.nextInt();
			System.out.println(sumOfDiagnols[n]);
		}
		
		in.close();
	}
	
	private static void fillDiagnol()
	{
		sumOfDiagnols[0] = 0;
		sumOfDiagnols[1] = 1;
		sumOfDiagnols[2] = 10;
		for(int i = 3; i <= limit; i++) {
			sumOfDiagnols[i] = ((sumOfOutsideLayer(i) % mod) + (sumOfDiagnols[i - 2] % mod)) % mod;
		}
	}
	
	private static long sumDiagnols(int n)
	{
		if(n == 0)
			return 0;
		else if(n == 1)
			return 1;
		else if(n == 2) {
			System.out.println(2);
			return 10;
		}
		else if(sumOfDiagnols[n] != 0)
			return sumOfDiagnols[n];
		else {
			sumOfDiagnols[n] = ((sumOfOutsideLayer(n) % mod) + (sumDiagnols(n - 2) % mod)) % mod;
			return sumOfDiagnols[n];
		}	
	}
	
	private static long sumOfOutsideLayer(int n)
	{
		long sum = 0;
		long n2 = ((n % mod) * (n % mod)) % mod;
		for(int i = 0; i < 4; i++) {
			sum += (n2 - (((n - 1) % mod) * i) % mod) % mod;
			//System.out.println(sum);
		}
		return sum;
	}
}
