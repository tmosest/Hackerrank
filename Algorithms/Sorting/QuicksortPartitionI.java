package Sorting;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *	Algorithms -> Sorting -> Quicksort I Partition
 *	Easy
 */
public class QuicksortPartitionI {
	
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int i=0;i<n;i++){
           ar[i]=in.nextInt(); 
        }
        in.close();
        partition(ar);
    }    
	
	static void partition(int[] ar) {
		int pivot = ar[0];
		ArrayList<Integer> left = new ArrayList<Integer>();
		ArrayList<Integer> right = new ArrayList<Integer>();
		for(int i = 1; i < ar.length; i++) {
			if(ar[i] > pivot) {
				right.add(ar[i]);
			} else {
				left.add(ar[i]);
			}
		}
		int i = 0;
		for(int j : left) {
			ar[i] = j;
			i++;
		}
		ar[i] = pivot;
		i++;
		for(int j : right) {
			ar[i] = j;
			i++;
		}
		printArray(ar);
    }   

	static void printArray(int[] ar) {
		for(int n: ar){
			System.out.print(n+" ");
	    }
		System.out.println("");
	}
}
