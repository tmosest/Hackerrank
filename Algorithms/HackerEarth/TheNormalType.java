package HackerEarth;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * The Normal Type
 * Algorithms  Searching  Linear Search
 * Medium
 * @author tmosest
 *
 */
public class TheNormalType {

	private static boolean debugMode = false;
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		int size = in.nextInt();
		
		int[] array = new int[size];
		
		HashSet<Integer> distinctElements = new HashSet<Integer>();
		int count = 0, numberOfDistinct = 0;
		
		for(int i = 0; i < size; i++) {
			array[i] = in.nextInt();
			distinctElements.add(array[i]);
		}
		
		in.close();
		
		numberOfDistinct = distinctElements.size();
		
		for(int i = 0; i < size; i++) {
			for(int j = i; j < size; j++) {
				int[] a = new int[j - i + 1];
				distinctElements = new HashSet<Integer>();
				for(int k = i, l = 0; k <= j; k++, l++) {
					a[l] = array[k];
					distinctElements.add(a[l]);
				}
				if(distinctElements.size() == numberOfDistinct)
					count++;
			}
		}
		
		System.out.println(count);
	}
	
	private static void printArray(int[] a) {
		for(int i = 0; i < a.length; i++) {
			System.out.print(a[i]);
		}
		System.out.println("");
	}
}
