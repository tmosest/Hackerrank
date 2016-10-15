package Warmup;
import java.util.*;

public class CompareTheTriplets {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int a0 = in.nextInt();
        int a1 = in.nextInt();
        int a2 = in.nextInt();
        int b0 = in.nextInt();
        int b1 = in.nextInt();
        int b2 = in.nextInt();
        int amy[] = new int[] {
           a0, a1, a2
    	};
    	int bob[] = new int[] {
    	   b0, b1, b2  
    	};
    	int[] result = compareTriplets(amy, bob);
    	System.out.println(result[0] + " " + result[1]);
	}
	
	public static int[] compareTriplets(int[] a, int[] b)
	{
		int a_score = 0;
        int b_score = 0;
        for(int i = 0; i < a.length; i ++) {
            if(a[i] > b[i]) {
                a_score++;
            } else if(a[i] < b[i]) {
                b_score++;
            }
        }
        int[] result = {a_score, b_score};
        return result;
	}
	
}
