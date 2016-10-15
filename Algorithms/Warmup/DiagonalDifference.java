package Warmup;

import java.util.Scanner;
/**
 *	Algorithms -> Warmup -> Diagonal Difference 
 *	Easy (Super Easy)
 */
public class DiagonalDifference {

	public static void main(String[] args) {
		 Scanner in = new Scanner(System.in);
	     int n = in.nextInt();
	     int a[][] = new int[n][n];
	     for(int a_i=0; a_i < n; a_i++){
	    	 for(int a_j=0; a_j < n; a_j++){
	            a[a_i][a_j] = in.nextInt();
	         }
	     }
	     in.close();
	     int diagnolDifference = computeDiagnolDifference(a);
	     System.out.println(diagnolDifference);
	}
	
	public static int computeDiagnolDifference(int a[][])
	{
		int primaryDiagnolSum = 0;
        int secondaryDiagnolSum = 0;
        int n = a.length;
		for(int a_i=0; a_i < n; a_i++){
            for(int a_j=0; a_j < n; a_j++){
                if(a_i == a_j) primaryDiagnolSum += a[a_i][a_j];
                if( (a_i + a_j) == ( n - 1) ) secondaryDiagnolSum += a[a_i][a_j];
            }
        }
        int diagnolDifference = Math.abs(primaryDiagnolSum - secondaryDiagnolSum);
		return diagnolDifference;
	}
}
