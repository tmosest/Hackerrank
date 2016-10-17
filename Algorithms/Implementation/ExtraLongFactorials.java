package Implementation;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *	Algorithms -> Implementations -> Extra Long Factorials
 *	Medium
 */
public class ExtraLongFactorials {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.close();
        BigInteger result = calculateFacotrial(n);
        System.out.println(result);
	}
	
	public static BigInteger calculateFacotrial(int num) 
	{
		BigInteger bigNum = new BigInteger(String.valueOf(num));
		for(int i = num - 1; i > 1; i--) {
			BigInteger bigI = new BigInteger(String.valueOf(i));
			bigNum = bigNum.multiply(bigI);
		}
		return bigNum;
	}
	
}
