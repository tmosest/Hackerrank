package Implementation;

import java.util.HashMap;
import java.util.Scanner;

/**
 *	Algorithms -> Implementations -> Equalize the Array
 *	Easy
 */
public class EqualizeTheArray {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int max, arraySize;
		arraySize = in.nextInt();
		
		HashMap<Integer, Integer> numbersCount = new HashMap<Integer, Integer>();
		
		int maxCount = 0;
		int maxNumber = 0;
		
		for(int i = 0; i < arraySize; i++) {
			int number = in.nextInt();
			int numberCount = (numbersCount.get(number) == null) ? 0 : numbersCount.get(number);
			++numberCount;
			if(numberCount > maxCount) {
				maxCount = numberCount;
				maxNumber = number;
			}
			numbersCount.put(number, numberCount);
		}
		
		in.close();
		
		int count = 0;
		for(int num : numbersCount.keySet()) {
			if(num != maxNumber) {
				count += numbersCount.get(num);
			}
		}
		
		System.out.println(count);
	}

}
