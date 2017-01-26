package CodeWars;

/**
 * Factorial
 * @author tmosest
 */
public class Factorial {

	  public int factorial(int n) {
		if(n < 0 || n > 12) throw new IllegalArgumentException();
	    
		int factorial = 1;
		for(int i = 2; i <= n; i++) {
			factorial *= i;
		}
		
	    return factorial;
	  }
}