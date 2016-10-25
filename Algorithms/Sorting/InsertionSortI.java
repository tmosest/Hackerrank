package Sorting;

import java.util.Scanner;

public class InsertionSortI {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int[] ar = new int[s];
        for(int i=0;i<s;i++){
            ar[i]=in.nextInt(); 
        }
        in.close();
        insertIntoSorted(ar);
	}
	
	public static void insertIntoSorted(int[] ar) {
        int holder = ar.length - 1;
        int e = ar[holder];
        //System.out.println(e);
        boolean isSorted = false;
        for(int i = holder; i >= 0; i--) {
        	int d = ar[0];
        	if(i > 0) d = ar[i-1];
        	int[] sortingArray = new int[ar.length];
        	for(int j = 0; j < ar.length; j++) {
        		if(j < i) sortingArray[j] = ar[j];
        		if(i == j) {
        			//System.out.println(d);
        			if(d > e) {
        				sortingArray[j] = d;
        			} else {
        				sortingArray[j] = e;
        				isSorted = true;
        			}
        		}
        		if(i==0 && j==0) sortingArray[j] = e;
        		if(j > i) {
        			sortingArray[j] =  ar[j-1]; 
        		}
        	}
        	printArray(sortingArray);
        	if(isSorted) break;
        }
    }
	
	 private static void printArray(int[] ar) {
		 for(int n: ar){
			 System.out.print(n+" ");
	     }
	     System.out.println("");
	 }
	
}

