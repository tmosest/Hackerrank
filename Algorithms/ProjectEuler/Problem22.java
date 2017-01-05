package ProjectEuler;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Project Euler #22: Names scores
 * Easy
 */
public class Problem22 {

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		
		String[] names = new String[n];
		
		for(int i = 0; i < n; i++) {
			names[i] = in.next();
		}
		
		Arrays.sort(names);
		
		HashMap<String, Integer> nameScores = new HashMap<String, Integer>();
		
		int i = 1;
		for(String s: names) {
			nameScores.put(s, i * scoreWord(s));
			i++;
		}
		
		int qs = in.nextInt();
		
		for(int q = 0; q < qs; q++) {
			System.out.println(nameScores.get(in.next()));
		}
		
		in.close();
	}
	
	public static int scoreWord(String s)
	{
		int score = 0;
		for(int i = 0; i < s.length(); i++)
			score += Character.toUpperCase(s.charAt(i)) - 'A' + 1;
		return score;
	}
}
