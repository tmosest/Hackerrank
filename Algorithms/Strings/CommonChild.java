package Strings;

import java.util.Scanner;

/**
 *	Algorithms -> Strings -> Common Child
 *	Hard
 */
public class CommonChild {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String word1 = in.nextLine();
		String word2 = in.nextLine();
		in.close();
		int length = computeLCSlength(word1, word2);
		System.out.println(length);
	}

	public static int computeLCSlength(String word1, String word2) {
		int m = word1.length();
		int n = word2.length();
		
		int[][] LCS = new int[m + 1][n + 1];
		
		for(int i = 0; i < m + 1; i++)
			LCS[i][0] = 0;
		
		for(int j = 0; j < n + 1; j++)
			LCS[0][j] = 0;
		
		for(int i = 1; i < m + 1; i++) {
			for(int j = 1; j < n + 1; j++) {
				if(word1.charAt(i - 1)  == word2.charAt(j - 1)) {
					//System.out.println(word1.charAt(i - 1));
					LCS[i][j] = ++LCS[i - 1][j - 1];
				} else {
					LCS[i][j] = Math.max(LCS[i][j - 1], LCS[i - 1][j]);
				}
			}
		}
		
		//print2DArray(LCS);
			
		return LCS[m][n];
	}

	public static void print2DArray(int[][] grid)
	{
		for(int[] array: grid) {
			for(int d: array) {
				System.out.print(d + " ");
			}
			System.out.println("");
		}
	}
}
