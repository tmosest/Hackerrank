package Strings;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *	Algorithms -> Strings -> Two Characters
 *	Easy
 */
public class TwoCharacters {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        String s = in.next();
        in.close();
        int count = calculateLengthOfAlternating(s);
        System.out.println(count);
	}
	
	public static int calculateLengthOfAlternating(String input)
	{
		int count = 0;
		
		Set<Character> characterSet = new HashSet<Character>();
		for (char c : input.toCharArray()) {
			characterSet.add(c);
		}
				
		for(char c: characterSet) {
			for(char d: characterSet) {
				if(c != d) {
					Pattern pattern = Pattern.compile("([" + c + d + "]+)");
					Matcher matcher = pattern.matcher(input);
					StringBuilder sb = new StringBuilder(input.length());
					while (matcher.find()) {
				    	for (int i = 1; i <= matcher.groupCount(); i++) {
				    		sb.append(matcher.group(0));
				    	}
				    }
					
					String toTest = sb.toString();
					boolean isAlternating = isAlternatingTwoCharacters(toTest);
		    		if( isAlternating && toTest.length() > count) {
		    			count = toTest.length();
		    		}
				}
			}
		}
		
		return count;
	}
	
	private static boolean isAlternatingTwoCharacters(String input) 
	{
		boolean result = true;
		if(input.length() > 1) {
			char tmp1 = input.charAt(0);
			char tmp2 = input.charAt(1);
			if(tmp1 != tmp2) {
				for(int i = 2; i < input.length(); i++) {
					if(i % 2 == 0) {
						if(input.charAt(i) != tmp1) {
							result = false;
							break;
						}
					} else {
						if(input.charAt(i) != tmp2) {
							result = false;
							break;
						}
					}
				}
			} else {
				result = false;
			}
		}
		return result;
	}
}
