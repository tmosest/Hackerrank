package WeekOfCode.Week27;

import java.math.BigInteger;
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
			System.out.println(hm.calculateDifference(in.nextLong()));
		}
		
		in.close();
		
		//HackonacciMatrix.rotateMatrixTest(5);
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
		int[] differences;
		
		public HackonacciMatrix(int n)
		{
			hackonacciMatrix = new char[n][n];
			
			differences = new int[3];
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					BigInteger number = new BigInteger(String.valueOf(i + 1));
					number = number.multiply(new BigInteger(String.valueOf(j + 1)));
					number = number.multiply(number);
					if(isHackonacciEven(number)) {
						hackonacciMatrix[i][j] = 'X';
					} else {
						hackonacciMatrix[i][j] = 'Y';
					}
				}
			}
			
			calculateDifferences();
		}
		
		public int calculateDifference(long degrees)
		{
			int answer = 0;
			if(degrees % 360 == 90) {
				answer = differences[0];
			} else if(degrees % 360 == 180) {
				answer = differences[1];
			} else if(degrees % 360 == 270) {
				answer = differences[2];
			}
			return answer;
		}
		
		/**
		 * Determines the difference between rotated and non rotated array.
		 * // 90 degree
		 * test90[i][j] =  test[n - j - 1][i];
		 * // 180 degree
		 * test180[i][j] = test[n - i - 1][n - j - 1];
		 * // 270 degree
		 * test270[i][j] = test[j][n - i - 1];
		 * @return
		 */
		private void calculateDifferences()
		{
			int n = hackonacciMatrix.length;
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					// 90 degree
					if(hackonacciMatrix[i][j] != hackonacciMatrix[n - j - 1][i]) 
						differences[0] += 1;
					// 180 degree
					if(hackonacciMatrix[i][j] != hackonacciMatrix[n - i - 1][n - j - 1]) 
						differences[1] += 1;
					// 270 degree
					if(hackonacciMatrix[i][j] != hackonacciMatrix[j][n - i - 1])
						differences[2] += 1;
				}
			}
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
		 * Determines if a hackonacci number is even using a nice repitition fact.
		 * h(1) : F
		 * h(2) : T
		 * h(3) : F
		 * h(4) : T
		 * h(5) : T
		 * h(6) : F
		 * h(7) : F
		 * This repeats over and over again.
		 * @param num
		 * @return
		 */
		public static boolean isHackonacciEven(long num)
		{
			boolean isEven = false;
			
			boolean hackonacciCheck = (num % 7 == 2) || (num % 7 == 4) || (num % 7 == 5);
			
			if(hackonacciCheck) isEven = true;
			
			return isEven;
		}
		
		public static boolean isHackonacciEven(BigInteger num)
		{
			boolean isEven = false;
			
			boolean hackonacciCheck = 
					(num.mod(new BigInteger("7")).compareTo(new BigInteger("2")) == 0) || 
					(num.mod(new BigInteger("7")).compareTo(new BigInteger("4")) == 0) || 
					(num.mod(new BigInteger("7")).compareTo(new BigInteger("7")) == 0);
			
			if(hackonacciCheck) isEven = true;
			
			return isEven;
		}
		
		/**
		 * Compute the hackonacci of a number.
		 * This uses the slow version.
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
		
		public static void rotateMatrixTest(int n)
		{
			int[][] test = new int[n][n];
			int[][] test90 = new int[n][n];
			int[][] test180 = new int[n][n];
			int[][] test270 = new int[n][n];
			
			int count = 0;
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					test[i][j] = count++;
				}
			}
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					// 90 degree
					test90[i][j] =  test[n - j - 1][i];
					// 180 degree
					test180[i][j] = test[n - i - 1][n - j - 1];
					// 270 degree
					test270[i][j] = test[j][n - i - 1];
				}
			}
			
			System.out.println("Original:");
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					System.out.print(test[i][j] + " ");
				}
				System.out.println("");
			}
			System.out.println("");

			System.out.println("90:");
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					System.out.print(test90[i][j] + " ");
				}
				System.out.println("");
			}
			System.out.println("");
			
			System.out.println("180");
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					System.out.print(test180[i][j] + " ");
				}
				System.out.println("");
			}
			System.out.println("");
			
			System.out.println("270");
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					System.out.print(test270[i][j] + " ");
				}
				System.out.println("");
			}
			System.out.println("");
		}
	}
}
