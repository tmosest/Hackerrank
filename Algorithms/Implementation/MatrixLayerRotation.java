package Implementation;

import java.util.ArrayList;
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
		int[][] matrix = new int[rows][columns];
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < columns; j++) {
				matrix[i][j] = in.nextInt();
			}
		}
		in.close();
		matrix = rotateMatrix(matrix, rotations);
		print2DArray(matrix);
	}
	
	public static int[][] rotateMatrix(int[][] matrix, int rotations)
	{
		ArrayList<int[]> cyclicGroups = convertToCyclicGroups(matrix);
		cyclicGroups = shiftCyclicGroups(cyclicGroups, rotations);
		matrix = converToMatrix(cyclicGroups, matrix.length, matrix[0].length);
		return matrix;
	}
	
	public static int[][] converToMatrix(ArrayList<int[]> cyclicGroups, int rows, int columns)
	{
		int k = 0;
		
		int[][] matrix = new int[rows][columns];
		
		for(int[] cyclicGroup : cyclicGroups) {
			
			int[] topLeft = {0 + k, 0 + k};
			int[] botLeft = {(rows - 1) - k, 0 + k};
			int[] topRight = {0 + k, (columns - 1) - k};
			int[] botRight = {(rows - 1) - k, (columns - 1) - k};
			
			int diffTopBotLeft = botLeft[0] - topLeft[0];
			int diffBotLeftBotRight = botRight[1] - botLeft[1];
			int diffBotRightTopRight = topRight[0] - botRight[0];
			int diffTopRightTopLeft = topLeft[1] - topRight[1];
			
			int i = topLeft[0];
			int j = topLeft[1];
			
			for(int c : cyclicGroup) {
				matrix[i][j] = c;
				if(diffTopBotLeft != 0) {
					i++;
					diffTopBotLeft--;
				} else if(diffBotLeftBotRight != 0) {
					j++;
					diffBotLeftBotRight--;
				} else if(diffBotRightTopRight != 0) {
					i--;
					diffBotRightTopRight++;
				} else {
					j--;
					diffTopRightTopLeft++;
				}
			}
			
			k++;
		}
		return matrix;
	}
	
	public static ArrayList<int[]> shiftCyclicGroups(ArrayList<int[]> cyclicGroups, int rotations) 
	{
		ArrayList<int[]> shiftedCyclidGroups = new ArrayList<int[]>();
		for(int[] cyclicGroup : cyclicGroups) {
			//print1DArray(cyclicGroup);
			int[] shiftedCyclicGroup = new int[cyclicGroup.length];
			for(int i = 0; i < cyclicGroup.length; i++) {
				int shiftedValue = (i + rotations) % cyclicGroup.length;
				shiftedCyclicGroup[shiftedValue] = cyclicGroup[i];
			}
			//print1DArray(shiftedCyclicGroup);
			shiftedCyclidGroups.add(shiftedCyclicGroup);
		}
		return shiftedCyclidGroups;
	}
	
	public static ArrayList<int[]> convertToCyclicGroups(int[][] matrix)
	{
		//Know that size of each is (rows - 1) * 2 + (columns - 1) * 2 = (rows - (2k+1)) with k = 0
		//then (rows - 3) * 2 + (columns - 3) * 2 until that is smaller than or equal to zero.
		//so 0 = (rows - (2k + 1)) * 2 + (columns - (2k + 1)) * 2
		int k = 0;
		int rows = matrix.length;
		int columns = matrix[0].length;
		int formula = 1;
		
		ArrayList<int[]> cyclicGroups = new ArrayList<int[]>();
		int end = Math.min(columns, rows);
		while(formula > 0) {
			formula = (rows - (2 * k + 1)) * 2 + (columns - (2 * k + 1)) * 2;
			//System.out.println(formula);
			if(formula > 0) {
				int[] cyclicGroup = new int[formula];
				
				int[] topLeft = {0 + k, 0 + k};
				int[] botLeft = {(rows - 1) - k, 0 + k};
				int[] topRight = {0 + k, (columns - 1) - k};
				int[] botRight = {(rows - 1) - k, (columns - 1) - k};
				
				int diffTopBotLeft = botLeft[0] - topLeft[0];
				int diffBotLeftBotRight = botRight[1] - botLeft[1];
				int diffBotRightTopRight = topRight[0] - botRight[0];
				int diffTopRightTopLeft = topLeft[1] - topRight[1];
				
				if(diffTopBotLeft <= 0 || diffBotLeftBotRight <= 0 || 
				   diffBotRightTopRight >= 0 || diffTopRightTopLeft >= 0) {
					break;
				}
				
				int count = 0;
				int i = topLeft[0];
				int j = topLeft[1];
				
				while(count < formula) {
					cyclicGroup[count] = matrix[i][j];
					if(diffTopBotLeft != 0) {
						i++;
						diffTopBotLeft--;
					} else if(diffBotLeftBotRight != 0) {
						j++;
						diffBotLeftBotRight--;
					} else if(diffBotRightTopRight != 0) {
						i--;
						diffBotRightTopRight++;
					} else if(diffTopRightTopLeft != 0){
						j--;
						diffTopRightTopLeft++;
					}
					count++;
				}
				
				//print1DArray(cyclicGroup);
				cyclicGroups.add(cyclicGroup);
			}
			k++;
		}
		
		//System.out.println(k);
		return cyclicGroups;
	}
	
	public static void print1DArray(int[] array)
	{
		System.out.println("");
		for(int a : array) {
			System.out.print(a + " ");
		}
		System.out.println("");
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
