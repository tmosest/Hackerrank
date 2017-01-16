package HackerEarth;

import java.util.Scanner;

/**
 * Rest in peace - 21-1!
 * Algorithms  Searching  Linear Search
 * Easy
 * @author tmosest
 *
 */
public class RestInPeace {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int qs = in.nextInt();
		
		for(int q = 0; q < qs; q++) {
			String s = in.next();
			int num = Integer.parseInt(s);
			
			if(s.contains("21") || num % 21 == 0)
				System.out.println("The streak is broken!");
			else 
				System.out.println("The streak lives still in our heart!");
		}
		
		in.close();
	}

}
