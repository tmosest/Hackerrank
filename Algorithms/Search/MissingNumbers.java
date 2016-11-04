package Search;

import java.util.Scanner;
import java.util.TreeMap;


/**
 *	Algorithms -> Search -> Missing Numbers
 *	Easy
 *
 * Sample Input:
    10
	203 204 205 206 207 208 203 204 205 206
	13
	203 204 204 205 206 207 205 208 203 206 205 206 204
 *
 * Sample Output:
    204 205 206
 */
public class MissingNumbers {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int arraySize = in.nextInt();
		
		TreeMap<Integer, Integer> numberCount = new TreeMap<Integer, Integer>();
		
		for(int i = 0; i < arraySize; i++) {
			int number = in.nextInt();
			int count = (numberCount.get(number) == null) ? 0 : numberCount.get(number);
			numberCount.put(number, ++count);
		}
		
		arraySize = in.nextInt();
				
		for(int i = 0; i < arraySize; i++) {
			int number = in.nextInt();
			int count = (numberCount.get(number) == null) ? Integer.MAX_VALUE : numberCount.get(number);
			numberCount.put(number, --count);
		}
		
		for(int number : numberCount.keySet()) {
			//System.out.println("number: " + number + " value: " + numberCount.get(number));
			if( numberCount.get(number) != 0 ) {
				System.out.print(number + " ");
			}
		}
		
		in.close();
	}
	
}
