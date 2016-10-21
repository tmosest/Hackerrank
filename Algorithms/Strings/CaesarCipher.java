package Strings;

import java.util.Scanner;

/**
 *	Algorithms -> Strings -> Caesar Cipher
 *	Easy
 */
public class CaesarCipher {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
	    String s = in.next();
	    int k = in.nextInt();
		in.close();
		String encrpted = encyrpt(s, k);
		System.out.println(encrpted);
	}

	public static String encyrpt(String input, int shiftInt)
	{
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		char[] letters = input.toCharArray();
		for(int i = 0; i < letters.length;  i++) {
			char letter = letters[i];
			boolean isUpper = false;
			if(Character.isUpperCase(letter)) isUpper = true;
			int indexOf = alphabet.indexOf(Character.toLowerCase(letter));
			if(-1 != indexOf) {
				int ceaserIndex = (indexOf + shiftInt) % alphabet.length();
				char newLetter = alphabet.charAt(ceaserIndex);
				if(isUpper) newLetter = Character.toUpperCase(newLetter);
				letters[i] = newLetter;
			}
		}
		return String.copyValueOf(letters);
	}
}
