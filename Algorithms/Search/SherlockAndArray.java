package Search;

import java.util.Scanner;

/**
 *	Algorithms -> Search -> Sherlock and Array 
 *	Easy
 *
 * Sample Input:
   2
   3
   1 2 3
   4
   1 2 3 3
 *
 * Sample Output:
   NO
   YES
 */
public class SherlockAndArray {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int numCases = in.nextInt();
		for(int i = 0; i < numCases; i++) {
			int arraySize = in.nextInt();
			//System.out.println("arraySize: " +  arraySize);
			int[] array = new int[arraySize];
			
			for(int a_i = 0; a_i < arraySize; a_i++) {
				array[a_i] = in.nextInt();
			}
			
			boolean isSpecial = doesArrayContainSpecialElement(array);
			
			String answer = "NO";
			if(isSpecial) {
				answer = "YES";
			}
			System.out.println(answer);
		}
		
		in.close();
	}
	
	/**
	 * Functions loops through an array and checks if the left side sum of the array equals the right side sume (not including the element).
	 * @param array
	 * @return
	 */
	public static boolean doesArrayContainSpecialElement(int[] array)
	{
		boolean containsSpecial = false;
		
		if(array.length == 1) {
			//if length is 1 then right and left side are both null anyway;
			containsSpecial = true;
		} else {
			
			int leftSum = 0, rightSum = 0;
			
			//Set right sum equal to the total sum
			for(int i = 1; i < array.length; i++) {
				rightSum += array[i];
			}
			
			//Loop through each element and test
			for(int i = 1; i < array.length; i++) {
				leftSum += array[i - 1];
				rightSum -= array[i];
				//System.out.println("Left Sum: " + leftSum);
				//System.out.println("Right Sum: " + rightSum);
				if(leftSum == rightSum) {
					containsSpecial = true;
					break;
				}
			}
		}
		
		return containsSpecial;
	}
}
