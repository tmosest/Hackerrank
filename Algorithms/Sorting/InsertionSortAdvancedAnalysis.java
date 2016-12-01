package Sorting;

import java.util.Scanner;

/**
 *	Algorithms -> Sorting -> Insertion Sort Advanced Analysis
 *	Advanced
 */
public class InsertionSortAdvancedAnalysis {
	
	public static long count = 0;
	public static boolean debugMode;
    
	public static void main(String[] args) {
        
        debugMode = false;
        
		Scanner in = new Scanner(System.in);
		
		int numberOfCases = in.nextInt();
		
		for(int t = 0; t < numberOfCases; t++) {
			
			int arraySize = in.nextInt();
			int[] array = new int[arraySize];
            
            for(int i = 0; i < arraySize; i++) {
                array[i] = in.nextInt();
            }
            
			count = 0;
			count = inversions(array);
			System.out.println(count);
			
		}
		
		in.close();
	}
	
	public static int inversions(int [] arr) {
		int ans = 0;
		
		int n = arr.length;
		
		if(n == 1)
			return 0;
		
		int n1 = n /2;
		int n2 = n - n1;
		
		int[] arr1 = new int[n1];
		
		for(int i = 0; i < n1; i++) {
			arr1[i] = arr[i];
			if(debugMode) 
				System.out.print(arr1[i] + " ");
		}
		
		if(debugMode) 
			System.out.println("");
		
		int[] arr2 = new int[n2];
		
		for(int i = 0; i < n2; i++) {
			arr2[i] = arr[n1 + i];
			if(debugMode) 
				System.out.print(arr2[i] + " ");
		}
		
		if(debugMode) 
			System.out.println("");
		
		ans = inversions(arr1) + inversions(arr2);
		
		int i1 = 0;
		int i2 = 0;
		
		for(int i = 0; i < n; i++) {
			if(i1 < n1 && ( i2 >= n2 || arr1[i1] <=arr2 [i2])) {
	            arr[i] = arr1[i1];
	            ans += i2;
	            i1 += 1;
			} else if(i2 < n2) {
	            arr[i] = arr2[i2];
	            i2 += 1;
			}
		}
		
		return ans;
	}
}

