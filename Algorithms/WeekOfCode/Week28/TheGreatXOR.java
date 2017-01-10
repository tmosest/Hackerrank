package WeekOfCode.Week28;

import java.util.Scanner;

public class TheGreatXOR {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int qs = in.nextInt();
		
		for(int q = 0; q < qs; q++) {
			long num = in.nextLong();
			System.out.println(greatXorCount(num));
		}
		
		in.close();
	}

	
	public static long greatXorCount(long num)
	{
		long count = 0;
		
		for(long i = 1; i < num; i++) {
			long xor = i ^ num;
			if(xor > num) count++;
		}
		
		return count;
	}
}
