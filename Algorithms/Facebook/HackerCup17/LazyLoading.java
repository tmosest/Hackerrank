package Facebook.HackerCup17;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class LazyLoading {

	private static boolean debugMode = false;
	private static String inFileStr =  "Facebook/HackerCup17/LazyLoadingIn.txt";
    private static String outFileStr = "Facebook/HackerCup17/LazyLoadingOut.txt";
	
	public static void main(String[] args) throws IOException
	{
		// FileReader reads text files in the default encoding.
        FileReader fileReader = 
            new FileReader(inFileStr);

        // Always wrap FileReader in BufferedReader.
        BufferedReader bufferedReader = 
            new BufferedReader(fileReader);
        
	     // Assume default encoding.
	        FileWriter fileWriter =
	            new FileWriter(outFileStr);

        // Always wrap FileWriter in BufferedWriter.
        BufferedWriter bufferedWriter =
            new BufferedWriter(fileWriter);
		
        int qs = Integer.valueOf(bufferedReader.readLine());
        
        for(int q = 1; q <= qs; q++) {
        	int numBoxes = Integer.valueOf(bufferedReader.readLine());
        	int[] boxes = new int[numBoxes];
        	for(int b = 0; b < numBoxes; b++) {
        		boxes[b] = Integer.valueOf(bufferedReader.readLine());
        	}
        	int trips = calculateNumberOfTrips(boxes);
        	bufferedWriter.write("Case #"+ q +": " + trips);
	        bufferedWriter.newLine();
        }
        
        // Always close files.
        bufferedReader.close();
        bufferedWriter.close();
	}
	
	public static int calculateNumberOfTrips(int[] boxes)
	{
		int requiredPayload = 50;
		int trips = 0;
		
		Arrays.sort(boxes);
		
		int i = -1;
		int j = boxes.length - 1;
		int boxesInTrip = 1;
		int heaviestBox = boxes[j];
		
		while(i <= j) {
			if(heaviestBox >= requiredPayload) {
				trips++;
				j--;
				if(j >= 0)
					heaviestBox = boxes[j];
				if(boxesInTrip > 1) {
					i++;
				}
				boxesInTrip = 1;
			} else {
				heaviestBox += boxes[j];
				i++;
				boxesInTrip++;
			}
		}
		
		return trips;
	}
}
