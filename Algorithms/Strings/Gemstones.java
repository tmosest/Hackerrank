package Strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 *	Algorithms -> Strings -> Gemstones
 *	Easy
 */
public class Gemstones {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int numGems = in.nextInt();
		String[] gems = new String[numGems];
		for(int i = 0; i < numGems; i++) {
			gems[i] = in.next();
		}
		in.close();
		int numOFGemElements  = calculateTheNumberOFGemElements(gems);
		System.out.println(numOFGemElements);
	}
	
	public static int calculateTheNumberOFGemElements(String[] gems) {
		int numOFGemElements = 0;
		HashMap<Character, Integer> hmap = new HashMap<Character, Integer>();
		for(int gem_i = 0; gem_i < gems.length; gem_i++) {
			char[] gemArray = gems[gem_i].toCharArray();
			Arrays.sort(gemArray);
			char testRock = '1';
			for(int rock_j = 0; rock_j < gemArray.length; rock_j++) {
				char rock = gemArray[rock_j];
				if(rock != testRock) {
					testRock = rock;
					int rockCount = hmap.get(rock) != null ? hmap.get(rock) : 0;
					hmap.put(rock, ++rockCount);
				}
			}
		}
		for (Character rock : hmap.keySet()) {
			int rockCount = hmap.get(rock);
			//System.out.println("rock: " + rock + " count: " + rockCount);
			if(rockCount >= gems.length) numOFGemElements++;
		}
		return numOFGemElements;
	}
}
