package CodeWars;

/**
 * Build a Pile of Cubes
 * @author tmosest
 */
public class ASum {
	
	public static long findNb(long m) {
		long n = 0;
		long sum = 0;
		
		while(sum < m) {
			n++;
			sum += (n * n * n);
		}
		
		if(sum != m) 
			n = -1;
		
		return n;
	}	
}