package OneOOne.Hack44;

import java.util.Arrays;
import java.util.Scanner;

public class PickingNumbers {

	private static boolean debugMode = false;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		
		int[] arr = new int[n];
		
		for(int i = 0; i < n; i++)
			arr[i] = in.nextInt();
		
		in.close();
		
		Arrays.sort(arr);
		
		int i = 0;
		int j = 1;
		int count = 1;
		int maxcount = 1;
		
		while(j < arr.length) {
			
			//Check to see if the difference between two elements is 1
			int difference = Math.abs(arr[i] - arr[j]);
			
			if(debugMode)
				System.out.println("i: " + i + " j: " + j + " diff: " + difference);
			
			if(difference > 1) {
				i++;
				j = i + 1;
				count = 1;
			} else {
				j++;
				count++;
				if(count > maxcount) maxcount = count;
			}
		}
				
		System.out.println(maxcount);
	}

}
