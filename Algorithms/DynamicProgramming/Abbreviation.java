package DynamicProgramming;

import java.util.HashMap;
import java.util.Scanner;

/**
 *	Algorithms -> Dynamic Programming -> Abbreviation
 *	Medium
 */
public class Abbreviation {
	
	private static boolean debugMode = true;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int qs = in.nextInt();
		
		for(int q = 0; q < qs; q++) {
			String from = in.next();
			String to = in.next();
			String res = "NO";
			if(canTransformIntoDP(from, to))
				res = "YES";
			System.out.println(res);
		}
		
		in.close();
	}

	/**
	 * This basic method fails b/c it doesn't take into account the order of the character.
	 * @param from
	 * @param to
	 * @return
	 */
	public static boolean canTransformInto(String from, String to)
	{
		if(from.length() < to.length())
			return false;
		
		HashMap<Character, Integer> toCounts = new HashMap<Character, Integer>();
		HashMap<Character, Integer> fromCounts = new HashMap<Character, Integer>();
		
		for(int i = 0; i < to.length(); i++) {
			char letter = to.charAt(i);
			int count = (toCounts.get(letter) == null) ? 0 : toCounts.get(letter);
			toCounts.put(letter, ++count);
			fromCounts.put(letter, count);
			if(debugMode)
				System.out.println("letter: " + letter + " count: " + count);
		}
		
		for(int i = 0; i < from.length(); i++) {
			char letter = from.charAt(i);
			int toCount = (toCounts.get(letter) == null) ? 0 : toCounts.get(letter);
			if(debugMode)
				System.out.println("letter: " + letter + " toCount: " + toCount);
			//If we have a capital letter in from that is not in to we can't convert.
			if(letter >= 'A' && letter <= 'Z' && toCount == 0) return false;
			//Otherwise let's subtract the letter from to's other count
			letter = Character.toUpperCase(letter);
			int count = (fromCounts.get(letter) == null) ? 0 : fromCounts.get(letter);
			fromCounts.put(letter, --count);
			if(debugMode)
				System.out.println("letter: " + letter + " fromCount: " + count);
		}
		
		for(int count : fromCounts.values()) {
			if(debugMode)
				System.out.println("fromCount: " + count);
			if(count > 0) return false;
		}
		
		return true;
	}
	
	
	private static int limit = 1011;
	private static boolean dp[][];
	/**
	 * https://www.hackerrank.com/challenges/abbr/editorial
	 * @param from The string we are trying to transform.
	 * @param to The string we are to trying to create.
	 * @return
	 */
	public static boolean canTransformIntoDP(String from, String to)
	{
		dp = new boolean[limit][limit];
		
		dp[0][0] = true;
		
		for (int i = 0; i < from.length(); i++) {
            for (int j = 0; j <= to.length(); j++)
            	if (dp[i][j]) {
            		if(j < to.length() && (upcase(from.charAt(i)) == to.charAt(j))) 
            			dp[i + 1][j + 1] = true;
            		if(!isUpcase(from.charAt(i))) 
            			dp[i + 1][j] = true;
            }
        }
		
		return dp[from.length()][to.length()];
	}
	
	private static boolean isUpcase(char c){
	    return (c >= 'A') && (c <= 'Z');
	}

	private static char upcase(char c){
	    return Character.toUpperCase(c);
	}
}
