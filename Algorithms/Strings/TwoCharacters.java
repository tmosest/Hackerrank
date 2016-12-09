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

/**
 * This is a description of what this code does and how it works:
 * 
 * From reading the problem we know that we are to make the longest substring possible that contains only two alternating characters
 * by deleting all occurrences of any letters we want from the original string.
 * 
 * 
 * 
 * @author AF17783
 *
 */
public class TwoCharacters {

	public static void main(String[] args) {
		/*
		 * Here we just
		 * 1) Read in the string
		 * 2) Send it off to a function
		 * 3) Print out the count
		 */
		Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        String s = in.next();
        in.close();
        int count = calculateLengthOfAlternating(s);
        System.out.println(count);
	}
	
	/**
	 * This function is the heavy lifter.
	 * 
	 * We first loop through the string and create a set of all the characters to use later.
	 * 
	 * After that we create a double loop that loops through all of the characters in that set
	 * making sure to have two different letters.
	 * 
	 * From here we use some regex magic. We look for [cd] where c and d are two letters. 
	 * This returns all substrings of the input string that simply contain c and d.
	 * 
	 * We then loop through all of the matching substring parts and append them together to create
	 * the real substring that contains only those two letters. 
	 * For example: if we had beabeefeab then [be] would return be bee and b so we to append them to get bebeeeb
	 * 
	 * If the above is confusing got to http://regexr.com/ and look at ([ab]) you'll see how it grabs all of the a's or b's.
	 * This regex is really the hardest part to the entire question and building a new string from the pattern.
	 * 
	 * We then turn the new string builder of the input that has only occurrences of the two letters and check to make sure that it is alternating by using 
	 * the isAlternatingTwoCharacters function.
	 * 
	 * If that is true and it is bigger than the last one, set it to the new one.
	 * 
	 * @param input
	 * @return
	 */
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
	
	/**
	 * Loop through a string and check if it contains two and only two alternating chars
	 * example: xyxyxyxyxyxyxyxyxyxy or yxyxyx
	 * 
	 * @param input
	 * @return
	 */
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
