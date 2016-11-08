package Constructive;

import java.util.Scanner;

/**
 *	Algorithms -> Constructive Algorithms -> New Year Chaos 
 *	Medium
 *
 *	Sample Input:
 	2
	5
	2 1 5 3 4
	5
	2 5 1 3 4
 *
 *	Sample Output:
 	3
	Too chaotic
 *
 */
public class NewYearChaos {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int numTests = in.nextInt();
		for(int i = 0; i < numTests; i++) {
			int arraySize = in.nextInt();
			int[] array = new int[arraySize];
			for(int a_i = 0; a_i < arraySize; a_i++) {
				array[a_i] = in.nextInt();
			}
			calc(array);
		}
		in.close();
	}
	
	public static void calc(int[] q) 
	{
		int ans = 0;
		for(int i = q.length - 1; i >= 0; i--) {
			if (q[i] - (i + 1) > 2) {
				System.out.println("Too chaotic");
				return;
			}
			for (int j = Math.max(0, q[i] - 2); j < i; j++) {
				if (q[j] > q[i]) ans++;
			}
		}
		System.out.println(ans);
	}
}
