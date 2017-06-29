package Implementation;

import java.util.Arrays;
import java.util.Scanner;

/**
 *	Algorithms -> Implementations -> Breaking The Rules
 *	Easy
 */
public class MigratoryBirds {
	
	/**
	 * Determines the most common bird type.
	 * O(n)
	 * @param n
	 * @param ar
	 * @return
	 */
	private static int migratoryBirds(int n, int[] ar) {
		Arrays.sort(ar);
		int mostBird = ar[0];
		int count = 1;
		int mostCount = 1;
		int lastBird = ar[0];
		for(int i = 1; i < ar.length; i++) {
			int bird = ar[i];
			if(bird == lastBird) {
				++count;
				if(count > mostCount) {
					mostCount = count;
					mostBird = bird;
				}
			} else {
				count = 1;
				lastBird = bird;
			}
		}
		return mostBird;
    }
	
	/**
	 * Main function for testing.
	 * @param args
	 */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int result = migratoryBirds(n, ar);
        System.out.println(result);
    }
    
}
