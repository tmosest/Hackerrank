package Sorting;

import java.util.Scanner;

/**
 *	Algorithms -> Sorting -> Quicksort In-Place
 *	Easy
 */
public class QuicksortInPlace {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int i=0;i<n;i++){
           ar[i]=in.nextInt(); 
        }
        in.close();
        sort(ar, 0 , ar.length-1);
	}
	
	static void sort(int a[], int left, int right)   
	{  
		if (right > left) {
			
		    int i=left, j=right, tmp;    
		    //we want j to be right, not right-1 since that leaves out a number during recursion
	
		    int v = a[right]; //pivot
		    do {
		        while(a[i]<v)
		          i++;
		        while(a[j]>v) 
		        //no need to check for 0, the right condition for recursion is the 2 if statements below.
		          j--;
		        if( i <= j){            //your code was i<j
		        	tmp = a[i];
			        a[i] = a[j];
			        a[j] = tmp;
			        i++;            
			        j--;
			        //we need to +/- both i,j, else it will stick at 0 or be same number
			   }
		    } while(i <= j);           //your code was i<j, hence infinite loop on 0 case
			//you had a swap here, I don't think it's needed.
			//this is the 2 conditions we need to avoid infinite loops
			// check if left < j, if it isn't, it's already sorted. Done
	
			if(left < j)  sort(a,left,j);
			//check if i is less than right, if it isn't it's already sorted. Done
			// here i is now the 'middle index', the slice for divide and conquer.
	
			if(i < right) sort(a,i,right);
			
		}
	}
	
	static void printArray(int[] ar) {
		for(int n: ar){
			System.out.print(n+" ");
	    }
		System.out.println("");
	}

}
