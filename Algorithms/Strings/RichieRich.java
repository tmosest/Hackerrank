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
		
			int numChangesToPalindrome = 0;
			
			String inputReversed = new StringBuffer(input).reverse().toString();
			
			char[] inputArray = input.toCharArray();
			char[] reversedArray = inputReversed.toCharArray();
			
			for(int i = 0; i < inputArray.length / 2; i++) {
				if(inputArray[i] != reversedArray[i]) numChangesToPalindrome++;
			}
			
			BigInteger result = new BigInteger(input);
			String resultStr = input;
			
			if(numChangesToPalindrome > digitsCanChange) {
				
				palidrome = "-1";
			
			} else {
				
				System.out.println(numChangesToPalindrome);
				for(int i = 0; i < inputArray.length / 2; i++) {
					
					System.out.println(i);
					
					char digit = inputArray[i];
					char inverseDigit = reversedArray[i];
					
					boolean canOptimize = false;
					
					if(digitsCanChange > numChangesToPalindrome) {
						//System.out.println("digit:  " + digit);
						//System.out.println("inverseDigit:  " + inverseDigit);
						if(digit != '9' || inverseDigit != '9') {
							canOptimize = true;
							if(digit != '9' && inverseDigit != '9') {
								if(digit != inverseDigit && numChangesToPalindrome > 0) numChangesToPalindrome--;
								if(digitsCanChange - 2 >= numChangesToPalindrome) {
									digitsCanChange -= 2;
								} else {
									canOptimize = false;
								}
							} else {
								digitsCanChange--;
							}
							digit = '9';
							inverseDigit = '9';
							//System.out.println("canOptimize: " + canOptimize);
							//System.out.println("digits need: " + numChangesToPalindrome);
							//System.out.println("digits can: " + digitsCanChange);
						}
					}
					
					if(digit != inverseDigit || canOptimize) {
						char[] testArray1 = resultStr.toCharArray();
						char[] testArray2 = resultStr.toCharArray();
						if(canOptimize) {
							testArray1[i] = inverseDigit;
							testArray1[inputArray.length - i - 1] = digit;
						} else {
							testArray1[i] = inverseDigit;
							testArray2[inputArray.length - i - 1] = digit;
						}
						String test1 = String.copyValueOf(testArray1);
						String test2 = String.copyValueOf(testArray2);
						//System.out.println("test1: " + test1);
						//System.out.println("test2: " + test2);
						BigInteger test1Num = new BigInteger(test1);
						BigInteger test2Num = new BigInteger(test2);
						if(test1Num.compareTo(test2Num) == 1) {
							if(test1Num.compareTo(result) == 1) {
								result = test1Num;
								resultStr = String.valueOf(testArray1);
							}
						} else {
							if(test2Num.compareTo(result) == 1) {
								result = test2Num;
								resultStr = String.valueOf(testArray2);
							}
						}
					}
				}
				
				
				if(resultStr.length() % 2 == 1 && digitsCanChange == 1) {
					char[] testArray1 = resultStr.toCharArray();
					testArray1[inputArray.length / 2] = '9';
					resultStr = String.valueOf(testArray1);
				}
				
				palidrome = String.valueOf(resultStr);
			
			}
		}
		return palidrome;
	}
}
