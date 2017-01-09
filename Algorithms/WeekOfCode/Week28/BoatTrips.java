package WeekOfCode.Week28;

import java.util.Scanner;

/**
 *	Algorithms -> Week of Code 28 -> Boat Trips
 *	Easy
 */
public class BoatTrips {

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int c = in.nextInt();
		int m = in.nextInt();
		
		int max = c * m;
		
		boolean isTooLarge = false;
		for(int i = 0; i < n; i++) {
			int t = in.nextInt();
			if(t > max) {
				isTooLarge = true;
				break;
			}
		}
		
		String res = "Yes";
		if(isTooLarge) res = "No";
		
		System.out.println(res);
		
		in.close();
	}
	
}
