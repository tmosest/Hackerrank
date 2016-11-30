package WeekOfCode.Week26;

import java.util.Arrays;
import java.util.Scanner;

/**
 *	Algorithms -> Week of Code 26 -> Twins
 *	Medium
 */
public class Twins {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int start = in.nextInt();
        int end = in.nextInt();
		in.close();
        int twins = countAllTwinPrimesBetween(start, end);
        System.out.println(twins);
	}
	
	// will contain true or false values for the first 10,000 integers
	static boolean[] primes;
	public static int countAllTwinPrimesBetween(int start, int end)
	{
		primes = new boolean[end + 1];
		fillSieve();
        
		int count = 0;
        for(int i = start; i <= end - 2; i++) {
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
	    Arrays.fill(primes,true);        // assume all integers are prime.
	    primes[0]=primes[1]=false;       // we know 0 and 1 are not prime.
	    for (int i=2;i<primes.length;i++) {
	        //if the number is prime,
	        //then go through all its multiples and make their values false.
	        if(primes[i]) {
	            for (int j=2;i*j<primes.length;j++) {
	                primes[i*j]=false;
	            }
	        }
	    }
	}

	static public boolean isPrime(int n) {
	    return primes[n]; //simple, huh?
	}
}

