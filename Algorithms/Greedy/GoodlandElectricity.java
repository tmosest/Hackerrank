package Greedy;

import java.util.Scanner;

/**
 *	Algorithms ->  Greedy -> Goodland Electricity
 *	Medium
 */
public class GoodlandElectricity {
    private static boolean debugMode = true;
    
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int numberOfCities = in.nextInt();
		int lightDistance = in.nextInt();
		int lightCount = 0;
		
		int[] houses = new int[numberOfCities];
		
		for(int i = 0; i < numberOfCities; i++) {
			houses[i] = in.nextInt();
			if(houses[i] == 1) lightCount += 1; 
		}
		
		in.close();
		
		int lightsToTurnOn;
        
        if(debugMode) 
            System.out.println(2 * (lightDistance - 1) * (lightCount) + 1);
        
		if(houses.length - 2 * (lightDistance - 1) * (lightCount) + 1 > 0) {
			lightsToTurnOn = -1;
		} else {
			lightsToTurnOn = countHousesToTurnOn(houses, lightDistance);
		}
		
		System.out.println(lightsToTurnOn);
	}
	
	public static int countHousesToTurnOn(int[] houses, int distance)
	{
		int lightsToTurnOn = 0;
		int lastOnIndex = -1;
		int checkIndex = lastOnIndex + distance;
		
		while(lastOnIndex < houses.length - 1) {
            if(debugMode)
			    System.out.println("checking: " + checkIndex);
            
            if(checkIndex >= houses.length) 
                checkIndex = houses.length - 1; 
            
			if(houses[checkIndex] == 1) {
				// increment 1
				lightsToTurnOn += 1;
				// increment last on Index
				lastOnIndex = checkIndex + distance - 1;
                if(debugMode) {
                  System.out.println("lastOnIndex: " + lastOnIndex);
                  System.out.println("on: " + checkIndex);
                }
				// increment index to check
				checkIndex = lastOnIndex + distance;
			} else {
				//Loop backwards
				while(true) {
					// Drop back
					checkIndex--;
                    if(debugMode)
                        System.out.println("checking: " + checkIndex);
					//Check if fails
                    if(checkIndex < 0 || checkIndex <= lastOnIndex - distance + 1) {
						return -1;
					} else {
						if(houses[checkIndex] == 1) {
							// increment 1
							lightsToTurnOn += 1;
							// increment last on Index
							lastOnIndex = checkIndex + distance - 1;
                            if(debugMode) {
                                 System.out.println("lastOnIndex: " + lastOnIndex);
                                 System.out.println("on: " + checkIndex);
                            }
							// increment index to check
							checkIndex = lastOnIndex + distance;
							// break this while
							break;
						}
					}
				}
			}
		}
		
		return lightsToTurnOn;
	}
}
