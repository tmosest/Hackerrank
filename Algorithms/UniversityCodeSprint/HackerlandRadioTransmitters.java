package UniversityCodeSprint;

import java.util.Arrays;
import java.util.Scanner;

/**
 *	Algorithms ->  University CodeSprint -> Hackerland Radio Transmitters
 *	Easy
 */
public class HackerlandRadioTransmitters {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] x = new int[n];
        for(int x_i=0; x_i < n; x_i++){
            x[x_i] = in.nextInt();
        }
        
        in.close();
        
        Arrays.sort(x);
        int numberNeedeed = 0;
        boolean[] isCovered = new boolean[n];
        for(int i = 1; i < n - 1; i++) {
        	if(!isCovered[i]) {
        		int house0 = x[i];
        		int house1 = x[i] + 1;
        	}
        }
        /*
        for(int i = 1; i < n; i++) {
        	totalDistance += (x[i] - x[i - 1]);
        }
        totalDistance += 1;
        //System.out.println(totalDistance);
        int atenaRange = 2 * k + 1;
        //System.out.println(atenaRange);
        int numberNeedeed = (int) Math.ceil( (double) totalDistance / (2 * k + 1));
        System.out.println(numberNeedeed);
        */
	}

}
