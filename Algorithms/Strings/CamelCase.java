package Strings;

import java.util.Scanner;

/**
 *	Algorithms -> Strings -> Super Reduced String
 *	Easy
 */
public class CamelCase {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        String s = in.next();
        in.close();
        int numOfUppercases = countWordsByCamelCase(s);
        System.out.println(numOfUppercases);
	}
	
	public static int countWordsByCamelCase(String input)
	{
		int numOfUppercases = 1;
		for(int char_i = 0; char_i < input.length(); char_i++) {
			if( Character.isUpperCase(input.charAt(char_i)) ) numOfUppercases++;
		}
		return numOfUppercases;
	}
}
