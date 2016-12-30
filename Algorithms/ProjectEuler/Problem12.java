package ProjectEuler;

import java.util.Scanner;

/**
 * Project Euler #12: Highly divisible triangular number 
 * Easy
 */
public class Problem12 {
	private static boolean debugMode = false;
	
	private static int numberOfDivisorsLimit = 1000;
	private static int[] numberOfDivisors = new int[numberOfDivisorsLimit + 1];
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		generateTriangleDivisors();
		
		int cases = in.nextInt();
		
		for(int c = 0; c < cases; c++) {
			int divisorsToCheckFor = in.nextInt();
			System.out.println(findDivisors(divisorsToCheckFor));
		}
		
		in.close();
	}
	
	private static int findDivisors(int num) {
		for(int i = num; i < numberOfDivisorsLimit; i++)
			if(numberOfDivisors[i] != 0) return numberOfDivisors[i];
		return num;
	}
	
	public static void generateTriangleDivisors()
	{
		int numDivisors = 0;
		int nthTriangleNumber = 1;
		int triangleNumber = 0;
		while(numDivisors <= numberOfDivisorsLimit) {
			triangleNumber = triangleNumber(nthTriangleNumber);
			numDivisors = countDivisors(triangleNumber);
			if(debugMode)
				System.out.println("triangle num: " + triangleNumber + " #divisors: " + numDivisors);
			if(numDivisors <= numberOfDivisorsLimit && numberOfDivisors[numDivisors] == 0) {
				numberOfDivisors[numDivisors] = triangleNumber;
			}
			nthTriangleNumber++;
		}
	}
	
	private static int countDivisors(int num)
	{
		if(num % 2 == 0) num = num / 2;
		
		int divisors = 1;
		int count = 0;
		
		while(num % 2 == 0) {
			count += 1;
			num = num / 2;
		}
		divisors *= (count + 1);
		
		int p = 3;
		while(num != 1) {
			count = 0;
			while(num % p == 0) {
				count += 1;
				num = num / p;
			}
			divisors *= (count + 1);
			p += 2;
		}
		return divisors;
	}
	
	/**
	 * Generate nth triangle number using Gauss sum
	 * @param nth
	 * @return
	 */
	private static int triangleNumber(int nth)
	{
		return ((nth) * (nth + 1)) / 2;
	}
}