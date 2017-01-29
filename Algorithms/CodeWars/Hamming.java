package CodeWars;
/**
 * Hamming Numbers
 * https://rosettacode.org/wiki/Hamming_numbers
 * @author tmosest
 */
public class Hamming {
	
	public static long hamming(int n) {
		long[] h = new long[n];
		h[0] = 1;
		
		int two = 2, three = 3, five = 5;
		int i = 0, j = 0, k = 0;
		long x2 = 2, x3 = three, x5 = five;
		
		for(int index = 1; index < n; index++) {
			h[index] = Math.min(x2, Math.min(x3, x5));
			if(h[index] == x2) x2 = two * h[++i];
			if(h[index] == x3) x3 = three * h[++j];
			if(h[index] == x5) x5 = five * h[++k];
		}
		
		return h[n - 1];
	}
	
}
