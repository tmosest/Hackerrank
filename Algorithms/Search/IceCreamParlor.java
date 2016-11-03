package Search;

import java.util.Scanner;

/**
 *	Algorithms -> Search -> Ice Cream Parlor
 *	Easy
 *
 * Sample Input:
    2
	4
	5
	1 4 5 3 2
	4
	4
	2 2 4 3
 *
 * Sample Output:
    1 4
	1 2
 */
public class IceCreamParlor {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int numCases = in.nextInt();
		for(int i = 0; i < numCases; i++) {
			int money = in.nextInt();
			int arraySize = in.nextInt();
			int[] array = new int[arraySize];
			for(int a_i = 0; a_i < arraySize; a_i++) {
				array[a_i] = in.nextInt();
			}
			int[] indexs = determineWhichIceCreamsTheyCanBuy(array, money);
			printArray(indexs);
		}
		
		in.close();
	}

	public static int[] determineWhichIceCreamsTheyCanBuy(int[] array, int money) 
	{
		int[] indexes = new int[2];
		
		for(int i = 0; i < array.length - 1; i++) {
			for(int j = i + 1; j < array.length; j++) {
				if( (array[i] + array[j]) == money ) {
					indexes[0] = i + 1;
					indexes[1] = j + 1;
				}
			}
		}
		
		return indexes;
	}
	
	public static void printArray(int[] array) 
	{
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println("");
	}
}
