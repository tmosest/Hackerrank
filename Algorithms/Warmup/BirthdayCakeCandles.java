package Warmup;

import java.util.Arrays;
import java.util.Scanner;

/**
 *	Algorithms -> Warmup -> A Very Big Sum 
 *	Easy (Super Easy)
 */
public class BirthdayCakeCandles {
	
	private static int birthdayCakeCandles(int n, int[] ar) {
		int count = 0;
		// This step could take a long time.
        Arrays.sort(ar);
        int longest = ar[ar.length - 1];
        for(int i = 0; i < ar.length; i++) {
        	if(ar[i] == longest) ++count;
        }
		return count;
    }
	
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int result = birthdayCakeCandles(n, ar);
        System.out.println(result);
    }
}