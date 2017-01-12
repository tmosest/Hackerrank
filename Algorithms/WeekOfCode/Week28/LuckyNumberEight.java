package WeekOfCode.Week28;

import java.util.Scanner;

public class LuckyNumberEight {
	
	private static long mod = 1000000007;
	private static long MOD = 1000000007;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int size = in.nextInt();
		String s = in.next();
		
		in.close();
		
		System.out.println(countSubSequnecesDivisibleByEight(s));
		
		//printEightTable();
		//System.out.println(countSubSequnecesDivisibleBySix("1254"));
	}

	/**
	 * 
	 * @param s
	 * @return
	 */
	private static long countSubSequnecesDivisibleByEight(String s)
	{
		//generateEightTable();
		long[] remainders = new long[8];
		
		for(int i = 0; i < s.length(); i++) {
			int remainder = (s.charAt(i) - '0') % 8;
			
			long zero, one, two, three, four,
			five, six, seven;
			
			zero = remainders[0] % MOD;
			one = remainders[1] % MOD;
			two = remainders[2] % MOD;
			three = remainders[3] % MOD;
			four = remainders[4] % MOD;
			five = remainders[5] % MOD;
			six = remainders[6] % MOD;
			seven = remainders[7] % MOD;
			/*
			switch(remainder)
			{
				case 0:
				case 4:
					for(int c = 0; c < 8; c++) {
						remainders[c] *= 2;
						remainders[c] %= MOD;
					}
					break;
					
				case 1:
				case 5:
					remainders[0] += six;
					remainders[1] += seven;
					remainders[2] += zero;
					remainders[3] += one;
					remainders[4] += two;
					remainders[5] += three;
					remainders[6] += four;
					remainders[7] += five;
					break;
				
				case 2:
				case 6:
					remainders[0] += four;
					remainders[1] += five;
					remainders[2] += six;
					remainders[3] += seven;
					remainders[4] += zero;
					remainders[5] += one;
					remainders[6] += two;
					remainders[7] += three;
					break;
				
				case 3:
				case 7:
					remainders[0] += two;
					remainders[1] += three;
					remainders[2] += four;
					remainders[3] += five;
					remainders[4] += six;
					remainders[5] += seven;
					remainders[6] += zero;
					remainders[7] += one;
					break;
			}
			*/
			switch(remainder)
			{
				case 0:
					remainders[0] += zero;
					remainders[0] %= MOD;
					remainders[0] += four;
					remainders[2] += one;
					remainders[2] %= MOD;
					remainders[2] += five;
					remainders[4] += two;
					remainders[4] %= MOD;
					remainders[4] += two;
					remainders[6] += three;
					remainders[6] %= MOD;
					remainders[6] += seven;
					break;
					
				case 1:
					remainders[1] += zero;
					remainders[1] %= MOD;
					remainders[1] += four;
					remainders[3] += one;
					remainders[3] %= MOD;
					remainders[3] += five;
					remainders[5] += two;
					remainders[5] %= MOD;
					remainders[5] += six;
					remainders[7] += three;
					remainders[7] %= MOD;
					remainders[7] += seven;
					break;
				
				case 2:
					remainders[0] += three;
					remainders[0] %= MOD;
					remainders[0] += seven;
					remainders[2] += zero;
					remainders[2] %= MOD;
					remainders[2] += four;
					remainders[4] += one;
					remainders[4] %= MOD;
					remainders[4] += five;
					remainders[6] += two;
					remainders[6] %= MOD;
					remainders[6] += six;
					break;
				
				case 3:
					remainders[1] += three;
					remainders[1] %= MOD;
					remainders[1] += seven;
					remainders[3] += zero;
					remainders[3] %= MOD;
					remainders[3] += four;
					remainders[5] += one;
					remainders[5] %= MOD;
					remainders[5] += five;
					remainders[7] += two;
					remainders[7] %= MOD;
					remainders[7] += six;
					break;
					
				case 4:
					remainders[0] += two;
					remainders[0] %= MOD;
					remainders[0] += six;
					remainders[2] += three;
					remainders[2] %= MOD;
					remainders[2] += seven;
					remainders[4] += zero;
					remainders[4] %= MOD;
					remainders[4] += four;
					remainders[6] += one;
					remainders[6] %= MOD;
					remainders[6] += five;
					break;	
					
				case 5:
					remainders[1] += two;
					remainders[1] %= MOD;
					remainders[1] += six;
					remainders[3] += three;
					remainders[3] %= MOD;
					remainders[3] += seven;
					remainders[5] += zero;
					remainders[5] %= MOD;
					remainders[5] += four;
					remainders[7] += one;
					remainders[7] %= MOD;
					remainders[7] += five;
					break;
					
				case 6:
					remainders[0] += one;
					remainders[0] %= MOD;
					remainders[0] += five;
					remainders[2] += two;
					remainders[2] %= MOD;
					remainders[2] += six;
					remainders[4] += three;
					remainders[4] %= MOD;
					remainders[4] += seven;
					remainders[6] += zero;
					remainders[6] %= MOD;
					remainders[6] += four;
					break;	
					
				case 7:
					remainders[1] += one;
					remainders[1] %= MOD;
					remainders[1] += five;
					remainders[3] += two;
					remainders[3] %= MOD;
					remainders[3] += six;
					remainders[5] += three;
					remainders[5] %= MOD;
					remainders[5] += seven;
					remainders[7] += zero;
					remainders[7] %= MOD;
					remainders[7] += four;
					break;
			}
			for(int c = 0; c < 8; c++) {
				remainders[c] %= MOD;
				//System.out.println(c + " : " + remainders[c]);
			}
			remainders[remainder]++;
			remainders[remainder] %= MOD;
			//System.out.println("remainder: " + remainder + " : " +remainders[remainder]);
			
		}
		
		return remainders[0];
	}
	
	/**
	 * Counts all susequnces divisible by 3
	 * @param s
	 * @return
	 */
	private static int countSubSequnecesDivisibleBySix(String s)
	{
		int a = 0, b = 0 ,c = 0;
		
		for(int ind = s.length() - 1; ind >= 0; ind--){                
			 
	        int item = (s.charAt(ind) - '0');                    
	 
	        if(item % 3 == 0){                    
	            a=a*2;                
	            b=b*2;
	            c=c*2;
	        }
	        else if(item % 3 == 1){
	        	int a1 = a;
	            int b1 = b;
	            int c1 = c;
	            a+=c1;
	            b+=a1;
	            c+=b1;                    
	        }
	        else if(item % 3 == 2){
	            int a1 = a;
	            int b1 = b;
	            int c1 = c;
	            a+=b1;
	            b+=c1;
	            c+=a1;                    
	        }
	        
	        if(item % 6==0)
	            a++;
	        else if(item % 3==1 && item % 2 == 0)
	            b++;
	        else if(item % 3==2 && item % 2 == 0)
	            c++;                                
	    }
	        
		return a;
	}
	
	private static void printAllSubString(String A)
	{
		for (int i = 0; i < A.length(); i++) {
	        for (int j = i+1; j <= A.length(); j++) {
	            System.out.println(A.substring(i,j));
	        }
	    }
	}
	
	/**
	 * Generate Eight Table.
	 * If x is mod 8 and y is x with a digit appended of mod 8 it will become the end.
	 */
	private static int[][] eightTable;
	
	private static void generateEightTable()
	{
		eightTable = new int[8][8];
		for(int i = 0; i <= 7; i++) {
			for(int j = 0; j <= 7; j++) {
				eightTable[i][j] = ((i * 10 + j) % 8);
			}
		}
	}
	
	/**
	 * Print two Table.
	 * If x is mod 3 and y is x with a digit appended of mod 3 it will become the end.
	 */
	private static void printTwoTable()
	{
		for(int i = 0; i <= 1; i++) {
			for(int j = 0; j <= 1; j++) {
				System.out.println("x: " + i + " y: " + j + " : " + ((i * 10 + j) % 2));
			}
			System.out.println("");
		}
	}
	
	/**
	 * Print Three Table.
	 * If x is mod 3 and y is x with a digit appended of mod 3 it will become the end.
	 * This is the same for appending forwards!
	 */
	private static void printThreeTable()
	{
		for(int i = 0; i <= 2; i++) {
			for(int j = 0; j <= 2; j++) {
				System.out.println("x: " + i + " y: " + j + " : " + ((j * 10 + i) % 3));
			}
			System.out.println("");
		}
	}
	
	/**
	 	x: 0 y: 0 : 0
		x: 0 y: 1 : 1
		x: 0 y: 2 : 2
		
		x: 1 y: 0 : 1
		x: 1 y: 1 : 2
		x: 1 y: 2 : 0
		
		x: 2 y: 0 : 2
		x: 2 y: 1 : 0
		x: 2 y: 2 : 1
	 */
	
	/**
	 * Print Four Table.
	 * If x is mod 3 and y is x with a digit appended of mod 3 it will become the end.
	 */
	private static void printFourTable()
	{
		for(int i = 0; i <= 3; i++) {
			for(int j = 0; j <= 3; j++) {
				System.out.println("x: " + i + " y: " + j + " : " + ((i * 10 + j) % 4));
			}
			System.out.println("");
		}
	}
	
	/**
	 	x: 0 y: 0 : 0
		x: 0 y: 1 : 1
		x: 0 y: 2 : 2
		x: 0 y: 3 : 3
		
		x: 1 y: 0 : 2
		x: 1 y: 1 : 3
		x: 1 y: 2 : 0
		x: 1 y: 3 : 1
		
		x: 2 y: 0 : 0
		x: 2 y: 1 : 1
		x: 2 y: 2 : 2
		x: 2 y: 3 : 3
		
		x: 3 y: 0 : 2
		x: 3 y: 1 : 3
		x: 3 y: 2 : 0
		x: 3 y: 3 : 1
	 */
	
	/**
	 * Print Eight Table.
	 * If x is mod 8 and y is x with a digit appended of mod 8 it will become the end.
	 */
	private static void printEightTable()
	{
		for(int i = 0; i <= 7; i++) {
			for(int j = 0; j <= 7; j++) {
				System.out.println("x: " + i + " y: " + j + " : " + ((j * 10 + i) % 8));
			}
			System.out.println("");
		}
	}
	/*
	    x: 0 y: 0 : 0
		x: 0 y: 1 : 1
		x: 0 y: 2 : 2
		x: 0 y: 3 : 3
		x: 0 y: 4 : 4
		x: 0 y: 5 : 5
		x: 0 y: 6 : 6
		x: 0 y: 7 : 7
		
		x: 1 y: 0 : 2
		x: 1 y: 1 : 3
		x: 1 y: 2 : 4
		x: 1 y: 3 : 5
		x: 1 y: 4 : 6
		x: 1 y: 5 : 7
		x: 1 y: 6 : 0
		x: 1 y: 7 : 1
		
		x: 2 y: 0 : 4
		x: 2 y: 1 : 5
		x: 2 y: 2 : 6
		x: 2 y: 3 : 7
		x: 2 y: 4 : 0
		x: 2 y: 5 : 1
		x: 2 y: 6 : 2
		x: 2 y: 7 : 3
		
		x: 3 y: 0 : 6
		x: 3 y: 1 : 7
		x: 3 y: 2 : 0
		x: 3 y: 3 : 1
		x: 3 y: 4 : 2
		x: 3 y: 5 : 3
		x: 3 y: 6 : 4
		x: 3 y: 7 : 5
		
		x: 4 y: 0 : 0
		x: 4 y: 1 : 1
		x: 4 y: 2 : 2
		x: 4 y: 3 : 3
		x: 4 y: 4 : 4
		x: 4 y: 5 : 5
		x: 4 y: 6 : 6
		x: 4 y: 7 : 7
		
		x: 5 y: 0 : 2
		x: 5 y: 1 : 3
		x: 5 y: 2 : 4
		x: 5 y: 3 : 5
		x: 5 y: 4 : 6
		x: 5 y: 5 : 7
		x: 5 y: 6 : 0
		x: 5 y: 7 : 1
		
		x: 6 y: 0 : 4
		x: 6 y: 1 : 5
		x: 6 y: 2 : 6
		x: 6 y: 3 : 7
		x: 6 y: 4 : 0
		x: 6 y: 5 : 1
		x: 6 y: 6 : 2
		x: 6 y: 7 : 3
		
		x: 7 y: 0 : 6
		x: 7 y: 1 : 7
		x: 7 y: 2 : 0
		x: 7 y: 3 : 1
		x: 7 y: 4 : 2
		x: 7 y: 5 : 3
		x: 7 y: 6 : 4
		x: 7 y: 7 : 5
	 */
}
