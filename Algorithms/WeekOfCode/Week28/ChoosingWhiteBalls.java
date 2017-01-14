package WeekOfCode.Week28;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *	Algorithms -> Week of Code 28 -> Choosing White Balls
 *	Hard

	5 2 WBWBW -> 1.5
	
	5 3 WBWBW -> 2.1666666
	
	5 3 WWWBW -> 2.9
	
	4 2 WWBW -> 1.8333333333333333
	
	8 4 WBBWWWBB -> 2.7809523809523813 or 1.5714285714285714 if you choose white over black
	
	Removing the far right B leaves you with WBBWWWB, from which you can remove an expected 2.6380952380952385 white balls. 
	Removing the far left W leaves you with BBWWWBB, from which you can only remove an expected 1.5714285714285714 white balls, 
	or 2.5714285714285714 if you include the first W.
	There are actually quite a lot of these. Also, I don't think you can save much time by pretending they don't exist.
 */
public class ChoosingWhiteBalls {

	private static boolean debugMode = false;
	private static boolean timeMode = true;
	static long startTime, endTime;
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int k = in.nextInt();
		
		String balls = in.next();
		
		if(timeMode) {
			startTime = System.currentTimeMillis();
		}
		
		computedHolder = new TreeMap[balls.length() + 1];
		
		for(int i = 0; i <= balls.length(); i++) {
			computedHolder[i] = new TreeMap<String, Double>();
		}
		
		in.close();
		
		double exp = calculateExpectedValue(balls, k);

		DecimalFormat df = new DecimalFormat("0.000000");
		
		System.out.println(df.format(exp));
		
