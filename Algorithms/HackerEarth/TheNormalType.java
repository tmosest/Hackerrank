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
		
		for(int i = 0; i < size; i++) {
			array[i] = in.nextInt();
		}
		
		in.close();
		
		HashSet<String> distinctSubArrays = new HashSet<String>();
		
		for(int i = 0; i < size; i++) {
			for(int j = i; j < size; j++) {
				int[] a = new int[j - i + 1];
				for(int k = i, l = 0; k <= j; k++, l++) {
					a[l] = array[k];
				}
				Arrays.sort(a);
				distinctSubArrays.add(Arrays.toString(a));
				if(debugMode) {
					System.out.println(Arrays.toString(a));
				}
			}
		}
		
		if(debugMode)
			for(String s : distinctSubArrays)
				System.out.println(s);
		
		System.out.println(distinctSubArrays.size() - 1);
	}
	
	private static void printArray(int[] a) {
		for(int i = 0; i < a.length; i++) {
			System.out.print(a[i]);
		}
		System.out.println("");
	}
}
