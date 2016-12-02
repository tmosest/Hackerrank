package WeekOfCode.Week26;


import java.util.Arrays;
import java.util.BitSet;
import java.util.Scanner;

/**
 *	Algorithms -> Week of Code 26 -> Twins
 *	Medium
 */
public class Twins {
	private static boolean debugMode;
	
	private static long start, end;
	private static int twins, seivetwins;
	
	static boolean[] primes;
	
	public static void main(String[] args) {
		debugMode = false;
		
		Scanner in = new Scanner(System.in);
		
		start = in.nextLong();
        end = in.nextLong();
		
        in.close();
		
        if(debugMode)
        	System.out.println("Looking for primes between: " + start + " " + end);
        
        runEratosthenesSieve(start, end);
        //countAllTwinPrimesBetween((int) start, (int) end);
        
        //System.out.println(twins + " vs " + seivetwins);
        System.out.println(twins);
	}
	
	// will contain true or false values for the first 10,000 integers
	public static void countAllTwinPrimesBetween(int start, int end)
	{
		seivetwins = 0;
		primes = new boolean[end + 1];
		fillSieve();
	}
	
	//set up the primesieve
	static public void fillSieve() 
	{
		if(debugMode)
        	System.out.println("Filling Sieve");
	    
	    for(int i = 0; i < primes.length; i++) {
	    	primes[i] = true;
	    	if(i % 2 == 0) primes[i] = false;
	    	if(i % 3 == 0) primes[i] = false;
	    	if(i % 5 == 0) primes[i] = false;
	    	if(i % 7 == 0) primes[i] = false;
	    	if(i % 11 == 0) primes[i] = false;
	    	if(i % 13 == 0) primes[i] = false;
	    	if(i % 17 == 0) primes[i] = false;
	    	if(i % 19 == 0) primes[i] = false;
	    }
	    
	    primes[0]=primes[1]=false;       // we know 0 and 1 are not prime.
	    
	    // Reset some primes we set false.
	    if(end >= 2) primes[2] = true;
	    if(end >= 3) primes[3] = true;
	    if(end >= 5) primes[5] = true;
	    if(end >= 7) primes[7] = true;
	    if(end >= 11) primes[11] = true;
	    if(end >= 13) primes[13] = true;
	    if(end >= 17) primes[17] = true;
	    if(end >= 19) primes[19] = true;
	    	    
	    for (int i=2;i<primes.length;i++) {
	        //if the number is prime,
	        //then go through all its multiples and make their values false.
	        if(primes[i]) {
	        	//Check for twin primes while filling seive
	        	if(i >= start + 2) { 
	        		if(primes[i - 2]) {
	        			seivetwins += 1;
	        			if(debugMode && seivetwins == 1)
	        				System.out.println("Twin Primes Found: (" + (i - 2) + ", " + i + ")");
	        		}
	        	}
	        	if(i > 19) {
	        		for (int j=2;i*j<primes.length;j++) {
	        			primes[i*j]=false;
	        		}
	        	}
	        }
	    }
	}
	
	public static void runEratosthenesSieve(long lowerBound, long upperBound) 
	{

	      long upperBoundSquareRoot = (long) Math.sqrt(upperBound);

	      //boolean[] isComposite = new boolean[(int)upperBound + 1];

	      BitSet isComposite = new BitSet((int)upperBound+1);
	      
	      isComposite.set(0);
	      isComposite.set(1);
	      
	      for (int m = 3 /*int m = lowerBound*/; m <= upperBoundSquareRoot; m += 2) {
	    	  
	            if (!isComposite.get(m)) {

	                if (m >= lowerBound + 2) {
	                	if(!isComposite.get(m - 2) && m % 2 == 1) {
	                		twins += 1;
	                		if(debugMode && twins == 1)
	                			System.out.println("Twin Primes Found: (" + (m - 2) + ", " + m + ")");
	                	}
	                	if(debugMode)
	                		System.out.println(m);
	                }

	                  for (int k = m * m; k <= upperBound; k += m)

	                        isComposite.set(k);

	            }

	      }

	      for (int m = (int)upperBoundSquareRoot; m <= upperBound; m++)

	            if (!isComposite.get(m))

	                 if (m >= lowerBound + 2) {
	                	 if(!isComposite.get(m - 2) && m % 2 == 1) {
		                		twins += 1;
		                		if(debugMode && twins == 1)
		                			System.out.println("Twin Primes Found: (" + (m - 2) + ", " + m + ")");
		                 }
	                 }

	}
	
	static public boolean isPrime(int n) {
	    return primes[n]; //simple, huh?
	}
}
