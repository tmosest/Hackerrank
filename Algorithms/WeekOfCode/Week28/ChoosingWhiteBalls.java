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
		
		if(timeMode) {
			startTime = System.currentTimeMillis();
		}
		
		computedHolderMem = new TreeMap[balls.length() + 1];
		
		for(int i = 0; i <= balls.length(); i++) {
			computedHolderMem[i] = new TreeMap<Integer, Double>();
		}
		
		in.close();
		
		double exp2 = calculateExpectedValueByte(ballsInt, k , n);
		
		DecimalFormat df = new DecimalFormat("0.000000");
		
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
	
	/**
	 * Take a number x where you can about the last n bits and flips the shifts.
	 * So (1101, 4) returns 1011.
	 * @param x the integer that you want to reverse
	 * @param n the length from 1 to nth digit to shift to.
	 * @return
	 */
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
	
	/**
	 * Takes a String of W's and B's and converts them to a binary number.
	 * WB -> 10.
	 * @param s A string of B's and W's
	 * @return 1 for W and 0 for B
	 */
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
	
	/**
	 * Returns the value of the nth bit in a value.
	 * This starts from the least significant digit.
	 * 
	 * @param value the number you want to get the nth bit from.
	 * @param n the nth bit.
	 * @return
	 */
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
	
	/**
	 * Removes the ith bit from a number by masking the ones less than it 
	 * and shifting the ones greater down onto it
	 * 
	 * @param value the integer you want to remove a bit from
	 * @param i the ith bit you want to get rid of.
	 * @param n the total size of bits you care about from least significant.
	 * @return
	 */
	public static int removeIthBit(final int value, final int i, final int n)
	{
		final int mask = (1 << i) - 1; //To turn on all bits in a set of size n
		final int mask2 = (1 << n) - 1;
		final int mask3 = (mask ^ mask2) << 1; 
		return (((value & mask3) >>> 1) + (value & mask)) & mask2;
	}
	
	// D.P. Data Structure
	private static TreeMap<Integer, Double>[] computedHolderMem;
	
	/**
	 * The bread an butter of this challenge.
	 * This a recursive algorithm that calculate the expected value for a ball int of size n with k deletions. 
	 * @param balls an int that represents the string BWWWBWB
	 * @param k the number of deletions.
	 * @param n the number of balls.
	 * @return
	 */
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
		mem.put(reverseBits(balls, n), res);
		computedHolderMem[n] = mem;
		
		if(debugMode)
			System.out.println("res: " + res);
		return res;
	}
}
