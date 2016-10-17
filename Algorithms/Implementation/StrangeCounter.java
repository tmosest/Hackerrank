package Implementation;

import java.util.Scanner;

/**
 *	Algorithms -> Implementations -> Strange Counter
 *	Easy
 */
public class StrangeCounter {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
        long t = in.nextLong(), n = 2;
        in.close();
        while (3 * (n - 1) < t) n = 2 * n;
        System.out.println((3 * (n - 1) - t + 1));
	
	}

}
