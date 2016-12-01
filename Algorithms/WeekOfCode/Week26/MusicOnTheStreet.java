package WeekOfCode.Week26;

import java.util.Scanner;

/**
 *	Algorithms -> Week of Code 26 -> Music on the Street
 *	Hard
 */
public class MusicOnTheStreet {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int arraySize = in.nextInt();
		
		int[] stops = new int[arraySize];
		
		for(int i = 0; i < stops.length; i++) {
			stops[i] = in.nextInt();
		}
		
		int miles = in.nextInt();
		
		int leastTime = in.nextInt();
		
		int mostTime = in.nextInt();
		
		in.close();
		
		int timeLeft = miles - (stops[stops.length - 1] - stops[0]);
		
		if(timeLeft <= 0) throw new Error();
		
		int difference = (int) Math.ceil((double) timeLeft / 2);
		
		int startPoint = stops[0] - difference;
		
		System.out.println(startPoint);
	}

}
