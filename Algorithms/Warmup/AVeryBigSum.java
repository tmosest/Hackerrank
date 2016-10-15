package Warmup;

import java.util.Scanner;

/**
 *	Algorithms -> Warmup -> A Very Big Sum 
 *	Easy (Super Easy)
 */
public class AVeryBigSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for(int arr_i=0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        in.close();
        long total = sumArray(arr);
        System.out.println(total);
	}
	
	public static long sumArray(int[] array)
	{
		long sum = 0;
		for(int i = 0; i < array.length; i++) 
			sum += array[i];
		return sum;
	}

}
