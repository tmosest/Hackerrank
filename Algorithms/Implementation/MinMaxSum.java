package Implementation;

import java.util.Scanner;

/**
 *	Algorithms ->  Implementation -> Mini-Max Sum
 *	Easy
 */
public class MinMaxSum {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        long a = in.nextLong();
        long b = in.nextLong();
        long c = in.nextLong();
        long d = in.nextLong();
        long e = in.nextLong();
        in.close();
        long[] array = {
        		a, b, c, d, e
        };
        long min = a + b + c + d + e;
        long max = 0;
        for(int i = 0; i < array.length; i++) {
        	long sum = 0;
        	for(int j = 0; j < array.length; j++) {
        		if(i != j) sum += array[j];
        	}
        	if(sum > max) max = sum;
        	if(sum < min) min = sum;
        }
        System.out.println(min + " " + max);
	}

}

