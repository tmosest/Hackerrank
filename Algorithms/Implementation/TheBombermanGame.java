package Implementation;

import java.util.Scanner;

/**
 *	Algorithms -> Implementations -> The Bomberman Game
 *	Medium
 */
public class TheBombermanGame {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int rows = in.nextInt();
		int columns = in.nextInt();
		int time = in.nextInt();
		char[][] grid = new char[rows][columns];
		char[][] fullGrid = new char[rows][columns];
		for(int i = 0; i < rows; i++) {
			String line = in.next();
			for(int j = 0; j < columns; j++) {
				grid[i][j] = line.charAt(j);
				fullGrid[i][j] = 'O';
			}
		}
		char[][] holderGrid = fullGrid.clone();
		for(int k = 2; k <= time; k++) {
			if(k % 2 == 0) {
				for(int i = 0; i < rows; i++) {
					for(int j = 0; j < columns; j++) {
						holderGrid[i][j] = 'O';
					}
				}
				if(time % 2 == 0) break;
			}
			if((k == 3) || (k > 3 && k % 2 == 1)) {
				for(int i = 0; i < rows; i++) {
					for(int j = 0; j < columns; j++) {
						if(grid[i][j] == 'O') {
							holderGrid[i][j] = '.';
							if( i != (rows - 1) ) 		holderGrid[i + 1][j] = '.';
							if( i != 0 ) 		  		holderGrid[i - 1][j] = '.';
							if( j != (columns - 1) ) 	holderGrid[i][j + 1] = '.';
							if( j != 0 )				holderGrid[i][j - 1] = '.';
						}
					}
				}
				if( ((time - 3) % 4 == 0) && k == 3) break;
				if( ((time - 5) % 4 == 0) && k == 5) break;
				for(int i = 0; i < rows; i++) {
					for(int j = 0; j < columns; j++) {
						grid[i][j] = holderGrid[i][j];
					}
				}
			}
		}
		//Print
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < columns; j++) {
				if(time != 1) {
					System.out.print(holderGrid[i][j]);
				} else {
					System.out.print(grid[i][j]);
				}
			}
			System.out.print("\n");
		}
		in.close();
	}

}
