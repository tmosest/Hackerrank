package Greedy;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

/**
 *	Algorithms ->  Greedy -> Cutting Boards
 *	Hard
 */
public class CuttingBoards {

	private static boolean debugMode = false;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int queries = in.nextInt();
		
		for(int q = 0; q < queries; q++) {
			
			int rows = in.nextInt();
			int columns = in.nextInt();
			
			long[] rowCosts = new long[rows];
			
			for(int row = 0; row < rows - 1; row++) {
				rowCosts[row] = in.nextLong();
			}
			
			long[] columnCosts = new long[columns];
			
			for(int column = 0; column < columns - 1; column++) {
				columnCosts[column] = in.nextLong();
			}
			
			Arrays.sort(rowCosts);
			Arrays.sort(columnCosts);
			
			int rowsCut = 1;
			int columnsCut = 1;
			
			int rowsIndex = rows - 1;
			int columnsIndex = columns - 1;
			
			//long totalCost = 0;
			BigInteger totalCost = BigInteger.ZERO;
			//long mod = (long) Math.pow(10, 9) + 7;
			BigInteger mod = new BigInteger("1000000007");
			
			while(rowsIndex >= 0 || columnsIndex >= 0) {
				//long cost = 0;
				BigInteger cost = BigInteger.ZERO;
				if(columnsIndex < 0 || (rowsIndex >= 0 && rowCosts[rowsIndex] > columnCosts[columnsIndex])) {
					//cost = (rowCosts[rowsIndex] % mod) * (columnsCut % mod);
					BigInteger rowCost = new BigInteger(String.valueOf(rowCosts[rowsIndex])).mod(mod);
					BigInteger columnCost = new BigInteger(String.valueOf(columnsCut)).mod(mod);
					cost = rowCost.multiply(columnCost);
					rowsCut++;
					rowsIndex--;
				} else if(columnsIndex >= 0) {
					//cost = (columnCosts[columnsIndex] % mod) * (rowsCut % mod);
					BigInteger columnCost = new BigInteger(String.valueOf(columnCosts[columnsIndex])).mod(mod);
					BigInteger rowCost = new BigInteger(String.valueOf(rowsCut)).mod(mod);
					cost = rowCost.multiply(columnCost);
					columnsCut++;
					columnsIndex--;
				} else {
					//break;
				}
				if(debugMode) 
					System.out.println("cost: " + cost);
				//totalCost += cost % mod;
				totalCost = totalCost.add(cost.mod(mod));
			}
			
			System.out.println(totalCost);
		}
		
		in.close();
	}

}
