package Strings;

import java.util.HashMap;
import java.util.Scanner;

/**
 *	Algorithms -> Strings -> Bear and Steady Gene
 *	Medium
 */
public class BearSteadyGene {
	
	private static int arraySize;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		arraySize = in.nextInt();
		String genome = in.next();
		in.close();
		int numGenes = calculateGenesToChange(genome);
		System.out.println(numGenes);
	}

	public static int calculateGenesToChange(String genome) {
		
		HashMap<Character, Integer> geneCounts = new HashMap<Character, Integer>();
		geneCounts.put('A', 0);
		geneCounts.put('C', 0);
		geneCounts.put('G', 0);
		geneCounts.put('T', 0);
		
		for(char gene : genome.toCharArray()) {
			int count = geneCounts.get(gene);
			geneCounts.put(gene, ++count);
		}
		
		int left = 0, right = 0, min = Integer.MAX_VALUE;
		
		while(right < arraySize - 1){
            char rc = genome.charAt(right++);
            geneCounts.put(rc, geneCounts.get(rc) - 1);
            while(isSteady(geneCounts, arraySize)){
                min = Math.min(min, right - left);
                char lc = genome.charAt(left++);
                geneCounts.put(lc, geneCounts.get(lc) + 1);
            }
        }
		
		return min;
	}
	
	private static boolean isSteady(HashMap<Character, Integer> map, int n) {
        for (Integer i : map.values()) {
        	//System.out.println("i: " + i);
            if (i > n / 4) return false;
        }
        return true;
    }
}
