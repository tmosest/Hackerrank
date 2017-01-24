package HackerEarth;

import java.util.Scanner;

/**
 * Breakup App
 * Algorithms  Searching  Linear Search
 * Very Easy
 * @author tmosest
 *
 */
public class BreakupApp {
	
	private static boolean debugMode = false;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int qs = in.nextInt();
		if(debugMode)
			System.out.println("qs: " + qs);
		
		int[] counts = new int[101];
		StringBuilder number = new StringBuilder();
		in.nextLine();
		for(int q = 0; q < qs; q++) {
			String s = in.nextLine();
			if(debugMode)
				System.out.println("q: " + q + " s: " + s);
			boolean isGirl = (s.charAt(0) == 'G');
			if(debugMode)
				System.out.println("isGirl: " + isGirl);
			for(int i = 0; i < s.length(); i++) {
				char letter = s.charAt(i);
				if(letter >= '0' && letter <= '9') {
					if(debugMode)
						System.out.println("s: " + letter);
					number.append(letter);
					if(i == s.length() - 1) {
						int num = Integer.valueOf(number.toString());
						if(debugMode)
							System.out.println("sb: " + number.toString());
						counts[num]++;
						if(isGirl) counts[num]++;
						number = new StringBuilder();
					}
				} else {
					if(number.length() > 0) {
						int num = Integer.valueOf(number.toString());
						if(debugMode)
							System.out.println("sb: " + number.toString());
						counts[num]++;
						if(isGirl) counts[num]++;
						number = new StringBuilder();
					}
				}
			}
		}
		
		int date = 0;
		int maxtalks = 0;
		for(int i = 0; i < counts.length; i++) {
			if(counts[i] > maxtalks) {
				maxtalks = counts[i];
				date = i;
			}
		}
		
		if(date == 19 || date == 20)
			System.out.println("Date");
		else
			System.out.println("No Date");
		
		in.close();
	}

}
