package BitManipulation;

import java.util.Scanner;

/**
 *	Algorithms -> Bit Manipulation -> Sansa and XOR
 *	Medium
 */
public class SansaAndXOR {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int cases = in.nextInt();
		
		for(int c = 0; c < cases; c++) {
			int arraySize = in.nextInt();
			int[] array = new int[arraySize];
			
			for(int i = 0; i < arraySize; i++) 
				array[i] = in.nextInt();
			
			if((arraySize & 1) == 0) {
				System.out.println(0);
			} else {
				int xor = 0;
				
				for(int i = 0; i < arraySize; i += 2) {
					if((i & 1) == 1) continue;
					xor ^= array[i];
				}
				
				System.out.println(xor);
			}
		}
		
		in.close();
	}

}
