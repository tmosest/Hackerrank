package Implementation;

import java.util.Scanner;

/**
 *	Algorithms -> Implementations -> Beautiful Days at the Movies
 *	Easy
 */
public class BeautifulDaysAtTheMovies {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int startDay = in.nextInt();
		int endDay = in.nextInt();
		int k = in.nextInt();
		
		in.close();
		
		int count = calculateTheNumberOfBeautifulDays(startDay, endDay, k);
		System.out.println(count);
	}

	public static int calculateTheNumberOfBeautifulDays(int startdate, int enddate, int divisibilityFactor)
	{
		int count = 0;
		
		for(int day = startdate; day <= enddate; day++) {
			if(isBeautifulDayModK(day, divisibilityFactor)) count++;
		}
		
		return count;
	}
	
	public static boolean isBeautifulDayModK(int day, int k)
	{
		int reversed =  reverseInteger(day);
		return (day - reversed) % k == 0;
	}
	
	public static int reverseInteger(int number)
	{
		int reversed = 0;
		
		char[] numToString = String.valueOf(number).toCharArray();
		char[] reversedArray = new char[numToString.length];
		
		for(int i = 0; i < numToString.length; i++) {
			reversedArray[numToString.length - i - 1] = numToString[i];
		}
		
		reversed = Integer.parseInt(String.valueOf(reversedArray));
		
		return reversed;
	}
}
