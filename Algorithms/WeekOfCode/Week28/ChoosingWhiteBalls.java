package WeekOfCode.Week28;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

/**
 *	Algorithms -> Week of Code 28 -> Choosing White Balls
 *	Hard

	5 2 WBWBW -> 1.5
	
	5 3 WBWBW -> 2.1666666
	
	5 3 WWWBW -> 2.9
 */
public class ChoosingWhiteBalls {

	private static boolean debugMode = false;
	
	public static void main(String[] args)
	{
		
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int k = in.nextInt();
		
		String balls = in.next();
		
		in.close();
		
		double exp = calculateExpectedValue(balls, k, 1);
		DecimalFormat df = new DecimalFormat("0.000000");
		
		System.out.println(df.format(exp));
		
		//runTests();
	}
	
	public static double calculateExpectedValue(String balls, int k, double expCount)
	{
		if(debugMode) 
			System.out.println("balls: " + balls + " k: " + k + " exp: " + expCount);
		
		HashMap<String, Double> counts = new HashMap<String, Double>();
		
		double total = 0.0;
		double count = 0.0;
		double sec = 0.0;
		for(int i = 0; i < balls.length(); i++) {
			total++;
			int j;
			if(balls.charAt(i) == 'W' || balls.charAt(balls.length() - i - 1) == 'W') {
				count++;
				if(balls.charAt(i) == 'W') {
					j = i;
				} else {
					j = balls.length() - i - 1;
					
				}
				if(k > 1) {
					StringBuilder sb = new StringBuilder(balls.length() - 1);
					for(int s = 0; s < balls.length(); s++) {
						if(s != j) sb.append(balls.charAt(s));
					}
					String s = sb.toString();
					double sCount = (counts.get(s) == null) ? 0 : counts.get(s);
					counts.put(s, ++sCount);
					double small = calculateExpectedValue(s, k - 1, 1);
					sec += small / balls.length();
					if(debugMode)
						System.out.println(sb.toString() + " : " + small);
				}
			} else {
				if(k > 1) {
					StringBuilder sb = new StringBuilder(balls.length() - 1);
					StringBuilder sb2 = new StringBuilder(balls.length() - 1);
					for(int s = 0; s < balls.length(); s++) {
						if(s != i) sb.append(balls.charAt(s));
						if(s != balls.length() - i - 1) sb2.append(balls.charAt(s));
					}
					String s = sb.toString();
					String s2 = sb.toString();
					double sCount = (counts.get(s) == null) ? 0 : counts.get(s);
					counts.put(s, ++sCount);
					sCount = (counts.get(s2) == null) ? 0 : counts.get(s2);
					counts.put(s, ++sCount);
					double small = calculateExpectedValue(s, k - 1, 1);
					double small2 = calculateExpectedValue(s2, k - 1, 1);
					sec += small / balls.length();
					sec += small2 / balls.length();
					if(debugMode)
						System.out.println(sb.toString() + " : " + small);
				}
			}
		}
		
		k--;
		
		double smallers = 0.0;
		if(k != 0 && count > 0.0) {
			for(String s : counts.keySet()) {
				double e = calculateExpectedValue(s, k, counts.get(s) / total);
				smallers += e;
				if(debugMode)
					System.out.println(s + " count: " + counts.get(s) + " e: " + e + " smallers: " + smallers);
			}
		}
		if(count < 1.0) total = 1.0;
		
		double res = expCount * (count / total) + sec;
		System.out.println("res" + res);
		return res;
		//return expCount * (count / total) + expCount * smallers;
	}
	
	public static void runTests() {
		System.out.println("Tests:");
        char set1[] = {'W', 'B'};
        for(int i = 1; i < 30; i++) {
        	for(int j = 1; j <= i; j++)
        		printSubStringsWithProbability(set1, "", set1.length, i, j);
        }
	}
	
	// The main recursive method to print all possible strings of length k
    public static void printSubStringsWithProbability(char set[], String prefix, int n, int k, int j) {
         
        // Base case: k is 0, print prefix
        if (k == 0) {
        	double exp = calculateExpectedValue(prefix, j, 1);
            System.out.println(prefix + " : " + j + " : " + exp);
            return;
        }
 
        // One by one add all characters from set and recursively 
        // call for k equals to k-1
        for (int i = 0; i < n; ++i) {
             
            // Next character of input added
            String newPrefix = prefix + set[i]; 
             
            // k is decreased, because we have added a new character
            printSubStringsWithProbability(set, newPrefix, n, k - 1, j); 
        }
    }
    
    public static double calculateExpectedForOnePick(String balls)
    {
    	double total = 0.0;
		double count = 0.0;
    	
		for(int i = 0; i < balls.length(); i++) {
			total++;
			if(balls.charAt(i) == 'W' || balls.charAt(balls.length() - i - 1) == 'W') {
				count++;
			}
		}
		
    	return count / total;
    }
	
	// Java program to print all possible strings of length k
	public static class PrintAllKLengthStrings {
	 
	    // Driver method to test below methods
	    public static void main(String[] args) {             
	        System.out.println("First Test");
	        char set1[] = {'a', 'b'};
	        int k = 3;
	        printAllKLength(set1, k);
	         
	        System.out.println("\nSecond Test");
	        char set2[] = {'a', 'b', 'c', 'd'};
	        k = 1;
	        printAllKLength(set2, k);        
	    }    
	 
	    // The method that prints all possible strings of length k.  It is
	    //  mainly a wrapper over recursive function printAllKLengthRec()
	    public static void printAllKLength(char set[], int k) {
	        int n = set.length;        
	        printAllKLengthRec(set, "", n, k);
	    }
	 
	    // The main recursive method to print all possible strings of length k
	    public static void printAllKLengthRec(char set[], String prefix, int n, int k) {
	         
	        // Base case: k is 0, print prefix
	        if (k == 0) {
	            System.out.println(prefix);
	            return;
	        }
	 
	        // One by one add all characters from set and recursively 
	        // call for k equals to k-1
	        for (int i = 0; i < n; ++i) {
	             
	            // Next character of input added
	            String newPrefix = prefix + set[i]; 
	             
	            // k is decreased, because we have added a new character
	            printAllKLengthRec(set, newPrefix, n, k - 1); 
	        }
	    }
	}
}
