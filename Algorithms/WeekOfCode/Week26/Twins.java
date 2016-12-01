package WeekOfCode.Week26;

import java.util.Arrays;
import java.util.Scanner;

/**
 *	Algorithms -> Week of Code 26 -> Twins
 *	Medium
 */
public class Twins {
	static public boolean[] usedPrimes;
	static public int start;
	static public int end;
    static public boolean debugMode;
	
	public static void main(String[] args) {
        debugMode = false;
		Scanner in = new Scanner(System.in);
		start = in.nextInt();
        end = in.nextInt();
		in.close();
        int twins = countAllTwinPrimes();
        System.out.println(twins);
	}
	
	public static int countAllTwinPrimes()
	{
		if(start < 2) {
			start = 2;
		}
		usedPrimes = new boolean[end - start + 1];
		
		fillSieve();
        
		int count = 0;
        for(int i = 0; i < usedPrimes.length - 2; i++) {
            if(debugMode)
                System.out.println((i + start) + " isPrime: " + isPrime(i));
            if(isPrime(i)) {
                if(isPrime(i + 2)) {
                    count += 1;
                }
            }
        }
        return count;
	}
	
	//set up the primesieve
	static public void fillSieve() {
        boolean[] unUsedPrimes = new boolean[start];
        
	    Arrays.fill(usedPrimes, true);        // assume all integers are prime.
	    Arrays.fill(unUsedPrimes, true); 
	    
	    unUsedPrimes[0]=unUsedPrimes[1]=false;       // we know 0 and 1 are not prime.
	    
	    for (int i= 2; i< unUsedPrimes.length; i++) {
	        //if the number is prime,
	        //then go through all its multiples and make their values false.
	        if(unUsedPrimes[i]) {
                if(debugMode)
                    System.out.println("Prime: " + i);
	            for (int j = 2; i * j < unUsedPrimes.length; j++) {
	            	unUsedPrimes[i * j] = false;
	            }
	            for(int j = 0; j < usedPrimes.length; j++) {
	            	int index = start + j;
                    if(debugMode)
                        System.out.println(index + " % " + i);
	            	if(index % i == 0) {
	            		usedPrimes[j] = false;
                        if(debugMode)
                            System.out.println("Setting: " + j + " to false");
	            	}
	            }
	        }
	    }
	    
        unUsedPrimes = null;
        
	    for(int i = 0; i < usedPrimes.length - 1; i++) {
	    	if(usedPrimes[i]) {
	    		int prime = i + start;
                if(debugMode)
                    System.out.println("Prime: " + prime);
	    		for(int j = i + 1; j < usedPrimes.length; j++) {
	            	int index = start + j;
                    if(debugMode)
                        System.out.println(index + " % " + prime);
	            	if(index % prime == 0) {
	            		usedPrimes[j] = false;
                        if(debugMode)
                            System.out.println("Setting: " + j + " to false");
	            	}
	            }
	    	}
	    }
	}

	static public boolean isPrime(int n) {
	    return usedPrimes[n]; //simple, huh?
	}
}
