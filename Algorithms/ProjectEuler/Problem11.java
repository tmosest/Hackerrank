package ProjectEuler;

import java.util.Scanner;

/**
 * Project Euler #11: Largest product in a grid 
 * Easy
 */
public class Problem11 {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int[][] grid = new int[20][20];
		
		for(int r = 0; r < 20; r++) 
			for(int c = 0; c < 20; c++)
				grid[r][c] = in.nextInt();
		
		in.close();
		
		int maxProduct = Integer.MIN_VALUE;
		
		for(int r = 0; r < 20; r++) {
			for(int c = 0; c < 20; c++) {
				int product = grid[r][c];
				//Look right
				for(int i = 1; i <= 3; i++) {
					if(c + i < 20) {
						product *= grid[r][c + i];
					} else {
						product = Integer.MIN_VALUE;
					}
				}
				if(product > maxProduct) maxProduct = product;
				//Look left
				product = grid[r][c];
				for(int i = 1; i <= 3; i++) {
					if(c - i > -1) {
						product *= grid[r][c - i];
					} else {
						product = Integer.MIN_VALUE;
					}
				}
				if(product > maxProduct) maxProduct = product;
				//Look up
				product = grid[r][c];
				for(int i = 1; i <= 3; i++) {
					if(r - i > -1) {
						product *= grid[r - i][c];
					} else {
						product = Integer.MIN_VALUE;
					}
				}
				if(product > maxProduct) maxProduct = product;
				//Look Down
				product = grid[r][c];
				for(int i = 1; i <= 3; i++) {
					if(r + i < 20) {
						product *= grid[r + i][c];
					} else {
						product = Integer.MIN_VALUE;
					}
				}
				if(product > maxProduct) maxProduct = product;
				//Look Diagnol up right
				product = grid[r][c];
				for(int i = 1; i <= 3; i++) {
					if(r - i > -1 && c + i < 20) {
						product *= grid[r - i][c + i];
					} else {
						product = Integer.MIN_VALUE;
					}
				}
				if(product > maxProduct) maxProduct = product;
				//Look Diagnol up left;
				product = grid[r][c];
				for(int i = 1; i <= 3; i++) {
					if(r - i > -1 && c - i > -1) {
						product *= grid[r - i][c - i];
					} else {
						product = Integer.MIN_VALUE;
					}
				}
				if(product > maxProduct) maxProduct = product;
				//Look Diagnol down right;
				product = grid[r][c];
				for(int i = 1; i <= 3; i++) {
					if(r + i < 20 && c + i < 20) {
						product *= grid[r + i][c + i];
					} else {
						product = Integer.MIN_VALUE;
					}
				}
				if(product > maxProduct) maxProduct = product;
				//Look Diagnol down left;
				product = grid[r][c];
				for(int i = 1; i <= 3; i++) {
					if(r + i < 20 && c - i > -1) {
						product *= grid[r + i][c - i];
					} else {
						product = Integer.MIN_VALUE;
					}
				}
				if(product > maxProduct) maxProduct = product;
			}
		}
		
		System.out.println(maxProduct);
	}

}
