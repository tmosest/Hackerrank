package Warmup;

import java.util.Scanner;
/**
 *	Algorithms -> Warmup -> Staircase
 *	Easy (Super Easy)
 */
public class Staircase {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.close();
        String[] stairs = buildStairCase(n);
        for(int i= 0; i < n; i++) {
        	System.out.println(stairs[i]);
        }
	}
	
	public static String[] buildStairCase(int n)
	{
		String[] stairs = new String[n];
		for(int i= 1; i <= n; i++) {
            String s = "";
            for(int j = 0; j < n; j++) {
              if(j < n - i) {
                  s += " ";
              } else {
                  s += "#";
              }
            }
            stairs[i - 1] = s;
        }
		return stairs;
	}
}
