package HackerEarth;

import java.util.Scanner;

/**
 * Basics of Input/Output
 * Tutorial
 * @author tmosest
 *
 */
class BasicInputOut {
    public static void main(String args[] ) throws Exception {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String s = in.next();
		in.close();
		System.out.println(2 * n);
		System.out.println(s);
    }
}

