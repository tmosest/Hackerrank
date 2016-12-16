package ProjectEuler;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Project Euler #13: Large sum  
 * Easy
 */
public class Problem13 {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
	    int length = in.nextInt(); 
	    in.nextLine();
	    BigInteger sum = new BigInteger("0");
	    String temp;
	    for(int x=0;x<length;x++){
	        temp = in.nextLine();
	        BigInteger tempInt = new BigInteger(temp);      
	        sum = sum.add(tempInt);
	    }
	    in.close();
	    String testString =  sum + "";
	    System.out.println(testString.substring(0,10));
	}
	
}
