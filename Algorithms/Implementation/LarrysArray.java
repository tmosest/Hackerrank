package Implementation;

import java.util.Scanner;

/**
 *	Algorithms -> Implementations -> Larry's Array
 *	Medium
 *	Good Resource: https://www.cs.bham.ac.uk/~mdr/teaching/modules04/java2/TilesSolvability.html
 */
public class LarrysArray {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int cases = in.nextInt();
		for(int i = 0; i < cases; i++) {
			int arraySize = in.nextInt();
			int[] array = new int[arraySize];
			for(int a0 = 0; a0 < arraySize; a0++) {
				array[a0] = in.nextInt();
			}
			if(canLarrysArrayBeSorted(array)) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
		in.close();
	}
	
	// Users Tile Game Inversion Technique to solve.
	public static boolean canLarrysArrayBeSorted(int[] array)
	{
		int inversions = 0;
		for(int i = 0; i < array.length - 1; i++) {
			for(int j = i + 1; j < array.length; j ++) {
				if(array[i] > array[j]) inversions++;
			}
		}
		//System.out.println("Total Inversion: " + inversions);
		boolean result = false;
		if(inversions % 2 == 0) result = true;
		return result;
	}
}
