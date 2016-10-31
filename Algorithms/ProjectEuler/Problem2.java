package ProjectEuler;

import java.util.Scanner;

/**
 * Project Euler #2: Even Fibonacci numbers
 * Easy
 */
public class Problem2 {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long testCases = in.nextLong();
        for(long i = 0; i < testCases; i++) {
            long sum = 2;
            long fib1 = 1;
            long fib2 = 2;
            long testCase = in.nextLong();
            if(testCase <= 2) {
                System.out.println(sum);
            } else {
                long fib = 0;
                while((fib1 + fib2) < testCase) {
                    fib = fib1 + fib2;
                    fib1 = fib2;
                    fib2 = fib;
                    if(fib%2==0) {
                      sum += fib;
                      //System.out.println(fib);
                    } 
                }
                System.out.println(sum);
            }
        }
        in.close();
    }
}