package Implementation;

import java.util.Scanner;

/**
 *	Algorithms -> Implementations -> Library Fine
 *	Easy
 */
public class LibraryFine {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
	     int d1 = in.nextInt();
	     int m1 = in.nextInt();
	     int y1 = in.nextInt();
	     int d2 = in.nextInt();
	     int m2 = in.nextInt();
	     int y2 = in.nextInt();
	     in.close();
	     int[] actual = new int[]{d1, m1, y1};
	     int[] expected = new int[]{d2, m2, y2};
	     System.out.println(calculateLibraryFee(actual, expected));
	}
	
	public static int calculateLibraryFee(int[] actual, int[] expected) {
		int fee = 0;
		if(actual[2] > expected[2]) {
			fee = 10000;
		} else if(actual[1] > expected[1]) {
			fee = 500 * (actual[1] - expected[1]);
		} else if(actual[0] > expected[0]) {
			fee = 15 * (actual[0] - expected[0]);
		}
		if(actual[2] < expected[2]) {
			fee = 0;
		} else if((actual[2] <= expected[2]) && (actual[1] < expected[1])) {
			fee = 0;
		}
		return fee;
	}

}
