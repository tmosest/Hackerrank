package Constructive;

import java.util.Scanner;

/**
 *	Algorithms -> Constructive Algorithms -> Flipping the Matrix 
 *	Medium
 *
 *	Sample Input:
 	1
	2
	112 42 83 119
	56 125 56 49
	15 78 101 43
	62 98 114 108
 *
 *	Sample Output:
 	414
 *
 */
public class FlippingTheMatrix {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int testCases = in.nextInt();
		
		for(int t = 0; t < testCases; t++) {
			int n = in.nextInt();
			
			int[][] arr = new int[2*n][2*n];
            for(int i=0;i<2*n;i++){
                for(int j=0;j<2*n;j++){
                    arr[i][j] = in.nextInt();
                }
            }
			
			int sum = 0;
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					sum += Math.max(
								Math.max(
									Math.max( arr[i][j], arr[i][2*n-j-1] ) , 
								arr[2*n-i-1][j]) ,
							arr[2*n-i-1][2*n-j-1]);
				}
			}
			
			System.out.println(sum);
		}
		
		in.close();
	}

}
