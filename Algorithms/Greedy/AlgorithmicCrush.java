package Greedy;

import java.util.Scanner;

/**
 *	Algorithms ->  Greedy -> Algorithmic Crush
 *	Hard
 */
public class AlgorithmicCrush {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int arraySize = in.nextInt();
		
		long k = in.nextLong();
		
		long[] sums = new long[arraySize + 1];
		
		for(int i = 0; i < k; i++) {
			int p = in.nextInt();
			int q = in.nextInt();
			long sum = in.nextLong();
			
			sums[p] += sum;
			if(q + 1 <= arraySize) sums[q + 1] -= sum;
		}
		
		in.close();
		
		long max = 0;
		long x = 0;
		
		for(int i = 1; i <= arraySize; i++) {
			x= x + sums[i];
		    if(max < x) max=x;
		}
		
		System.out.println(max);
	}

}
