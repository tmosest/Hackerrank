package ProjectEuler;

import java.util.Scanner;

/**
 * Project Euler #4: Largest palindrome product
 * Medium
 */
public class Problem4 {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int tests = in.nextInt();
		
		for(int t = 0; t < tests; t++) {
			int digit = generateLargestPalidromeLessThanNumber(in.nextInt());
			System.out.println(digit);
		}
		
		in.close();
	}

	public static boolean isPalindrome(int number)
	{
		boolean isPalidrome = true;
		String digits = String.valueOf(number);
		
		for(int i = 0; i <= digits.length() / 2; i++) {
			if(digits.charAt(i) != digits.charAt(digits.length() - i - 1)) {
				isPalidrome = false;
				break;
			}
		}
		
		return isPalidrome;
	}
	
	public static int generateLargestPalidromeLessThanNumber(int number)
	{
		int ans = 0;
		for(int i = 100; i < 1000; i++) {
			for(int j = 100; j < 1000; j++) {
				if(isPalindrome(i * j) && i * j < number && i * j > ans)
					ans = i * j;
			}
		}
		return ans;
	}
}
