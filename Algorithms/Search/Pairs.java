package Search;

import java.util.Arrays;
import java.util.Scanner;

/**
 *	Algorithms -> Search -> Pairs
 *	Medium
 */
public class Pairs {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int arraySize = in.nextInt();
		int difference = in.nextInt();
		
		int[] array = new int[arraySize];
		
		for(int i = 0; i < arraySize; i++) {
			array[i] = in.nextInt();
		}
		
		in.close();
		
		int count = countNumberOfElementsWithDifference(array, difference);
		System.out.println(count);
	}

	public static int countNumberOfElementsWithDifference(int[] array, int differenceNeeded) {
		Arrays.sort(array);
		
		int count = 0;
		
		for(int i = 0; i < array.length - 1; i++) {
			for(int j = i + 1; j < array.length; j++) {
				int differnce = array[j] - array[i];
				if(differnce == differenceNeeded) {
					count += 1;
				} else if(differnce > differenceNeeded) {
					break;
				}
			}
		}
		
		return count;
	}
	
}
