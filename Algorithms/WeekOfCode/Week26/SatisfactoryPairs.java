package WeekOfCode.Week26;


import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Scanner;

/**
 *	Algorithms -> Week of Code 26 -> Satisfactory Pairs
 *	Hard
 *  
 *  Helpful resources:
 *  http://zimmer.csufresno.edu/~lburger/Math149_diophantine%20I.pdf
 *  http://www.oxfordmathcenter.com/drupal7/node/59
 *  
 */
public class SatisfactoryPairs {
	private static long startTime, endTime, totalTime;
	public static boolean debugMode, timeMode, solutionTestMode;
	public static int u1, u2;
	public static HashMap<Integer, Integer> freq, freqXY;
	
	public static void main(String[] args) {
		debugMode = true;
		timeMode = true;
		solutionTestMode = true;
		
		Scanner in = new Scanner(System.in);
		
		int number = in.nextInt();
		
		in.close();
		
		if(timeMode)
			startTime = System.currentTimeMillis();
		
		if(debugMode) 
			System.out.println("\nCounting (a,b) solution to a * x + b * y = " + number + "\n");
		
		long solutions = countSolutionsToTheLinearDiophantineEquation(number);
		
		System.out.println(solutions);
		
		 if(timeMode) {
			 endTime   = System.currentTimeMillis();
	         totalTime = endTime - startTime;
	         NumberFormat formatter = new DecimalFormat("#0.00000");
	         System.out.println("Execution time is " + formatter.format((totalTime) / 1000d) + " seconds\n");
	     }
		 
		 if(debugMode) {
			 for(int a : freq.keySet()) {
				 System.out.print(" " + a + " : " + freq.get(a) + " ");
			 }
			 System.out.println("");
			 for(int a : freqXY.keySet()) {
				 System.out.print(" " + a + " : " + freqXY.get(a) + " ");
			 }
		 }
	}

	/**
	 * Counting (a,b) solution to
	 * a * x + b * y = number
	 */
	public static long countSolutionsToTheLinearDiophantineEquation(int number)
	{
		if(debugMode) {
			freq = new HashMap<Integer, Integer> ();
			freqXY = new HashMap<Integer, Integer> ();
		}
		
		long count = 0;
		int a, b, c, x, y, x1, y1, t;
		
		// Find first possible solution
		for(int i = 1; i < number - 1; i++) {
			for(int j = i + 1; j < number; j++) {
				// if the gcd of i and j divide number then that is a solution.
				int gcd = linearCombinationGCD(i,j);
				if(number % gcd == 0) {
					a = i;
					b = j;
					c = number/ gcd;
					
					x1 = c * u1;
					y1 = c * u2;
					
					t = 0;
					for(; t < number; t++) {
						if(u1 < u2) {
							x = x1 + (b/gcd) * t;
							y = y1 - (a/gcd) * t;
							if(y < 0) {
								break;
							}
						} else {
							x = x1 - (b/gcd) * t;
							y = y1 + (a/gcd) * t;
							if(x < 0) {
								break;
							}
						}
						if(x > 0 && y > 0) {
							count += 1;
							if(debugMode)
								System.out.println("\n" + a + " (" + x + ") + " + b + " (" + y + ") = " + number + "\n");
							if(solutionTestMode)
								System.out.println("(" + a + ", " + b + ")");
							if(debugMode) {
								int numFreq = (freq.get(a) == null) ? 0 : freq.get(a);
								freq.put(a, ++numFreq);
								numFreq = (freq.get(b) == null) ? 0 : freq.get(b);
								freq.put(b, ++numFreq);
								
								numFreq = (freqXY.get(x) == null) ? 0 : freqXY.get(x);
								freqXY.put(x, ++numFreq);
								//if(x != y) {
									numFreq = (freqXY.get(y) == null) ? 0 : freqXY.get(y);
									freqXY.put(y, ++numFreq);
								//}
							}
							break;
						}
					}// end for t				
				} //end if
			} // end for i
		} // end for j
		
		// Generate remaining solutions.
		
		return count;
	}
	
	public static int linearCombinationGCD(int a, int b)
	{
		u1 = 1;
		u2 = 0;
		int u3 = a;
		int v1 = 0;
		int v2 = 1;
		int v3 = b;
		int q = 0;
		
		//keep printing the intermediate steps in subsequent rows until v3 is zero
		while (v3 != 0) {
					
			//compute the greatest integer less than or equal to u3/v3
			//(note this is "int division")
			q = u3 / v3;
					
			int temp;
					
			//remember the old value of vi, and compute vi = ui - q * vi 
		    //for i = 1 to 3 also make new ui equal to the old vi 
		    //(note the need for a temp variable here)
			temp = v1;
			v1 = u1 - q * v1;
			u1 = temp;
					
			temp = v2;
			v2 = u2 - q * v2;
			u2 = temp;
					
			temp = v3;
		    v3 = u3 - q * v3;
		    u3 = temp;
					
		   //print the intermediate steps
		   /*if(debugMode)
			   System.out.println(
					   u1 + "\t" + v1 + "\t" + u2 + "\t" + v2 + 
			           "\t" + u3 + "\t" + v3 + "\t" + q
			   );
		   */
	    } // end while
		
		/*
		if(debugMode)
			System.out.println(a + " (" + u1 + ") + " + b + " (" + u2 + ") = " + u3);
		*/
		return u3;
	}
	
	public static int gcd(int a, int b) 
	{
		if (b==0) return a;
		return gcd(b, a % b);
	}
}
