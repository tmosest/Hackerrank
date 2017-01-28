package CodeWars;

import java.math.BigInteger;

/**
 * Large Factorials
 * @author tmosest
 */
public class Kata
{
  public static String Factorial(int n)
  {
	if(n < 0)
		return null;
	
	if(n <= 1) {
		return "1";
	}
	
	BigInteger factorial = BigInteger.ONE;
	BigInteger num = new BigInteger(String.valueOf(n));
	
	for(BigInteger i = new BigInteger("2"); i.compareTo(num) <= 0; i = i.add(BigInteger.ONE)) {
		factorial = factorial.multiply(i);
	}
	
    return factorial.toString();
  }
}
