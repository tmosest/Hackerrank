package HackerEarth;

import java.util.Scanner;

/**
 * The Great Kian
 * Very Easy
 * @author tmosest
 *
 */
public class TheGreatKian {

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int[] arr = new int[n];
		
		for(int i = 0; i < n; i++)
			arr[i] = in.nextInt();
		
		in.close();
		
		long sum0 = 0, sum1 = 0, sum2 = 0;
		for(int i = 0; i < n; i++) {
			switch(i % 3) {
				case 0:
					sum0 += arr[i];
					break;
				case 1:
					sum1 += arr[i];
					break;
				case 2:
					sum2 += arr[i];
					break;
			}
		}
		System.out.println(sum0 + " " + sum1 + " " + sum2);
	}
	
}
