package BitManipulation;

import java.util.HashMap;
import java.util.Scanner;

/**
 *	Algorithms -> Bit Manipulation -> Lonely Integer
 *	Easy
 */
public class LonelyInteger {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		HashMap<Integer, Integer> numCount = new HashMap();
		
		int arraySize = in.nextInt();
		for(int i = 0; i < arraySize; i++) {
			int number = in.nextInt();
			int numberCount = (numCount.get(number) == null) ? 0 : numCount.get(number);
			numCount.put(number, ++numberCount);
		}
		
		for(int number : numCount.keySet()) {
			int count = numCount.get(number);
			if(count == 1) {
				System.out.println(number);
				break;
			}
		}
		
		in.close();
	}
	
}
