package Implementation;

import java.util.Scanner;

/**
 *	Algorithms -> Implementations -> Modified Kaprekar Numbers
 *	Easy
 */
public class ModifiedKaprekarNumbers {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long start = in.nextLong();
		long end = in.nextLong();
		in.close();
		boolean foundKapa = false;
		for(long i = start; i <= end; i++) {
			boolean isKapa = isKaprekarNumber(i);
			if(isKapa) {
				System.out.print(i + " ");
				foundKapa = true;
			}
		}
		if(!foundKapa) System.out.println("INVALID RANGE");
	}
	
	public static boolean isKaprekarNumber(long num) {
		boolean result = false;
		long numSquared = num * num;
		String s = Long.toString(numSquared); //converting the square into a String
		 
	    if(num < 9)
	        s = "0"+s; //Adding a zero in the beginning if the square is of single digit
	 
	    int l = s.length(); //finding the length (i.e. no. of digits in the square).
	    int mid = l/2; //finding the middle point
	 
	    String left=s.substring(0,mid); //extracting the left digits from the square
	    String right=s.substring(mid); //extracting the right digits from the square
	 
	    int x = Integer.parseInt(left); //converting the left String into Integer
	    int y = Integer.parseInt(right); //converting the right String into Integer
	 
	    //if sum of left and right numbers is equal to the original number then it is a Kaprekar number
	    if(x + y == num) {
	     result = true;
	    }
	    return result;
	}

}
