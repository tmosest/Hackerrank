package HackerEarth;

import java.util.Arrays;
import java.util.Scanner;

/**
 * TEST YOUR UNDERSTANDING
 * Algorithms  Searching  Binary Search
 * Very Easy
 * https://research.googleblog.com/2006/06/extra-extra-read-all-about-it-nearly.html
 * @author tmosest
 *
 */
public class BinarySearch {
	
	private static final boolean debugMode = false;
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		
		int[] array = new int[n];
		
		for(int i = 0; i < n; i++) {
			array[i] = in.nextInt();
		}
		
		Arrays.sort(array);
		
		int q = in.nextInt();
		
		for(int i = 0; i < q; i++) {
			int key = in.nextInt();
			System.out.println(binarySearch(array, key) + 1);
		}
		
		in.close();
	}
	
	public static int binarySearch(int[] array, int key)
	{
		int low = 0, high = array.length - 1;
		
		while(low <= high) {
			//int mid = (low + high) / 2;
			int mid = low + ((high - low) / 2);
			
			if(debugMode)
				System.out.println("mid: " + mid);
			
			int midVal = array[mid];
			
			if(midVal < key)
				low = mid + 1;
			else if(midVal > key)
				high = mid - 1;
			else
				return mid;
		}
		return -1;
 	}
}
