package WeekOfCode.Week28;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
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
	
	http://www.catonmat.net/blog/low-level-bit-hacks-you-absolutely-must-know/
	http://stackoverflow.com/questions/10493411/what-is-bit-masking
	http://codeforces.com/blog/entry/18169
	http://graphics.stanford.edu/~seander/bithacks.html
	http://articles.leetcode.com/reverse-bits/
	https://www.careercup.com/question?id=18305670
 */
public class ChoosingWhiteBalls {

	private static boolean debugMode = false;
	private static boolean timeMode = false;
	private static boolean writeMode = false;
	
	private static int MAX = 0b11110; //Thirty in Binary
	
	static long startTime, endTime;
    private static String outFileStr = "WeekOfCode/Week28/ChoosingWhiteBalls.txt";
    // Assume default encoding.
    private static FileWriter fileWriter;
    // Always wrap FileWriter in BufferedWriter.
    private static BufferedWriter bufferedWriter;
	
	public static void main(String[] args) throws IOException
	{
		Scanner in = new Scanner(System.in);
		
		if(writeMode) {
			fileWriter = new FileWriter(outFileStr);
			bufferedWriter = new BufferedWriter(fileWriter);
		}
		
		int n = in.nextInt();
		int k = in.nextInt();
		
		String balls = in.next();
		int ballsInt = convertStringToBits(balls);
		
		//System.out.println(Integer.toBinaryString(ballsInt));
		//System.out.println(Integer.toBinaryString(reverseBits(ballsInt, n)));
		//System.out.println(getNthBit(ballsInt, 0));
		//System.out.println(Integer.toBinaryString(removeIthBit(ballsInt, 1, n)));
		
		if(timeMode) {
			startTime = System.currentTimeMillis();
		}
		
		computedHolderMem = new TreeMap[balls.length() + 1];
		//computedHolder = new TreeMap[balls.length() + 1];
		
		for(int i = 0; i <= balls.length(); i++) {
			//computedHolder[i] = new TreeMap<String, Double>();
			computedHolderMem[i] = new TreeMap<Integer, Double>();
		}
		
		in.close();
		
		//double exp = calculateExpectedValue(balls, k);
		double exp2 = calculateExpectedValueByte(ballsInt, k , n);
		
		DecimalFormat df = new DecimalFormat("0.000000");
		
		//System.out.println(df.format(exp));
		System.out.println(df.format(exp2));
		
		if(timeMode) {
			long estimatedTime = System.currentTimeMillis() - startTime;
			System.out.println("Time: " + estimatedTime);
			if(writeMode) {
				bufferedWriter.write("Time: " + estimatedTime);
		        bufferedWriter.newLine();
				bufferedWriter.close();
			}
		}
		
		
		//runTests();
	}
	
	private static int reverseBits(int x, int n)
	{
		x = ((x&0xAAAAAAAA) >> 1)| ((x& 0x55555555) << 1);
        x = ((x&0xCCCCCCCC) >> 2)| ((x& 0x33333333) << 2);
        x = ((x&0xF0F0F0F0) >> 4) | ((x& 0x0F0F0F0F) << 4);
        x = ((x&0xFF00FF00) >> 8) | ((x& 0x00FF00FF) << 8);
        x = x >> 16 | x << 16;
        final int mask = (1 << n) - 1;
        x = (x >>> (32 - n)) & mask;
		return x;
	}
	
	private static int convertStringToBits(String s)
	{
		int i = 0;
		int twos = 1;
		
		for(int c = s.length() - 1; c >= 0; c--)
		{
			char letter = s.charAt(c);
			if(letter == 'W') i += twos;
			twos *= 2;
		}
		
		return i;
	}
	
	private static int getNthBit(int value, int n)
	{
		return (value >> n) & 1; // Another common approach is int bitN = (value >> n) & 1;
		//http://stackoverflow.com/questions/3142867/finding-bit-positions-in-an-unsigned-32-bit-integer
	}
	
	
	public static int extractSub(final int l, final int nrBits, final int offset)
	{
	    final int rightShifted = l >>> offset;
	    final int mask = (1 << nrBits) - 1;
	    return rightShifted & mask;
	}
	
	public static int removeIthBit(final int value, final int i, final int n)
	{
		final int mask = (1 << i) - 1; //To turn on all bits in a set of size n
		final int mask2 = (1 << n) - 1;
		final int mask3 = (mask ^ mask2) << 1; 
		//System.out.println(Integer.toBinaryString(mask));
		//System.out.println(Integer.toBinaryString(mask2));
		//System.out.println(Integer.toBinaryString(mask3));
		//System.out.println(Integer.toBinaryString((value & mask3) >>> 1));
		return (((value & mask3) >>> 1) + (value & mask)) & mask2;
	}
		
