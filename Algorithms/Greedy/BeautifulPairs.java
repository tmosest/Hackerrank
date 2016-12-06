package Greedy;

import java.util.HashMap;
import java.util.Scanner;

/**
 *	Algorithms ->  Greedy -> Beautiful Pairs
 *	Easy
 */
public class BeautifulPairs {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int arraySize = in.nextInt();
		
		HashMap<Integer, Integer> arry1Count = new HashMap<Integer, Integer>();
		
		for(int i =0; i < arraySize; i++) {
			int input = in.nextInt();
			int count = (arry1Count.get(input) == null) ? 0 : arry1Count.get(input);
			arry1Count.put(input, ++count);
		}
		
		HashMap<Integer, Integer> arry2Count = new HashMap<Integer, Integer>();
		
		for(int i =0; i < arraySize; i++) {
			int input = in.nextInt();
			int count = (arry2Count.get(input) == null) ? 0 : arry2Count.get(input);
			arry2Count.put(input, ++count);
		}
		
		in.close();
		
		int k = 0;
		
		for(int number: arry1Count.keySet()) {
			for(int i = 0; i < arry1Count.get(number); i++) {
				int count = (arry2Count.get(number) == null) ? 0 : arry2Count.get(number);
				if(count != 0) {
					arry2Count.put(number, --count);
					++k;
				}
			}
		}
		
		if(k < arraySize) {
			k = k + 1;
		} else {
			k = arraySize - 1;
		}
	
		System.out.println(k);
	}

}
