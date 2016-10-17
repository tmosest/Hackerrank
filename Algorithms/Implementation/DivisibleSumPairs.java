package Implementation;

import java.util.Scanner;

/**
 *	Algorithms -> Implementations -> Divisible Sum Pairs
 *	Easy (Super Easy)
 */
public class DivisibleSumPairs {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        in.close();
        int result = calculateNumberOfDivisiblePais(a, k);
        System.out.print(result);
	}
	
	public static int calculateNumberOfDivisiblePais(int[] a, int k)
	{
		int divisiblePairs = 0;
		int mod[] = new int[k];
        for(int a_i=0; a_i < a.length; a_i++){
            a[a_i] = a[a_i]%k;
            mod[a[a_i]] += 1;
        }
        divisiblePairs += (mod[0] * (mod[0] - 1))/2;
        for(int i = 1; i<= k/2 && i != k-i; i++) {
        	divisiblePairs += mod[i]*mod[k-i];
        }
        if(k%2 == 0) {
        	divisiblePairs += (mod[k/2] * (mod[k/2] - 1))/2;
        }
		return divisiblePairs;
	}

}
