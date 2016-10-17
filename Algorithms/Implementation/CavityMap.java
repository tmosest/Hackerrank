package Implementation;

import java.util.Scanner;

/**
 *	Algorithms -> Implementations -> Cavity Map
 *	Easy
 */
public class CavityMap {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        char[][] grid = new char[n][n];
        for(int grid_i = 0; grid_i < n; grid_i++){
        	String input = in.next();
        	for(int grid_j=0; grid_j < n; grid_j++){
        		grid[grid_i][grid_j] = input.charAt(grid_j);
        	}
        }
        in.close();
        char[][] result = mapCavity(grid);
        for(int i = 0; i < n; i++) {
        	char[] a = new char[n];
			for(int j = 0; j < n; j++) {
				a[j] = result[i][j];
			}
			System.out.println(String.valueOf(a));
		}
	}
	
	public static char[][] mapCavity(char[][] depthGrid) 
	{
		char[][] holderGrid = new char[depthGrid.length][depthGrid.length];
		for(int i = 1; i < depthGrid.length-1; i++) {
			for(int j = 1; j < depthGrid.length-1; j++) {
				if( 
						Character.getNumericValue(depthGrid[i][j]) > Character.getNumericValue(depthGrid[i+1][j]) &&
						Character.getNumericValue(depthGrid[i][j]) > Character.getNumericValue(depthGrid[i-1][j]) &&
						Character.getNumericValue(depthGrid[i][j]) > Character.getNumericValue(depthGrid[i][j+1]) &&
						Character.getNumericValue(depthGrid[i][j]) > Character.getNumericValue(depthGrid[i][j-1]) 
				) {
					holderGrid[i][j] = 'X';
				}
			}
		}
		for(int i = 1; i < depthGrid.length-1; i++) {
			for(int j = 1; j < depthGrid.length-1; j++) {
				if(holderGrid[i][j] == 'X') depthGrid[i][j] = 'X';
			}
		}
		return depthGrid;
	}
	

}
