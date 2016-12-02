package Search;

import java.util.Scanner;
import java.util.TreeSet;

/**
 *	Algorithms -> Search -> Maximum Subarray Sum
 *	Hard
 */
public class MaximumSubarraySum {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int numCases = in.nextInt();
		
		for(int t = 0; t < numCases; t++) {
			
			int arraySize = in.nextInt();
			long mod = in.nextInt();
			
			long[] array = new long[arraySize];
			
			for(int i = 0; i < array.length; i++) {
				array[i] = in.nextLong() % mod;
			}
			
			printMaxMod(array, mod);
			
			//System.out.println(maxSum);
		}
		
		in.close();
	}
	
	private static void printMaxMod(long[] numbers, Long mod) {

        Long maxSoFar = (numbers[numbers.length-1] + numbers[numbers.length-2])%mod;
        maxSoFar = (maxSoFar > (numbers[0]%mod)) ? maxSoFar : numbers[0]%mod;
        numbers[0] %=mod;
        for (Long i = 1L; i < numbers.length; i++) {
            long currentNumber = numbers[i.intValue()]%mod;            
            maxSoFar = maxSoFar > currentNumber ? maxSoFar : currentNumber;
            numbers[i.intValue()] = (currentNumber + numbers[i.intValue()-1])%mod;
            maxSoFar = maxSoFar > numbers[i.intValue()] ? maxSoFar : numbers[i.intValue()];
        }

        if(mod.equals(maxSoFar+1) || numbers.length == 2){
            System.out.println(maxSoFar);
            return;
        }

        long previousNumber = numbers[0];
        TreeSet<Long> set = new TreeSet<>();
        set.add(previousNumber);

        for (Long i = 2L; i < numbers.length; i++) {
            Long currentNumber = numbers[i.intValue()];
            Long ceiling = set.ceiling(currentNumber);
            if(ceiling == null){
                set.add(numbers[i.intValue()-1]);            
                continue;
            }

            if(ceiling.equals(currentNumber)){
                set.remove(ceiling);
                Long greaterCeiling = set.ceiling(currentNumber);
                if(greaterCeiling == null){
                    set.add(ceiling);
                    set.add(numbers[i.intValue()-1]);            
                    continue;
                }
                set.add(ceiling);                    
                ceiling = greaterCeiling;
            }
            Long newMax = (currentNumber - ceiling + mod);
            maxSoFar = maxSoFar > newMax ? maxSoFar :newMax;
            set.add(numbers[i.intValue()-1]);            
        }

        System.out.println(maxSoFar);

    }
}
