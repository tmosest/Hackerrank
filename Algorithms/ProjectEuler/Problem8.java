package ProjectEuler;

import java.util.Scanner;

/**
 * Project Euler #8: Largest product in a series
 * Easy
 */
public class Problem8 {

	private static boolean debugMode = false;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int cases = in.nextInt();
		
		for(int c = 0; c < cases; c++) {
			int stringLegnth = in.nextInt();
			int digits = in.nextInt();
			String number = in.next();
			
			if(debugMode)
				System.out.println("number :" + number);
			
			int max = 0;
			
			for(int i = 0; i < stringLegnth - digits; i++) {
				int product = 1;
				for(int j = i; j < i + digits; j++) {
					int digit = Character.getNumericValue(number.charAt(j));
					product *= digit;
					if(debugMode)
						System.out.print(digit + " ");
				}
				if(debugMode)
					System.out.println("product: " + product);
				if(product > max) max = product;
			}
			
			System.out.println(max);
		}
		
		in.close();
	}

}
