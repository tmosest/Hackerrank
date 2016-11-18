package Sorting;

import java.util.Scanner;

public class RunningTimeOfQuicksort {
	public static int quickSortCount = 0;
	public static int insertionSortCount = 0;
	
	public static int[] quickSort;
	public static int[] insSort;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int arraySize = in.nextInt();
		quickSort = new int[arraySize];
		insSort = new int[arraySize];
		
		for(int i = 0; i < arraySize; i++) {
			quickSort[i] = in.nextInt();
			insSort[i] = quickSort[i];
		}
		
		in.close();
		quick(0 , quickSort.length-1);
		insertIntoSortedMoves(insSort);
		//System.out.println("quickSortCount: " + quickSortCount);
		//System.out.println("insertionSortCount: " + insertionSortCount);
		System.out.println(insertionSortCount - quickSortCount);
	}
	
	public static void insertIntoSortedMoves(int[] ar) {
		for(int i = 1; i < ar.length; i++) {
			int j = i;
			while(j > 0 && ar[j] < ar[j-1]) {
				int holder = ar[j];
				ar[j] = ar[j-1];
				ar[j-1] = holder;
				j--;
				insertionSortCount++;
			}
		}
    }
	
	static void quick(int l, int h){
	    if(h-l<=0) {
	        return;
	    }
	    if(h-l == 1){
	        if(quickSort[h]<quickSort[l])
	            swap(l,h);
	        return;
	    }
	    int p = quickSort[h];
	    int q = l;
	    for(int i = l; i < h; i++){
	        if(quickSort[i] < p){
	            if(i > q){
	                swap(i,q);
	                q++;
	            }else if(i == q){
	                q++;
	                quickSortCount++;
	            }
	        }
	    }
	    swap(q,h);
	    quick(l,q-1);
	    quick(q+1,h);
	}
	
	static void swap(int x, int y){
	    int temp = quickSort[x];
	    quickSort[x] = quickSort[y];
	    quickSort[y] = temp;
	    quickSortCount++;
	}
}
