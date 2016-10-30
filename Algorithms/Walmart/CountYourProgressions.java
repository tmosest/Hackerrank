package Walmart;

import java.util.Scanner;

/**
 *	Algorithms ->  WalmartLabs Codesprint (Algorithms) -> Count Your Progressions
 *	Medium
 */
public class CountYourProgressions {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int arraySize = in.nextInt();
		int[] array = new int[arraySize];
		for(int i = 0; i < arraySize; i++) {
			array[i] = in.nextInt();
		}
		in.close();
		
		int count = 1;
		
		for(int numToGrab = 1; numToGrab < arraySize; numToGrab++) {
			for(int start = 0; start < arraySize; start++) {
				System.out.print(array[start]);
				if(numToGrab > 1) {
					int i = 1;
					int groupCount = 1;
					while(start + i < arraySize) {
						if(groupCount < numToGrab) {
							System.out.print(array[start + i]);
							groupCount++;
						}
						i++;
					}
				}
				System.out.println("");
			}
		}
		
		//for(int start = 0; start < arraySize; start++) {
			//for(int end = start; end < arraySize; end++) {
				//boolean isProgression = true;
				//int i = start;
				//int k = 0;
				//while(i + k < arraySize) {
					//System.out.print(array[i + k]);
					//k++;
				//}
				//for(int i = start; ; i++) {
					//System.out.print(array[i]);
				//}
				//System.out.println("");
				//if(end - start == 0) {
					//isProgression = true;
				//} else {
					//int d = array[start + 1] - array[start];
					//System.out.println("diff: " + d);
					//for(int i = start; i < end; i++) {
						//System.out.print(array[i + 1] + " " + array[i]);
						//int d2 = array[i + 1] - array[i];
						//System.out.println("diff2: " + d2);
						//if(d2 != d) {
							//isProgression = false;
							//break;
						//}
					//}
					//System.out.println("");
				//}
				//if(isProgression) count++;
			//}
		//}
		//System.out.println(count);
	}
	
}
