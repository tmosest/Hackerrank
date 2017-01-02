package HackerEarth;

import java.util.Scanner;

/**
 * Life, the Universe, and Everything
 * Easy
 * @author tmosest
 *
 */
public class LifeTheUniverseAndEverything {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()) {
			int n = in.nextInt();
			if(n == 42) {
				break;
			}
			System.out.println(n);
		}
		in.close();
	}

}
