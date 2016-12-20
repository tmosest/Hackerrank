package ProjectEuler;

import java.util.Scanner;

/**
 * Project Euler #9: Special Pythagorean triplet 
 * Medium
 */
public class Problem9 {

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		int cases = in.nextInt();
		
		for(int c = 0; c < cases; c++) {
			
			int number = in.nextInt();
			printPythagoreanSum(number);
		}
		
		in.close();
	}
	
	public static void printPythagoreanSum(int s)
	{
		int s2 = s / 2;
		int mlimit = (int) Math.sqrt(s2) - 1;
		for(int m = 2; m <= mlimit; m++) {
			int sm = s2 / m;
			while(sm % 2 == 0) {
				sm = sm / 2;
			}
			int k = m + 1;
			if(m % 2 == 1) {
				k += 1;
			}
			while(k <= 2 * m && k <= sm) {
				if(sm % k == 0 && gcd(k , m) == 1) {
					int d = s2 / (k * m);
					int n = k - m;
					int a = d * (m * m - n * n);
					int b = 2 * d * m * n;
					int c = d * (m * m * n * n);
					System.out.println(a * b * c);
					return;
				}
			}
		}
		System.out.println(-1);
	}
	
	public static int gcd(int a, int b)
	{
		if(b == 0) return a;
		return gcd(b, a % b);
	}
}
