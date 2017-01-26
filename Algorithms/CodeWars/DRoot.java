package CodeWars;

/**
 * Sum of Digits / Digital Root
 * @author tmosest
 */
public class DRoot {
	public static int digital_root(int n) {
		
		if(n >= 10) {
			int sum = 0;
			while(n != 0) {
				sum += n % 10;
				n /= 10;
			}
			return digital_root(sum);
		} else {
			return n; 
		}
	}
}