	private static TreeMap<Integer, Double>[] computedHolderMem;
	
	public static double calculateExpectedValueByte(int balls, int k, int n)
	{
		TreeMap<Integer, Double> mem = computedHolderMem[n];
		if(mem.get(balls) != null)
			return mem.get(balls);
		
		double count = 0.0;
		double sec = 0.0;
		
		int i = 0;
		int j = n - 1;
		while(i <= j) {
			
			boolean ithW = (getNthBit(balls, i) == 1);
			boolean jthW = (getNthBit(balls, j) == 1);
			
			if(ithW || jthW) count += 2;
			if(i == j && ithW)
				if(ithW) count--; //decrement over counting
						
			if(i != j) {
				//generate two sub strings
				if(k > 1) {
					int b, c;
					
					b = removeIthBit(balls, i, n);
					c = removeIthBit(balls, j, n);
					
					double small = calculateExpectedValueByte(b, k - 1, n - 1);
					double small2 = calculateExpectedValueByte(c, k - 1, n - 1);
					double holder1 = (ithW) ? 1.0 : 0.0;
					double holder2 = (jthW) ? 1.0 : 0.0;
					if(small + holder1 > small2 + holder2) {
						small2 = small;
					} else {
						small = small2;
					}
					sec += (small / n);
					sec += (small2 / n);
					if(debugMode) {
						System.out.println(Integer.toBinaryString(b) + " small: " + small + " small/length: " + small/n);
						System.out.println(Integer.toBinaryString(c) + " small2: " + small2 + " small2/length: " + small2/n);
					}
				}
				
			} else {
				//generate one sub string if in middle
				int b = removeIthBit(balls, i, n);
				
				if(k > 1) {
					double small = calculateExpectedValueByte(b, k - 1, n - 1);
					sec += (small / n);
					if(debugMode)
						System.out.println(Integer.toBinaryString(b) + " small: " + small + " small/length: " + small/n);
				}
				//end if k > 1
			} //end else
			
			i++;
			j--;
		}
		
		if(debugMode)
			System.out.println("count: " + count + " length:" + n);
		double res = (count / n) + sec;
		
		mem.put(balls, res);
		//mem.put(reverseBits(balls, n), res);
		computedHolderMem[n] = mem;
		
		if(debugMode)
			System.out.println("res: " + res);
		return res;
	}
	
	private static TreeMap<String, Double>[] computedHolder;
	//private static TreeMap<String, Double> computedValues = new TreeMap<String, Double>();
	
	
	public static double calculateExpectedValue(String balls, int k) throws IOException
	{
		if(debugMode) 
			System.out.println("\nBalls: " + balls + " k: " + k);
		
		if(writeMode) {
			bufferedWriter.write("\nBalls: " + balls + " k: " + k);
	        bufferedWriter.newLine();
		}
		
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
					if(writeMode) {
						bufferedWriter.write(s + " small: " + small + " small/length: " + small/balls.length());
				        bufferedWriter.newLine();
				        bufferedWriter.write(s2 + " small2: " + small2 + " small2/length: " + small2/balls.length());
				        bufferedWriter.newLine();
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
					if(writeMode) {
						bufferedWriter.write(s + " small: " + small + " small/length: " + small/balls.length());
				        bufferedWriter.newLine();
					}
				}
				//end if k > 1
			} //end else
			
			i++;
			j--;
		}
		
		if(debugMode)
			System.out.println("count: " + count + " length:" + balls.length());
		if(writeMode) {
			bufferedWriter.write("count: " + count + " length:" + balls.length());
	        bufferedWriter.newLine();
		}
		double res = (count / balls.length()) + sec;
		
		computedValues.put(balls, res);
		
		StringBuilder sb = new StringBuilder(balls);
		sb.reverse();
		computedValues.put(sb.toString(), res);
		
		computedHolder[balls.length()] = computedValues;
		
		if(debugMode)
			System.out.println("res: " + res);
		if(writeMode) {
			bufferedWriter.write("res: " + res);
	        bufferedWriter.newLine();
		}
		return res;
	}
	
	public static void runTests() throws IOException {
		System.out.println("Tests:");
        char set1[] = {'W', 'B'};
        for(int i = 1; i < 30; i++) {
        	for(int j = 1; j <= i; j++)
        		printSubStringsWithProbability(set1, "", set1.length, i, j);
        }
	}
	
	// The main recursive method to print all possible strings of length k
    public static void printSubStringsWithProbability(char set[], String prefix, int n, int k, int j) throws IOException {
         
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
