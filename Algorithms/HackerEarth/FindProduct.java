package HackerEarth;

import java.util.Scanner;

/**
 * Find Product
 * Very-Easy
 * @author tmosest
 *
 */
public class FindProduct {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		in.close();
		long mod = 1000000007;
		long product = 1;
		for(int i = 0; i < n; i++) {
			arr[i] %= mod;
			product *= arr[i];
			product %= mod;
		}
		System.out.println(product);
	}

}
