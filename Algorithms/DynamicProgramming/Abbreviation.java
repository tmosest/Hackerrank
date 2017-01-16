package DynamicProgramming;

import java.util.HashMap;
import java.util.Scanner;

public class Abbreviation {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int qs = in.nextInt();
		
		for(int q = 0; q < qs; q++) {
			String from = in.next();
			String to = in.next();
			String res = "NO";
			if(canTransformInto(from, to))
				res = "YES";
			System.out.println(res);
		}
		
		in.close();
	}

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
			//System.out.println("letter: " + letter + " count: " + count);
		}
		
		for(int i = 0; i < from.length(); i++) {
			char letter = from.charAt(i);
			int toCount = (toCounts.get(letter) == null) ? 0 : toCounts.get(letter);
			//System.out.println("letter: " + letter + " toCount: " + toCount);
			//If we have a capital letter in from that is not in to we can't convert.
			if(letter >= 'A' && letter <= 'Z' && toCount == 0) return false;
			//Otherwise let's subtract the letter from to's other count
			letter = Character.toUpperCase(letter);
			int count = (fromCounts.get(letter) == null) ? 0 : fromCounts.get(letter);
			fromCounts.put(letter, --count);
			//System.out.println("letter: " + letter + " fromCount: " + count);
		}
		
		for(int count : fromCounts.values()) {
			//System.out.println("fromCount: " + count);
			if(count > 0) return false;
		}
		
		return true;
	}
}
