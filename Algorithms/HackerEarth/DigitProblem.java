package HackerEarth;

import java.util.Scanner;

/**
 * Digit Problem
 * Very Easy
 * @author tmosest
 *
 */
public class DigitProblem {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.next();
		int k = in.nextInt();
		in.close();
		
		StringBuilder sb = new StringBuilder(s.length());
		for(int i = 0; i < s.length(); i++) {
			char digit = s.charAt(i);
			if(digit == '9' || k == 0) {
				sb.append(digit);
			} else {
				sb.append('9');
				k--;
			}
		}
		System.out.println(sb.toString());
	}

}
