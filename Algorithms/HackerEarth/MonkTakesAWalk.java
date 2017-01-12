package HackerEarth;

import java.util.Scanner;

/**
 * Monk Takes a Walk
 * Algorithms  Searching  Linear Search
 * Very Easy
 * @author tmosest
 *
 */
public class MonkTakesAWalk {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int qs = in.nextInt();
		
		for(int q = 0; q < qs; q++)
			System.out.println(countVowels(in.next()));
		
		in.close();
	}
	
	public static int countVowels(String s)
	{
		int count = 0;
		
		for(int i = 0; i < s.length(); i++) {
			char c = Character.toLowerCase(s.charAt(i));
			switch(c) {
				case 'a':
				case 'e':
				case 'i':
				case 'o':
				case 'u':
					count++;
					break;
			}
		}
		
		return count;
	}
}
