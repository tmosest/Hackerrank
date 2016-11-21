package Search;

import java.util.Arrays;
import java.util.Scanner;

/**
 *	Algorithms -> Search -> Hackerland Radio Transmitters
 *	Easy
 */
public class HackerlandRadioTransmitters {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int numberOfHouses = in.nextInt();
		int atenaRanage = in.nextInt();
		int[] houses = new int[numberOfHouses];
		
		for(int i = 0 ; i < numberOfHouses; i++) {
			houses[i] = in.nextInt();
		}
		
		Arrays.sort(houses);
		
		boolean[] housesAreCovered = new boolean[numberOfHouses];
		int numberOfAtenas = 0;
		
		for(int i = 0; i < numberOfHouses; i++) {
			boolean placeAtenaHere = false;
			//Check if the house already has an radio transmitter
			//System.out.println("Checking house: " + i);
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
									//System.out.println("Previous House Uncovered " + j);
									placeAtenaHere = true;
									break;
								}
							} // end for j
						}
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
						//System.out.println("House "+ j +" now covered");
					}
				} // end for j
			}
		}
		
		System.out.println(numberOfAtenas);
		
		in.close();
	}

	
}
