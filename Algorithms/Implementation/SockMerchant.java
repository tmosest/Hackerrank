package Implementation;

import java.util.Arrays;
import java.util.Scanner;

/**
 *	Algorithms -> Implementations -> Sock Merchant
 *	Easy
 */
public class SockMerchant {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int c[] = new int[n];
        for(int c_i=0; c_i < n; c_i++){
            c[c_i] = in.nextInt();
        }
        in.close();
        int pairs = countSockPairs(c);
        System.out.println(pairs);
	}

	public static int countSockPairs(int[] c)
	{
		Arrays.sort(c);
        int pairs = 0;
        int pairs_holder = 1;
        int holder = c[0];
        for(int i=1; i < c.length; i++) {
            if(c[i] == holder) {
                ++pairs_holder;
            } else {
                pairs_holder = 1;
            }
            holder = c[i];
            if(pairs_holder == 2) {
                pairs++;
                pairs_holder = 1;
                holder = -1000;
            }
        }
        return pairs;
	}
}
