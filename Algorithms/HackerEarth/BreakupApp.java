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

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int qs = in.nextInt();
		
		int[] counts = new int[101];
		StringBuilder number = new StringBuilder();
		in.nextLine();
		for(int q = 0; q < qs; q++) {
			String s = in.nextLine();
			System.out.println(s);
			boolean isGirl = (s.charAt(0) == 'G');
			System.out.println(isGirl);
			for(int i = 0; i < s.length(); i++) {
				char letter = s.charAt(i);
				//System.out.println(letter);
				if(letter >= '0' && letter <= '9') {
					number.append(s);
					if(i == s.length() - 1) {
						int num = Integer.valueOf(number.toString());
						counts[num]++;
						if(isGirl) counts[num]++;
						number = new StringBuilder();
					}
				} else {
					if(number.length() > 0) {
						int num = Integer.valueOf(number.toString());
						counts[num]++;
						if(isGirl) counts[num]++;
						number = new StringBuilder();
					}
				}
				System.out.println(number.toString());
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
