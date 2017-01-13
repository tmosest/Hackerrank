package WeekOfCode.Week28;

import java.util.Scanner;

/**
 *	Algorithms -> Week of Code 28 -> Choosing White Balls
 *	Hard
 */
public class ChoosingWhiteBalls {

	private static boolean debugMode = true;
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int k = in.nextInt();
		
		String balls = in.next();
		
		in.close();
		
		double exp = calculateExpectedValue(balls, k, 1);
		System.out.println(exp);
		//runTests();
	}
	
	public static double calculateExpectedValue(String balls, int k, int expCount)
	{
		if(debugMode) 
			System.out.println(balls);
		
		int[] counts = new int[balls.length()];
		
		double total = 0.0;
		double count = 0.0;
		
		for(int i = 0; i < balls.length(); i++) {
			total++;
			if(balls.charAt(i) == 'W' || balls.charAt(balls.length() - i - 1) == 'W') {
				count++;
				if(balls.charAt(i) == 'W') {
					counts[i]++;
				} else {
					counts[balls.length() - i - 1]++;
				}
			}
		}
		
		k--;
		
		double smallers = 0.0;
		if(k != 0 && count > 0.0) {
			for(int i = 0; i < counts.length; i++) {
				if(counts[i] > 0) {
					StringBuilder sb = new StringBuilder(counts.length - 1);
					for(int s = 0; s < balls.length(); s++) {
						if(s != i) sb.append(balls.charAt(s));
					}
					if(debugMode)
						System.out.println(sb.toString());
					smallers += calculateExpectedValue(sb.toString(), k, counts[i]);
				}
			}
		}
		if(count < 1.0) total = 1.0;
		
		return (1.0 / expCount) * (count / total) + smallers;
	}
	
	public static void runTests() {
		System.out.println("Tests:");
        char set1[] = {'W', 'B'};
        for(int i = 1; i < 30; i++) {
        	System.out.println("Size: " + i);
        	printSubStringsWithProbability(set1, "", set1.length, i);
        }
	}
	
	// The main recursive method to print all possible strings of length k
    public static void printSubStringsWithProbability(char set[], String prefix, int n, int k) {
         
        // Base case: k is 0, print prefix
        if (k == 0) {
        	double exp = calculateExpectedForOnePick(prefix);
            System.out.println(prefix + " : " + exp);
            return;
        }
 
        // One by one add all characters from set and recursively 
        // call for k equals to k-1
        for (int i = 0; i < n; ++i) {
             
            // Next character of input added
            String newPrefix = prefix + set[i]; 
             
            // k is decreased, because we have added a new character
            printSubStringsWithProbability(set, newPrefix, n, k - 1); 
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
