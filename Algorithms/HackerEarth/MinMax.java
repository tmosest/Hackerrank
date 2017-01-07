package HackerEarth;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Min-Max
 * Very-Easy
 * @author tmosest
 *
 */
public class MinMax {
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int[] a = new int[n];
		
		for(int i = 0; i < n; i++) {
			a[i] = in.nextInt();
		}
		
		in.close();
		
		String result = "NO";
		if(containsMinToMax(a)) result = "YES";
		System.out.println(result);
	}
	
	public static boolean containsMinToMax(int[] array)
	{
		Arrays.sort(array);
		int min = array[0];
		for(int i = 1; i < array.length; i++) {
			if(array[i] != min)
				min++;
			if(array[i] != min) 
				return false;
		}
		return true;
	}
}
