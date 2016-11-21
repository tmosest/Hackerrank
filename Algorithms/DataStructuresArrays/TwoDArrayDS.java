package DataStructuresArrays;

import java.util.Scanner;

public class TwoDArrayDS {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int arr[][] = new int[6][6];
        for(int arr_i=0; arr_i < 6; arr_i++){
            for(int arr_j=0; arr_j < 6; arr_j++){
                arr[arr_i][arr_j] = in.nextInt();
            }
        }
        in.close();
        int max = calculateLargestHourGlass(arr);
        System.out.println(max);
	}
	
	public static int calculateLargestHourGlass(int[][] matrix)
	{
		int max = 0;
		
		for(int row = 1; row < matrix.length - 1; row++) {
			
			for(int col = 1; col < matrix[0].length - 1; col++) {
				
				int hourglassSum = matrix[row -1][col - 1] + matrix[row - 1][col] + matrix[row - 1][col + 1] +
															 matrix[row][col] +
								   matrix[row + 1][col - 1] + matrix[row + 1][col] + matrix[row + 1][col + 1];
				
				if(row == 1 && col == 1) {
					max = hourglassSum;
				} else {
					if(hourglassSum > max) {
						max = hourglassSum;
					}
				}
						
			} // end for col
			
		}// end for row
		
		return max;
	}
}
