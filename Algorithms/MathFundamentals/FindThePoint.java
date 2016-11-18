package MathFundamentals;

import java.util.Scanner;

/**
 *	Mathematics -> Fundamentals -> Find the Point
 *	Easy
 */
public class FindThePoint {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();
        for(int i = 0; i < testCases; i++) {
            int y0 = in.nextInt();
            int y1 = in.nextInt();
            int z0 = in.nextInt();
            int z1 = in.nextInt();
            int d1 = z1 - y1;
            int d0 = z0 - y0;
            int a1 = z1 + d1;
            int a0 = z0 + d0;
            System.out.println(a0 + " " + a1);
        }
        in.close();
	}

}
