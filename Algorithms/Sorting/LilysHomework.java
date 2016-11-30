package Sorting;

import java.util.Arrays;
import java.util.Scanner;

/**
 *	Algorithms -> Sorting -> Lily's Homework
 *	Advanced
 */
public class LilysHomework {
	
	public static boolean[] used;
	public static Pair[] sortedCycleTracker, reversedSortedCycleTracker;
	
	public static void main(String[] args) {
        boolean debugMode = true;

		Scanner in = new Scanner(System.in);
		
		int arraySize = in.nextInt();
		
		int[] array = new int[arraySize];
		int[] sortedArray = new int[arraySize];
		int[] reversedArray = new int[arraySize];
		
		used = new boolean[arraySize];
		sortedCycleTracker = new Pair[arraySize];
		reversedSortedCycleTracker = new Pair[arraySize];

		for(int i = 0; i < arraySize; i++) {
			array[i] = in.nextInt();
			sortedArray[i] = array[i];
			sortedCycleTracker[i] = new Pair(array[i], i);
			reversedSortedCycleTracker[i] = new Pair(array[i], i);
			used[i] = false;
		}
		
		in.close();
		
		Arrays.sort(sortedCycleTracker);
		
		for(int i = 0; i < arraySize; i++) {
			reversedSortedCycleTracker[arraySize - 1 - i] = sortedCycleTracker[i];
		}
		
		int swaps = 0;
		int reversedSwaps = 0;
		
		for(int i = 0; i < arraySize; i++) {
			if (!used[i]) {
	            ++reversedSwaps;
	            goReversedSortedCycleTracker(i);
	        }
		}
		
		for(int i = 0; i < arraySize; i++) {
			used[i] = false;
		}
		
		for(int i = 0; i < arraySize; i++) {
			if (!used[i]) {
	            ++swaps;
	            goSortedCycleTracker(i);
	        }
		}
		
		if(debugMode) {
            System.out.println("swap: " + swaps);
            System.out.println("reversedSwaps: " + reversedSwaps);
        }
		
		int minSwaps = Math.min(swaps, reversedSwaps);
		
		System.out.println(minSwaps);
	}
	
	static void goSortedCycleTracker(int v) {
	    if (used[v]) return;
	    used[v] = true;
	    goSortedCycleTracker((int) sortedCycleTracker[v].second);
	}


	static void goReversedSortedCycleTracker(int v) {
	    if (used[v]) return;
	    used[v] = true;
	    goReversedSortedCycleTracker((int) reversedSortedCycleTracker[v].second);
	}
	
	// start Pair
	private static class Pair<FIRST, SECOND> implements Comparable<Pair<FIRST, SECOND>> 
	{

	    public final FIRST first;
	    public final SECOND second;

	    private Pair(FIRST first, SECOND second) {
	        this.first = first;
	        this.second = second;
	    }

	    public static <FIRST, SECOND> Pair<FIRST, SECOND> of(FIRST first,
	            SECOND second) {
	        return new Pair<FIRST, SECOND>(first, second);
	    }

	    @Override
	    public int compareTo(Pair<FIRST, SECOND> o) {
	        int cmp = compare(first, o.first);
	        return cmp == 0 ? compare(second, o.second) : cmp;
	    }

	    // todo move this to a helper class.
	    private static int compare(Object o1, Object o2) {
	        return o1 == null ? o2 == null ? 0 : -1 : o2 == null ? +1
	                : ((Comparable) o1).compareTo(o2);
	    }

	    @Override
	    public int hashCode() {
	        return 31 * hashcode(first) + hashcode(second);
	    }

	    // todo move this to a helper class.
	    private static int hashcode(Object o) {
	        return o == null ? 0 : o.hashCode();
	    }

	    @Override
	    public boolean equals(Object obj) {
	        if (!(obj instanceof Pair))
	            return false;
	        if (this == obj)
	            return true;
	        return equal(first, ((Pair) obj).first)
	                && equal(second, ((Pair) obj).second);
	    }

	    // todo move this to a helper class.
	    private boolean equal(Object o1, Object o2) {
	        return o1 == null ? o2 == null : (o1 == o2 || o1.equals(o2));
	    }

	    @Override
	    public String toString() {
	        return "(" + first + ", " + second + ')';
	    }
	}
	// end pair
}
