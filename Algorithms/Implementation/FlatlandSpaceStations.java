package Implementation;

import java.util.Scanner;

/**
 *	Algorithms -> Implementations -> Flatland Space Stations
 *	Easy
 */
public class FlatlandSpaceStations {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int c[] = new int[m];
        for(int c_i=0; c_i < m; c_i++){
            c[c_i] = in.nextInt();
        }
        in.close();
        //Solve this
        int max = 0;
        int distances[] = new int[n];
        for(int i = 0; i < n; i++) {
            int minDistance = n;
            for(int j = 0; j < m; j++) {
                if(c[j] == i) {
                    minDistance = 0;
                } else {
                    int distance = Math.abs(c[j] - i);
                    if(distance < minDistance) minDistance = distance;
                }
            }
            distances[i] = minDistance;
        }
        for(int i = 0; i < n; i++) {
            if(distances[i] > max) max = distances[i];
        }
        System.out.println(max);
	}

}
