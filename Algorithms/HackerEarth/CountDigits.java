package HackerEarth;

import java.util.Scanner;

/**
 * Count Digits
 * Very Easy
 * @author tmosest
 *
 */
public class CountDigits {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int[] digits = new int[10];
		
		String number = in.next();
		in.close();
		
		for(int i = 0; i < number.length(); i++) {
			digits[number.charAt(i) - '0']++;
		}
		
		for(int i = 0; i < digits.length; i++) {
			System.out.println(i + " " + digits[i]);
		}
	}

}
