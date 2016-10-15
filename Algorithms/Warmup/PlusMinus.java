package Warmup;

import java.util.Scanner;

/**
 *	Algorithms -> Warmup -> Plus Minus
 *	Easy (Super Easy)
 */
public class PlusMinus {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for(int arr_i=0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        in.close();
        double[] r = caclulatePlusMinus(arr);
        System.out.println(r[0]);
        System.out.println(r[1]);
        System.out.println(r[2]);
	}
	
	public static double[] caclulatePlusMinus(int[] arr) {
		double posCount = 0.0;
        double negCount = 0.0;
        double zeroCount = 0.0;
        int n = arr.length;
		for(int arr_i=0; arr_i < n; arr_i++){
            if(arr[arr_i] == 0) zeroCount++;
            if(arr[arr_i] > 0) posCount++;
            if(arr[arr_i] < 0) negCount++;
        }
		double[] r = {posCount/n, negCount/n, zeroCount/n};
		return r;
	}

}
