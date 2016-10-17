package Implementation;

import java.util.Scanner;

/**
 *	Algorithms -> Implementations -> Utopian Tree
 *	Easy
 */
public class UtopianTree {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            System.out.println(calculateUtopianTreeGrowth(n));
        }
        in.close();
	}
	
	public static int calculateUtopianTreeGrowth(int cycles)
	{
		int height = 1; // start at height one
		for(int i = 1; i <= cycles; i++) {
			if(i % 2 == 0 ) {
				height += 1;			
			} else {
				height *= 2;
			}
		}
		return height;
	}

}
