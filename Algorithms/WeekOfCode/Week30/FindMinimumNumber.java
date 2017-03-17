package WeekOfCode.Week30;

import java.util.Scanner;

/**
 *	Algorithms -> Week of Code 30 -> Find the Minimum Number
 *	Easy
 */
public class FindMinimumNumber {
	
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        printMin(n);
    }
    
    public static void printMin(int n) {
        if(n == 2) {
            System.out.print("min(int, int)");
        } else {
            System.out.print("min(int, ");
            printMin(--n);
            System.out.print(")");
        }
    }
    
} // end class FindMinimumNumber
