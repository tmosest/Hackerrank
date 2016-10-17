package Implementation;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *	Algorithms -> Implementations -> Almost Sorted
 *	Medium
 */
public class AlmostSorted {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int arraySize = in.nextInt();
		int[] array = new int[arraySize];
		for(int i = 0; i < arraySize; i++) {
			array[i] = in.nextInt();
		}
		solveAlmostSorted(array);
		in.close();
	}
	
	public static String[] solveAlmostSorted(int[] array)
	{
		String[] results = new String[2];
		int ups = 0;
		int dips = 0;
		ArrayList<Integer> indexes = new ArrayList<Integer>(){};
		if(array[0] > array[1]) {
			dips++;
			//System.out.println("Dip at: 1");
			indexes.add(1);
		} else if(array[0] < array[1]) {
			ups++;
			//System.out.println("Up at: 1");
			indexes.add(1);
		}
		for(int i = 1; i < array.length-1; i++) {
			int j = i + 1;
			if( array[i] > array[i + 1] && array[i] > array[i -1] ) {
				dips++;
				//System.out.println("Dip at: " + j);
				indexes.add(j);
			}
			if( array[i] < array[i + 1] && array[i] < array[i -1] ) {
				ups++;
				//System.out.println("Up at: " + j);
				indexes.add(j);
			}
		}
		if(array[array.length - 1] > array[array.length - 2]) {
			dips++;
			//System.out.println("Dip at: end");
			indexes.add(array.length - 1);
		} else if(array[array.length - 1] < array[array.length - 2]) {
			ups++;
			//System.out.println("Up at: end");
			indexes.add(array.length - 1);
		}
		
		//System.out.println("Dips: " + dips);
		//System.out.println("Ups: " + ups);
		
		int start = indexes.get(1);
		int end = indexes.get(indexes.size()-2);
		if(dips != ups || dips > 3 || ups > 3) {
			results[0] = "no";
		} else {
			results[0] = "yes";
			if(ups % 2 == 1) {
				if(array.length == 2) end = indexes.size();
				results[1] = "swap " + start + " " +  end;
			} else {
				if(end - start == 1) {
					results[1] = "swap " + start + " " + end;
				} else {
					results[1] = "reverse " + start + " " + end;
				}
			}
			if(array.length > 2 && results[1].contains("swap")) {
				boolean testSwap = 
						(array[end - 1] <= array[start]) &&
						(array[end - 1] >= array[start - 2]) &&
						(array[start - 1] <= array[end]) &&
						(array[start - 1] >= array[end - 2]) ;
				if(!testSwap) {
					results[0] = "no";
				} 
			}
		}
		System.out.println(results[0]);
		if(results[0].equals("yes")) System.out.println(results[1]);
		return results;
	}
}
