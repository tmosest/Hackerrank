package Greedy;

import java.util.Scanner;

/**
 *	Algorithms ->  Greedy -> Largest Permutation
 *	Easy
 */
public class LargestPermutation {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
	    int k = in.nextInt();
	    int[] a = new int[n];
	    int[] index = new int[n + 1];

	    for (int i = 0; i < n; i++) {
	        a[i] = in.nextInt();
	        index[a[i]] = i;
	    }
	    
		in.close();
		
		for (int i = 0; i < n && k > 0; i++) {
	        if (a[i] == n - i) {
	            continue;
	        }
	        a[index[n - i]] = a[i];
	        index[a[i]] = index[n - i];
	        a[i] = n - i;
	        index[n - i] = i;
	        k--; 
	    }
		
	    for (int i = 0; i < n; i++) {
	        System.out.print(a[i] + " ");
	    }
	}

}
