/**
 * Hacker Earth -> January Circuits '17 
 * Good String
 * Easy?
 */
package HackerEarth;

import java.util.Scanner;

/**
 * @author tmosest
 *
 */
public class GoodString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.next();
		in.close();
		System.out.println(countCharactersToRemoveToMakeDistinct(s));
	}
	
	public static int countCharactersToRemoveToMakeDistinct(String s)
	{
		int[] letterCounts = new int[128];
		for(int i = 0; i < s.length(); i++) {
			letterCounts[s.charAt(i)]++;
		}
		int count = 0;
		for(int i = 0; i < letterCounts.length; i++) {
			if(letterCounts[i] > 0) {
				count += letterCounts[i] - 1;
			}
		}
		return count;
	}
}
