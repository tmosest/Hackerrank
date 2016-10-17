package Implementation;

import java.util.Scanner;

/**
 *	Algorithms -> Implementations -> Find Digits
 *	Easy
 */
public class FindDigits {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            //Loop through the digits of n and test if each divide it.         
            int result = 0;
            int length = String.valueOf(n).length();
            for(int i = 0; i < length; i++) {
                int power = (int) Math.pow(10.0, (double) i + 1);
                int r = (n%power)/(power/10);
                double d = ((double) n) / r;
                if((d == Math.floor(d)) && !Double.isInfinite(d)) {
                   result += 1;   
                }
            }
            System.out.println(result);
        }
        in.close();
	}

}
