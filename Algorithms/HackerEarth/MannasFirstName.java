package HackerEarth;

import java.util.Scanner;

/**
 * Manna's First Name
 * Algorithms  Searching  Linear Search
 * Easy
 * @author tmosest
 *
 */
public class MannasFirstName {

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		int qs = in.nextInt();
		
		for(int q = 0; q < qs; q++)
			System.out.println(countNamesInString(in.next()));
		
		in.close();
	}
	
	public static String countNamesInString(String s)
	{
		int[] count = new int[2];
		
		String name1 = "SUVO";
		String name2 = "SUVOJIT";
		
		int j = 0;
		for(int i = 0; i < s.length(); i++) {
			if(j < name1.length() && s.charAt(i) == name1.charAt(j)) {
				j++;
			} else if(j == name1.length() && s.charAt(i) != 'J') {
				count[0]++;
				j = 0;
				if(s.charAt(i) == 'S') j++;
			} else if(j < name2.length() && s.charAt(i) == name2.charAt(j)) {
				j++;
			} else if(j == name2.length()) {
				count[1]++;
				j = 0;
			} else if(j >= name1.length()) {
				count[0]++;
				j = 0;
			} else {
				j = 0;
			}
		}
		
		String res = "SUVO = "+ count[0] + ", SUVOJIT = "+ count[1];
		return res;
	}
}
