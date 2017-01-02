package HackerEarth;

import java.util.Scanner;

/**
 * Palindromic String
 * Very-Easy
 * @author tmosest
 *
 */
public class PalindromicString {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.next();
		in.close();
		String res = "NO";
		if(isPalindrome(s))
			res = "YES";
		System.out.println(res);
	}
	
	public static boolean isPalindrome(String s)
	{
		int n = s.length();
		for(int i = 0; i <= n/2; i++) {
			if(s.charAt(i) != s.charAt(n - i - 1))
				return false;
		}
		return true;
	}

}
