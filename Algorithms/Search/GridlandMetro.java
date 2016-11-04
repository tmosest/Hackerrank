package Search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 *	Algorithms -> Search -> Gridland Metro
 *	Medium
 *
 * Sample Input:
    4 4 3
	2 2 3
	3 1 4
	4 4 4
 *
 * Sample Output:
    9
 */
public class GridlandMetro {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int rows = in.nextInt();
		int columns = in.nextInt();
		
		int numTrainTracks = in.nextInt();
		
		int numLamps = rows * columns;
		
		HashMap<Integer, int[]> trackKeeper = new HashMap<Integer, int[]>();
		
		for(int j = 0; j < numTrainTracks; j++) {
			
			int row = in.nextInt();
			int start = in.nextInt();
			int end = in.nextInt();
			int diff = 0;
			int[] track = (trackKeeper.get(row) == null) ? new int[2] : trackKeeper.get(row);
			
			if(track[0] == 0) {
				track[0] = start;
				diff = (end + 1) - start;
			} else {
				if(start < track[0]) {
					diff += (track[0] - start); 
					track[0] = start;
				}
			}
			if(track[1] == 0) {
				track[1] = end;
			} else {
				if(end > track[1]) {
					diff += (end - track[1]); 
					track[1] = end;
				}
			}
			
			numLamps -= diff;
			
			//System.out.println("row: " + row + " track[0]: " + track[0] + " track[1]: " + track[1] + " diff: " + diff + " lamps: " + numLamps);
			
			trackKeeper.put(row, track);
		}
		
		in.close();

		System.out.println(numLamps);
	}
}
