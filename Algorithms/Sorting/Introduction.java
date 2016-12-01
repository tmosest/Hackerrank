package Sorting;

import java.util.Scanner;

/**
 *	Algorithms -> Sorting -> Intro to Tutorial Challenges
 *	Easy
 */
public class Introduction {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int searchElement = in.nextInt();
		int arraySize = in.nextInt();
		int[] array = new int[arraySize];
		for(int i = 0; i < arraySize; i++) {
			array[i] = in.nextInt();
		}
		in.close();
		int index = indexOfSearchElement(array, searchElement);
		System.out.println(index);
	}

	public static int indexOfSearchElement(int[] array, int searchElement)
	{
		int index = 0;
		for(int i = 0; i < array.length; i++) {
			if(searchElement == array[i]) {
				index = i;
				break;
			}
		}
		return index;
	}
}
