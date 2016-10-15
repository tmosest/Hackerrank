package Warmup;
import java.util.*;
/**
 *	Algorithms -> Warmup -> Simple Array Sum
 *	Easy (Super Easy)
 */
public class SimpleArraySum {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for(int arr_i=0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        in.close();
        int result = sumArray(arr);
        System.out.println(result);
	}
	
	public static int sumArray(int[] array)
	{
		int sum = 0;
		for(int i = 0; i < array.length; i++) 
			sum += array[i];
		return sum;
	}

}
