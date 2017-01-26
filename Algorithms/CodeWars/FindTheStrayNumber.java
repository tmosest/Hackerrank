package CodeWars;

import java.util.HashMap;

/**
 * Find the stray number
 * @author tmosest
 */
class Solution {
	static int stray(int[] numbers) {
		HashMap<Integer, Integer> numberCounts = new HashMap<Integer, Integer>();
		
		for(int i = 0; i < numbers.length; i++) {
			int number = numbers[i];
			int count = (numberCounts.get(number) == null) ? 0 : numberCounts.get(number);
			numberCounts.put(number, ++count);
		}
		
		for(int number : numberCounts.keySet()) {
			if(numberCounts.get(number) == 1) {
				return number;
			}
		}
		
		return -1;
	}
}
