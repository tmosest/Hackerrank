package Implementation;

import java.util.Scanner;

/**
 *	Algorithms -> Implementations -> Divisible Sum Pairs
 *	Easy
 *	Don't fully understand this one.
 */
public class NonDivisibleSubset {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); 
        int n = scan.nextInt(); 
        int k = scan.nextInt(); 
        int[] arr = new int[n]; 
        for (int i = 0; i < n; ++i){ 
            arr[i] = scan.nextInt(); 
        }
        scan.close();
        int[] cnts = new int[k]; 
        for (int i = 0; i < k; ++i){ 
            cnts[i] = 0; 
        } 
        for (int i = 0; i < n; ++i){ 
            cnts[arr[i] % k] += 1; 
        } 
        int cnt = cnts[0] < 1 ? cnts[0] : 1; 
        for (int i = 1; i < k/2+1; ++i){ 
            if (i != k - i){
                cnt += cnts[i] > cnts[k-i] ? cnts[i] : cnts[k-i];
            }
        } 
        if (k % 2 == 0){ 
            cnt += 1; 
        } 
        System.out.println(cnt);
	}

}
