package Implementation;

import java.util.Scanner;

/**
 *	Algorithms -> Warmup -> Kangaroo
 *	Easy (Super Easy)
 */
public class Kangaroo {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		double d0 = in.nextInt();
    	double v0 = in.nextInt();
    	double d1 = in.nextInt();
    	double v1 = in.nextInt();
        in.close();
        String r = willKagarooCatchUp(d0, v0, d1, v1);
        System.out.println(r);
	}
	
	public static String willKagarooCatchUp(double d0, double v0, double d1, double v1)
	{
		double i = (d0 - d1) / (v1 - v0);
    	String r = "NO";
    	if(i > 0 && i == (int) i) {
    		r = "YES";
    	}
    	return r;
	}
}
