package Strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 *	Algorithms -> Strings -> Two Characters
 *	Medium
 */
public class RichieRich {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line1 = br.readLine();
		int k = Integer.parseInt(line1.split(" ")[1]);
		String number = br.readLine();
		br.close();
        String result = superPalindromeOptimizer(number, k);
        System.out.println(result);
	}
	
	private static String convertStringToAllNines(String input) {
		char[] inputArray = input.toCharArray();
		for(int i = 0; i < inputArray.length; i++) {
			inputArray[i] = '9';
		}
		return String.valueOf(inputArray);
	}
	
	public static String superPalindromeOptimizer(String input, int digitsCanChange) {
		
		//System.out.println(input.length());
		
		String palidrome = "";
		
		if(input.length() == 1 && digitsCanChange >= 1) {
		
			palidrome = "9";
		
		} if(digitsCanChange >= input.length()) {
		
			palidrome = convertStringToAllNines(input);
		
		} else {
		
			long numChangesToPalindrome = 0;
			
			String inputReversed = new StringBuffer(input).reverse().toString();
			
			char[] inputArray = input.toCharArray();
			char[] reversedArray = inputReversed.toCharArray();
			
			for(int i = 0; i < inputArray.length / 2; i++) {
				if(inputArray[i] != reversedArray[i]) numChangesToPalindrome++;
			}
			
			if(numChangesToPalindrome > digitsCanChange) {
				
				palidrome = "-1";
			
			} else {
				int changes = 0;
				int n = inputArray.length;
				
				boolean[] changed = new boolean[inputArray.length / 2];
				char[] finalPalidrome = new char[inputArray.length];
				
				if (inputArray.length % 2 == 1)
					 finalPalidrome[inputArray.length / 2] = input.charAt(inputArray.length / 2);
				 
				for (int i = 0; i < n / 2; ++i) {
					 	
			            char lc = input.charAt(i);
			            char rc = input.charAt(n - i - 1);
			            //System.out.println(lc + " " + rc + " " +  (char) Math.max(lc, rc));
			 
			            if (lc != rc) {
			                changes++;
			                changed[i] = true;
			            }
			 
			            char newChar = (char) Math.max(lc, rc);
			            finalPalidrome[i] = newChar;
			            finalPalidrome[n - i - 1] = newChar;
			    }
				
				// We have a palindrome, now, if any changes left...
		        for (int i = 0; i < n / 2; ++i) {
		            if (digitsCanChange - changes >= 1 && changed[i] && finalPalidrome[i] != '9') {
		            	finalPalidrome[i] = '9';
		            	finalPalidrome[n - i - 1] = '9';
		                changes += 1;
		            }
		            if (digitsCanChange - changes >= 2 && !changed[i] && finalPalidrome[i] != '9') {
		            	finalPalidrome[i] = '9';
		            	finalPalidrome[n - i - 1] = '9';
		                changes += 2;
		            }
		        }
		        if (n % 2 == 1 && digitsCanChange - changes >= 1) {
		        	finalPalidrome[n / 2] = '9';
		            changes += 1;
		        }
		        
		        palidrome = String.valueOf(finalPalidrome);
			}
		}
		return palidrome;
	}
}
