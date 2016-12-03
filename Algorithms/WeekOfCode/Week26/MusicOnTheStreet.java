package WeekOfCode.Week26;


import java.util.Scanner;

/**
 *	Algorithms -> Week of Code 26 -> Music on the Street
 *	Hard
 */
public class MusicOnTheStreet {

	public static boolean debugMode = true;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int arraySize = in.nextInt();
		
		long[] stops = new long[arraySize];
		
		for(int i = 0; i < stops.length; i++) {
			stops[i] = in.nextLong();
		}
		
		long miles = in.nextLong();
		
		long leastTime = in.nextLong();
		
		long mostTime = in.nextLong();
		
		in.close();
		
		long startPoint = (long) Math.ceil((double) (stops[stops.length - 1] - stops[0]) / 2);
        
        if(debugMode) 
			System.out.println("startPoint: " + startPoint);
		
		boolean searchingForValidStart = true;
        
		while(searchingForValidStart) {
            int nextIndex = getNearestGreaterThanIndex(stops, startPoint);
		
            if(debugMode) 
                System.out.println("Next: " + nextIndex);
		
            long distanceToNextStop = stops[nextIndex] - startPoint;
            if(debugMode) 
                    System.out.println("distanceToNextStop: " + distanceToNextStop);
            
            if(distanceToNextStop < leastTime) {
                if(debugMode) 
                    System.out.println("Stepback:");
                startPoint--;
            } else if(distanceToNextStop > mostTime) {
                startPoint++;
            } else {
                long end = startPoint + miles;
            
                if(debugMode) 
                     System.out.println("end: " + end);
                
                long distance = distanceToNextStop;
                if(debugMode) 
                    System.out.println("distance: " + distance);
                searchingForValidStart = false; 
                for(int i = nextIndex + 1; i < stops.length; i++) {
                    long distanceBetweenStops = stops[i] - stops[i - 1];
                    distance += distanceBetweenStops;
                    if(debugMode) 
                        System.out.println("distance: " + distance);
                    if(end - stops[i] < leastTime) {
                        searchingForValidStart = true;
                    }
                    if(stops[i] > end) {
                        if(end - stops[i] < leastTime) {
                            if(debugMode) 
                                System.out.println("Stepback:");
                            startPoint--;
                        } else if(end - stops[i] > mostTime) {
                            if(debugMode) 
                                System.out.println("StepForward:");
                            startPoint++;
                        } else {
                            searchingForValidStart = false;  
                        } 
                    } 
                }
                
                if(end > stops[stops.length - 1]) {
                    long distancePastEnd = end - distance;
                
                    if(debugMode) 
                         System.out.println("distancePastEnd: " + distancePastEnd);

                    if(distancePastEnd > 0 && distancePastEnd < leastTime) {
                        if(debugMode) 
                            System.out.println("StepForward:");
                        startPoint++;
                    } else if (distancePastEnd > 0 && distancePastEnd > mostTime) {
                        if(debugMode) 
                            System.out.println("Stepback:");
                        startPoint--;
                    } else {
                        searchingForValidStart = false;   
                    }   
                }
            }
            if(debugMode) 
                        System.out.println("startPoint: " + startPoint);  
		}
		
		System.out.println(startPoint);
	}

	public static int getNearestGreaterThanIndex(long[] a, long key)
	{
		if(a.length == 1) return 0;
		
		int lo = 0;
		int hi = a.length - 1;
        while (lo <= hi) {
        	int mid = lo + (hi - lo) / 2;
        	//if(debugMode)
              //System.out.println("mid: " + mid + " key: " + key + " a[mid]: " + a[mid] + " a[mid + 1]: " + a[mid + 1]);
        	if(key >= a[mid] && key < a[mid + 1])  {
        		return mid + 1;
        	} else if(key < a[mid]) {
        		hi = mid - 1;
        	} else if(key >= a[mid + 1]) {
        		hi = mid + 1;
        	}
        }
        return 0;
	}
	
	public static int indexOf(int[] a, int key) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if      (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }
}
