package Search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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

	private static class Tuple implements Comparator<Tuple>, Comparable<Tuple> {
		public long x1;
		public long x2;
		
		Tuple(long x, long y) {
			this.x1 = x;
			this.x2 = y;
		}

		/*
		 * Copies the comparison for Python tuples
		 */
		@Override
		public int compare(Tuple lhs, Tuple rhs) {
			//TODO return 1 if rhs should be before lhs 
		    //     return -1 if lhs should be before rhs
		    //     return 0 otherwise
			if(lhs.x1 < rhs.x1) {
				return -1;
			} else if(lhs.x1 > rhs.x1) {
				return 1;
			} else {
				if(lhs.x2 < rhs.x2) {
					return -1;
				} else if(lhs.x2 > rhs.x2) {
					return 1;
				} else {
					return 0;
				}
			}
		}

		@Override
		public int compareTo(Tuple t) {
			if(this.x1 < t.x1) {
				return -1;
			} else if(this.x1 > t.x1) {
				return 1;
			} else {
				if(this.x2 < t.x2) {
					return -1;
				} else if(this.x2 > t.x2) {
					return 1;
				} else {
					return 0;
				}
			} 
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		long rows = in.nextLong();
		long columns = in.nextLong();
		
		long numTrainTracks = in.nextLong();
		
		HashMap<Long, ArrayList<Tuple>> tracks = new HashMap<Long, ArrayList<Tuple>> ();
		
		for(int j = 0; j < numTrainTracks; j++) {
			
			long row = in.nextLong();
			long start = in.nextLong();
			long end = in.nextLong();
			
			Tuple cordinates = new Tuple(start, end);
			ArrayList<Tuple> track = tracks.get(row);
			
			if(track == null) {
				track = new ArrayList<Tuple>();
			}
			
			track.add(cordinates);
			tracks.put(row, track);
		}
		
        in.close();
        
        long numLamps = rows * columns;
        long gridPoints = 0;
		
		for(long row : tracks.keySet()) {
			ArrayList<Tuple> temp = tracks.get(row);
			/*
			for(Tuple t: temp) {
				System.out.print("(" + t.x1 + ", " + t.x2 + ") ");
			}
			System.out.println("");
			*/
			Collections.sort(temp);
			/*
			for(Tuple t: temp) {
				System.out.print("(" + t.x1 + ", " + t.x2 + ") ");
			}
			System.out.println("");
			*/
			long begin = temp.get(0).x1;
			long end = temp.get(0).x2;
			long points = 0;
			
			for(int i = 1; i < temp.size(); i++) {
				if(temp.get(i).x1 > end) {
					points += end - begin + 1;
					begin = temp.get(i).x1;
					end = temp.get(i).x2;
				} else {
					end = Math.max(end, temp.get(i).x2);
				}
			}
			points += end - begin + 1;
			gridPoints += points;
		}
		
		numLamps -= gridPoints;
		
		System.out.println(numLamps);
	}
}
