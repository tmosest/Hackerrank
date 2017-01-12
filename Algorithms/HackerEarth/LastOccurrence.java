package HackerEarth;

import java.util.Scanner;

/**
 * Last Occurrence
 * Algorithms  Searching  Linear Search
 * Easy
 * @author tmosest
 *
 */
public class LastOccurrence {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int m = in.nextInt();
		
		int[] array = new int[n];
		
		for(int i = 0; i < n; i++)
			array[i] = in.nextInt();
		
		System.out.println(returnLastOccurence(array, m));
		
		in.close();
	}

	private static int returnLastOccurence(int[] array, int find)
	{
		for(int i = array.length - 1; i >= 0; i--) {
			if(array[i] == find)
				return i + 1;
		}
		return -1; // return -1 if not found.
	}
}
