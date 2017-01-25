package CodeWars;

/**
 * Money, Money, Money!
 * @author tmosest
 *
 */
public class Money {
	 public static int calculateYears(double principal, double interest,  double tax, double desired) {
		 int years = 0;
		 
		 while(principal < desired) {
			 years++;
			 principal = principal + interest * principal - principal * tax * interest;
		 }
		 
		 return years;
	 }
}
