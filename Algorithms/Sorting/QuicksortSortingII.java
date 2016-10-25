package Sorting;

import java.util.Scanner;

/**
 *	Algorithms -> Sorting -> Quicksort II Partition
 *	Easy
 */
public class QuicksortSortingII {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int i=0;i<n;i++){
           ar[i]=in.nextInt(); 
        }
        in.close();
        quickSort(ar);
	}
	
	static void quickSort(int[] ar) {
		
    }  
	
	static void printArray(int[] ar) {
		for(int n: ar){
			System.out.print(n+" ");
	    }
	    System.out.println("");
	}

}
