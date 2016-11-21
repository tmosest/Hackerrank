package Search;

import java.util.Arrays;
import java.util.Scanner;

/**
 *	Algorithms -> Search -> Hackerland Radio Transmitters
 *	Easy
 */
public class HackerlandRadioTransmitters {

	public static void main(String[] args) {
		boolean debugMode = false;
		
		Scanner in = new Scanner(System.in);
		
		int numberOfHouses = in.nextInt();
		int atenaRanage = in.nextInt();
		int[] houses = new int[numberOfHouses];
		
		for(int i = 0 ; i < numberOfHouses; i++) {
			houses[i] = in.nextInt();
		}
		
		Arrays.sort(houses);
		
		if(debugMode) 
			printArray(houses);
		
		boolean[] housesAreCovered = new boolean[numberOfHouses];
		int numberOfAtenas = 0;
		
		for(int i = 0; i < numberOfHouses; i++) {
			boolean placeAtenaHere = false;
			//Check if the house already has an radio transmitter
			if(debugMode) 
				System.out.println("Checking house: " + i + " at: " + houses[i]);
			if(!housesAreCovered[i]) {
				//Make sure we aren't looking at the last house
				if(i != numberOfHouses - 1) {
					//Check the distance for the next house
					if(houses[i + 1] - houses[i] <= atenaRanage) {
						//Then we know we could put a RT there instead of here, as long as we haven't skipped a house
						placeAtenaHere = false;
						if(i != 0) {
							for(int j = 0; j < i; j++) {
								if(!housesAreCovered[j]) {
									if(debugMode) 
										System.out.println("Previous House Uncovered " + j + " at: " + houses[j]);
									if(Math.abs(houses[i + 1] - houses[j]) > atenaRanage) {
										if(debugMode) 
											System.out.println("Previous House will be uncovered with next move" + j + " at: " + houses[j]);
										placeAtenaHere = true;
									}
									break;
								}
							} // end for j
						}
					} else {
						placeAtenaHere = true;
					}
				} else {
					//If last house isn't covered then place one there.
					placeAtenaHere = true;
				}
			}
			
			if(placeAtenaHere) {
				//System.out.println("One placed at: " + i);
				numberOfAtenas++;
				for(int j = 0; j < numberOfHouses; j++) {
					if(Math.abs(houses[j] - houses[i]) <= atenaRanage) {
						housesAreCovered[j] = true;
						if(debugMode)
							System.out.println("House "+ j +" now covered at " + houses[j]);
					}
				} // end for j
			}
		}
		
		System.out.println(numberOfAtenas);
		
		in.close();
	}

	public static void printArray(int[] array) {
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println("");
	}
}
