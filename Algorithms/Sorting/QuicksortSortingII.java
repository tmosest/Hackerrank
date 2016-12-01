package Sorting;

import java.util.ArrayList;
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
	
	static void quickSort(int ar[], int minpos, int maxpos) 
	{
		if(minpos >= maxpos) 
			return;

	    int pos = partition (ar,minpos,maxpos);

	    quickSort(ar,minpos,pos-1);
	    quickSort(ar,pos+1,maxpos);

	    printArray(ar,minpos, maxpos);
	}
	
	static void quickSort(int[] ar) 
    {
        quickSort(ar,0,ar.length-1);
    } 
	
	static void printArray(int[] ar,int start, int end) 
	{ 
		for(int i = start; i <= end;i++) { 
			System.out.print(ar[i]+" "); 
		} 
		System.out.println(""); 
	}
	
	static int partition(int ar[], int minpos, int maxpos)
	{ 
		int p = ar[minpos];
	    ArrayList<Integer> leftlist = new ArrayList<Integer>();
	    ArrayList<Integer> rightlist = new ArrayList<Integer>();

	    for(int i = minpos+1 ; i <= maxpos; i++) {
	    	if(ar[i] > p) {
	    		rightlist.add(ar[i]);
	    	} else {
	    		leftlist.add(ar[i]);
	    	}
	    }
	    copy(leftlist,ar,minpos);
	    int ppos = leftlist.size()+minpos;
	    ar[ppos] = p;
	    copy(rightlist,ar,ppos+1);

	    return minpos + leftlist.size();
	}
	
	static void copy(ArrayList<Integer> list, int ar[], int startIdx)
    {
		for(int num : list) {
			ar[startIdx++] = num;      
        }
    }

	
}