		if(timeMode) {
			long estimatedTime = System.currentTimeMillis() - startTime;
			System.out.println("Time: " + estimatedTime);
		}
		
		
		//runTests();
	}
	
	/*
	private static TreeMap<Byte[], Double> mem = new TreeMap<Byte[], Double>();
	
	public static double calculateExpectedValueByte(byte[] balls, int k)
	{
		
		if(mem.get(balls) != null)
			return computedValues.get(balls);
		
		double count = 0.0;
		double sec = 0.0;
		
		int i = 0;
		int j = balls.length - 1;
		while(i <= j) {
			
			boolean ithW = balls[i] == 1;
			boolean jthW = balls[j] == 1;
			
			if(ithW || jthW) count += 2;
			if(i == j && ithW)
				if(ithW) count--; //decrement over counting
						
			if(i != j) {
				//generate two sub strings
				if(k > 1) {
					
					byte[] b = new byte[b.length - 1];
					byte[] c = new byte[b.length - 1];
					
					boolean isBC = true;
					boolean isBreverseC = true;
					
					int bI = 0;
					int cI = 0;
					for(int s = 0; s <= balls.length / 2; s++) {
						if(s != i) {
							b[bI] = balls[s];
						}
						bI++;
					}
					
					for(int s = 0; s < balls.length(); s++) {
						if(s != i) sb.append(balls.charAt(s));
						if(s != j) sb2.append(balls.charAt(s));
					}
					String s = sb.toString();
					String s2 = sb2.toString();
					double small = calculateExpectedValue(s, k - 1);
					double small2 = calculateExpectedValue(s2, k - 1);
					double holder1 = (ithW) ? 1.0 : 0.0;
					double holder2 = (jthW) ? 1.0 : 0.0;
					if(small + holder1 > small2 + holder2) {
						small2 = small;
					} else {
						small = small2;
					}
					sec += (small / balls.length());
					sec += (small2 / balls.length());
					if(debugMode) {
						System.out.println(s + " small: " + small + " small/length: " + small/balls.length());
						System.out.println(s2 + " small2: " + small2 + " small2/length: " + small2/balls.length());
					}
				}
				
			} else {
				//generate one sub string,
				//could be i or j depending on who is W or it could be the middle.
				int index = i;
				if(jthW) index = j;
				
				if(k > 1) {
					StringBuilder sb = new StringBuilder(balls.length() - 1);
					for(int s = 0; s < balls.length(); s++) {
						if(s != index) sb.append(balls.charAt(s));
					}
					String s = sb.toString();
					double small = calculateExpectedValue(s, k - 1);
					sec += (small / balls.length());
					if(debugMode)
							System.out.println(s + " small: " + small + " small/length: " + small/balls.length());
				}
				//end if k > 1
			} //end else
			
			i++;
			j--;
		}
		
		if(debugMode)
			System.out.println("count: " + count + " length:" + balls.length());
		double res = (count / balls.length()) + sec;
		
		computedValues.put(balls, res);
		StringBuilder sb = new StringBuilder(balls);
		sb.reverse();
		computedValues.put(sb.toString(), res);
		
		if(debugMode)
			System.out.println("res: " + res);
		return res;
	}
	*/
	
	private static byte[] convertBallToByte(String s)
	{
		byte[] b = new byte[s.length()];
		
		for(int i = 0; i < s.length(); i++) {
			char letter = s.charAt(i);
			if(letter == 'W')
				b[i] = 1;
			else
				b[i] = 0;
		}
		
		return b;
	}
	
	private static byte[] reverseByteArray(byte[] b)
	{
		byte[] c = new byte[b.length];
		
		for(int i = 0; i <= b.length / 2; i++) {
			c[i] = b[b.length - 1 - i];
			c[b.length - 1 - i] = b[i];
		}
		
		return c;
	}
	
	private static void printByteArray(byte[] b)
	{
		System.out.println("");
		for(byte i : b)
			System.out.print(i + " ");
		System.out.println("");
	}
	
	private static TreeMap<String, Double>[] computedHolder;
	//private static TreeMap<String, Double> computedValues = new TreeMap<String, Double>();
	
	
	public static double calculateExpectedValue(String balls, int k)
	{
		if(debugMode) 
			System.out.println("\nBalls: " + balls + " k: " + k);
		
		TreeMap<String, Double> computedValues = computedHolder[balls.length()];
		
		if(computedValues.get(balls) != null)
			return computedValues.get(balls);
		
		double count = 0.0;
		double sec = 0.0;
				
		int i = 0;
		int j = balls.length() - 1;
		while(i <= j) {
			if(debugMode)
				System.out.println("i: " + i + " j: " + j);
			boolean ithW = balls.charAt(i) == 'W';
			boolean jthW = balls.charAt(j) == 'W';
			
			if(ithW || jthW) count += 2;
			if(i == j && ithW)
				if(ithW) count--; //decrement over counting
						
			if(i != j) {
				//generate two sub strings
				if(k > 1) {
					StringBuilder sb = new StringBuilder(balls.length() - 1);
					StringBuilder sb2 = new StringBuilder(balls.length() - 1);
					for(int s = 0; s < balls.length(); s++) {
						if(s != i) sb.append(balls.charAt(s));
						if(s != j) sb2.append(balls.charAt(s));
					}
					String s = sb.toString();
					String s2 = sb2.toString();
					double small = calculateExpectedValue(s, k - 1);
					double small2 = calculateExpectedValue(s2, k - 1);
					double holder1 = (ithW) ? 1.0 : 0.0;
					double holder2 = (jthW) ? 1.0 : 0.0;
					if(small + holder1 > small2 + holder2) {
						small2 = small;
					} else {
						small = small2;
					}
					sec += (small / balls.length());
					sec += (small2 / balls.length());
					if(debugMode) {
						System.out.println(s + " small: " + small + " small/length: " + small/balls.length());
						System.out.println(s2 + " small2: " + small2 + " small2/length: " + small2/balls.length());
					}
				}
				
			} else {
				//generate one sub string,
				//could be i or j depending on who is W or it could be the middle.
				int index = i;
				if(jthW) index = j;
				
				if(k > 1) {
					StringBuilder sb = new StringBuilder(balls.length() - 1);
					for(int s = 0; s < balls.length(); s++) {
						if(s != index) sb.append(balls.charAt(s));
					}
					String s = sb.toString();
					double small = calculateExpectedValue(s, k - 1);
					sec += (small / balls.length());
					if(debugMode)
							System.out.println(s + " small: " + small + " small/length: " + small/balls.length());
				}
				//end if k > 1
			} //end else
			
			i++;
			j--;
		}
		
		if(debugMode)
			System.out.println("count: " + count + " length:" + balls.length());
		double res = (count / balls.length()) + sec;
		
		computedValues.put(balls, res);
		
		StringBuilder sb = new StringBuilder(balls);
		sb.reverse();
		computedValues.put(sb.toString(), res);
		
		computedHolder[balls.length()] = computedValues;
		
		if(debugMode)
			System.out.println("res: " + res);
		return res;
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
        	double exp = calculateExpectedValue(prefix, j);
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
