package Greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 *	Algorithms ->  Greedy -> Permuting Two Arrays
 *	Easy
 */
public class PermutingTwoArrays {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int tests = in.nextInt();
		
		for(int t = 0; t < tests; t++) {
			
			int arraySize = in.nextInt();
			int mustAddTo = in.nextInt();
			
			int[] array1 = new int[arraySize];
			int[] array2 = new int[arraySize];
			
			for(int i = 0; i < arraySize; i++)
				array1[i] = in.nextInt();
			
			for(int i = 0; i < arraySize; i++)
				array2[i] = in.nextInt();
			
			Arrays.sort(array1);
			Arrays.sort(array2);
			
			String ans = "YES";
			for(int i = 0; i < arraySize; i++) {
				System.out.println(array1[i] + array2[arraySize - 1 - i]);
				if(array1[i] + array2[arraySize - 1 - i] < mustAddTo) {
					ans = "NO";
					break;
				}
			}
			
			System.out.println(ans);
		}
		
		in.close();
	}

}
