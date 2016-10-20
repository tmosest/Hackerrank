package Implementation;

import java.util.Scanner;

/**
 *	Algorithms -> Implementations -> Matrix Layer Rotation
 *	Hard
 */
public class MatrixLayerRotation {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int rows = in.nextInt();
		int columns = in.nextInt();
		int rotations = in.nextInt();
		//build matrix
		int[][] matrix = new int[rows][columns];
		for(int row_i = 0; row_i < rows; row_i++) {
			for (int col_j = 0; col_j < columns; col_j++) {
				matrix[row_i][col_j] = in.nextInt();
			}
		}
		in.close();
	}
	
	/*
	 * Psuedo Code:
	 * 
	 * 
	 * 
	 */
	public static int[][] rotateMatrix(int[][] matrix, int rotations)
	{
		int numRows = matrix.length;
		int numColumns = matrix[0].length;
		int[][] rotatedMatrix = new int[numRows][numColumns];
		
		return matrix;
	}

}
