package Implementation;

import java.util.Scanner;

/**
 *	Algorithms -> Implementations -> Viral Advertising
 *	Easy
 */
public class ViralAdvertising {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int numDays = in.nextInt();
		in.close();
		int count = calculateTheNumberOfPeopleWhoSeeOnNthDay(numDays);
		System.out.println(count);
	}
	
	public static int calculateTheNumberOfPeopleWhoSeeOnNthDay(int numDays)
	{
		int like = 0;
		int startLikes = 5;
		for(int i=1; i <= numDays; i++) {
	        like = like + (startLikes / 2);
	        startLikes = (startLikes / 2) * 3;
	    }
		return like;
	}
}
