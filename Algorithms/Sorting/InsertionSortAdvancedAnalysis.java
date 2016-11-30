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
        
        debugMode = true;
        
		Scanner in = new Scanner(System.in);
		
		int numberOfCases = in.nextInt();
		
		for(int t = 0; t < numberOfCases; t++) {
			
			int arraySize = in.nextInt();
			int[] array = new int[arraySize];
            
            for(int i = 0; i < arraySize; i++) {
                array[i] = in.nextInt();
            }
            
			count = 0;
			m_sort(array, 0, array.length - 1);
			System.out.println(count);
			
		}
		
		in.close();
	}
	
	public static void merge(int[] a, int i, int j)
	{
		int ni = ((i + j) / 2) + 1;
		int nj = j + 1;
		int s = 1;
		
        if(debugMode) {
            System.out.println("ni " + ni);
            System.out.println("nj " + nj);
        }
        
		int arr[] = new int[nj];
		
		j = ni;
		
		int k = 0;
		
		while(i < ni && j < nj) {
            if(debugMode)
			 System.out.println("a[" + i + "] " + a[i] + " a[" + j + "] " + a[j]);
			if(a[i] <= a[j]) {
	            arr[k] = a[i];
                if(debugMode)
			      System.out.println("arr[" + k + "]  = " + a[k]);
	            i++;
	        }
	        else {
	            arr[k] = a[j];
	            count += (ni - i);
                if(debugMode)
                    System.out.println("count: " + count);
	            j++;
	        }
	        k++;
	        
		} //end while
		
		for( ; i < ni; i++ , k++) {
	        arr[k] = a[i];
		}
	    
		for( ; j < nj; j++, k++) {
	        arr[k] = a[j];
		}
		
	    for(k = 0; s < nj; s++, k++) {
	        a[s] = arr[k];
            if(debugMode)
                System.out.println("a[" + s +"] = " + a[s]);
	    }
	}// end void merge
	
	public static void m_sort(int[] a, int i, int j)
	{
		if(i < j) {
	        m_sort(a, i, (i + j)/2);
	        m_sort(a, ((i + j) / 2) + 1, j);
	        merge(a,i,j);
	    }
	}
}

