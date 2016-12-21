package WeekOfCode.Week27;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *	Algorithms -> Week of Code 27 -> Hackonacci Matrix Rotations
 *	Medium
 */
public class HackonacciMatrixRotations {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		HackonacciMatrix hm = new HackonacciMatrix(n);
		
		int queries = in.nextInt();
		
		for(int q = 0; q < queries; q++) {
			hm.rotateMatrix(in.nextInt());
			System.out.println(hm.calculateDifference());
		}
		
		in.close();
	}
	
	/**
	 * A class to generate a Hackonacci Matrix
	 * Each character in the n by n matrix is either X or Y depending.
	 * if hackonacci( (i * j) ^ 2) is even then X otherwise Y;
	 * Also the indicies for the array are from 1 to n (not 0 to n-1)
	 * @author Tyler Moses
	 *
	 */
	private static class HackonacciMatrix
	{
		//Store the matrix
		private char[][] hackonacciMatrix;
		private char[][] rotatedHackonacciMatrix;
		
		//Should just use a precomputed array of hackonaccis
		private long[] hackonacciArray;
		
		public HackonacciMatrix(int n)
		{
			hackonacciMatrix = new char[n][n];
			
			this.fillHackonacciArray();
			
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					int number = (int) Math.pow((i + 1) * (j + 1), 2);
					if( hackonacciArray[ number - 1 ] % 2 == 0) {
						hackonacciMatrix[i][j] = 'X';
					} else {
						hackonacciMatrix[i][j] = 'Y';
					}
				}
			}
			hackonacciArray = null;
		}
		
		/**
		 * Determines the difference between rotated and non rotated array
		 * @return
		 */
		public int calculateDifference()
		{
			int count = 0;
			
			int n = hackonacciMatrix.length;
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(rotatedHackonacciMatrix[i][j] != hackonacciMatrix[i][j])
						count++;
				}
			}
			
			return count;
		}
		
		/**
		 * Print the Hackonacci Matrix
		 */
		public void print()
		{
			int n = hackonacciMatrix.length;
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					System.out.print(hackonacciMatrix[i][j] + " ");
				}
				System.out.println("");
			}
		}
		
		/**
		 * Print the Rotated Hackonacci Matrix
		 */
		public void printRotated()
		{
			int n = rotatedHackonacciMatrix.length;
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					System.out.print(rotatedHackonacciMatrix[i][j] + " ");
				}
				System.out.println("");
			}
		}
		
		/**
		 * A better way to compute the hackonacci using an array
		 * @param n
		 * @return
		 */
		public void fillHackonacciArray()
		{
			int n = hackonacciMatrix.length;
			int n4 = n * n * n * n;
			
			hackonacciArray = new long[n4];
			
			hackonacciArray[0] = 1;
			hackonacciArray[1] = 2;
			hackonacciArray[2] = 3;
			
			for(int i = 3; i < n4; i++) {
				hackonacciArray[i] = hackonacciArray[i - 1] + 2 * hackonacciArray[i - 2] + 3 * hackonacciArray[i - 3];
			}
		}
		
		/*
		 * 
		 */
		public void rotateMatrix(int degrees)
		{
			degrees /= 90;
			rotatedHackonacciMatrix = rotateMatrix(hackonacciMatrix, degrees);
		}
		
		/**
		 * Compute the hackonacci of a number
		 * @param n
		 * @return
		 */
		public static long hackonacci(long n)
		{
			if(n == 1)
				return 1;
			if(n == 2)
				return 2;
			if(n == 3)
				return 3;
			return hackonacci(n - 1) + 2 * hackonacci(n - 2) + 3 * hackonacci(n - 3);
		}
		
		public static char[][] rotateMatrix(char[][] matrix, int rotations)
		{
			ArrayList<char[]> cyclicGroups = convertToCyclicGroups(matrix);
			cyclicGroups = shiftCyclicGroups(cyclicGroups, rotations);
			matrix = converToMatrix(cyclicGroups, matrix.length, matrix[0].length);
			return matrix;
		}
		
		public static char[][] converToMatrix(ArrayList<char[]> cyclicGroups, int rows, int columns)
		{
			int k = 0;
			
			char[][] matrix = new char[rows][columns];
			
			for(char[] cyclicGroup : cyclicGroups) {
				
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
				
				for(char c : cyclicGroup) {
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
		
		public static ArrayList<char[]> shiftCyclicGroups(ArrayList<char[]> cyclicGroups, int rotations) 
		{
			ArrayList<char[]> shiftedCyclidGroups = new ArrayList<char[]>();
			for(char[] cyclicGroup : cyclicGroups) {
				//print1DArray(cyclicGroup);
				char[] shiftedCyclicGroup = new char[cyclicGroup.length];
				for(int i = 0; i < cyclicGroup.length; i++) {
					int shiftedValue = (i + rotations) % cyclicGroup.length;
					shiftedCyclicGroup[shiftedValue] = cyclicGroup[i];
				}
				//print1DArray(shiftedCyclicGroup);
				shiftedCyclidGroups.add(shiftedCyclicGroup);
			}
			return shiftedCyclidGroups;
		}
		
		public static ArrayList<char[]> convertToCyclicGroups(char[][] matrix)
		{
			//Know that size of each is (rows - 1) * 2 + (columns - 1) * 2 = (rows - (2k+1)) with k = 0
			//then (rows - 3) * 2 + (columns - 3) * 2 until that is smaller than or equal to zero.
			//so 0 = (rows - (2k + 1)) * 2 + (columns - (2k + 1)) * 2
			int k = 0;
			int rows = matrix.length;
			int columns = matrix[0].length;
			int formula = 1;
			
			ArrayList<char[]> cyclicGroups = new ArrayList<char[]>();
			int end = Math.min(columns, rows);
			while(formula > 0) {
				formula = (rows - (2 * k + 1)) * 2 + (columns - (2 * k + 1)) * 2;
				//System.out.println(formula);
				if(formula > 0) {
					char[] cyclicGroup = new char[formula];
					
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
	}
}
