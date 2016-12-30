package AdInfinitum.Math17;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 *	Algorithms -> Ad Infinitum 17  -> Primitive Problem
 *	Easy
 */
public class PrimitiveProblem {

	private static boolean debugMode = true;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int prime = in.nextInt();
		in.close();
		int smallest = findSmallestPrimitiveRoot(prime);
		System.out.print(smallest + " ");
	}

	public static int findSmallestPrimitiveRoot(int prime)
	{
		int smallestRoot = Integer.MAX_VALUE;
		for(int i = 2; 1 < prime; i++) {
			Set<Integer> powers = new HashSet<Integer>();
			for(int a = 0; a < prime - 1; a++) {
				int power = (int) Math.pow(i, a);
				if(debugMode)
					System.out.println(i + "^" + a + " = " + power);
				if(powers.contains(power)) {
					break;
				} else {
					powers.add(power);
				}
				boolean containsPowers = true;
				for(int j = 1; 1 < prime; i++) {
					if(!powers.contains(j)) {
						containsPowers = false;
						break;
					}
				}
				if(containsPowers) {
					smallestRoot = Math.min(smallestRoot, i);
					break;
				}
			}
		}
		return smallestRoot;
	}
}
