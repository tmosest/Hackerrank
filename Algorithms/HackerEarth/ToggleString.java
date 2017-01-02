package HackerEarth;

import java.util.Scanner;

/**
 * Toggle String
 * Very-Easy
 * @author tmosest
 *
 */
public class ToggleString {
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		String s = in.next();
		in.close();
		System.out.println(toggleString(s));
	}
	
	public static String toggleString(String s)
	{
		StringBuilder sb = new StringBuilder(s.length());
		for(int i = 0; i < s.length(); i++) {
			char letter = s.charAt(i);
			if(letter >= 'A' && letter <= 'Z') {
				sb.append(Character.toLowerCase(letter));
			} else if(letter >= 'a' && letter <= 'z') {
				sb.append(Character.toUpperCase(letter));
			} else {
				sb.append(letter);
			}
		}
		return sb.toString();
	}
}
