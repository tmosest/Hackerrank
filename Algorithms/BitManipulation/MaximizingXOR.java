package BitManipulation;

import java.util.Scanner;

/**
 *	Algorithms -> Bit Manipulation -> Maximizing XOR
 *	Easy
 */
public class MaximizingXOR {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
	    
		int num1 = in.nextInt();
	    int num2 = in.nextInt();
	    
	    in.close();
	    
	    int s = num1 ^ num2;
	    int count = 0;
	    
	    while(s > 0) {
	        ++count;
	        s >>= 1;
	    }
	    
	    int result = 1;
	    
	    result <<= count;
	    result-= 1;
	    
	    System.out.println(result);
	}

}
