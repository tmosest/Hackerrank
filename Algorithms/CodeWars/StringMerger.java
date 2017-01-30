package CodeWars;
/**
 * Merged String Checker
 * @author tmosest
 */
public class StringMerger {

	private static final boolean debugMode = true;
	
    public static boolean isMerge(String s, String part1, String part2) {
    	
    	if(debugMode) 
    		System.out.println("s: " + s);
    	
    	if(part1.length() + part2.length() < s.length())
    		return false;
    	
    	int sIndex = s.length() - 1, 
    			part1Index = part1.length() - 1, part2Index = part2.length() - 1, 
    			part1Last = part1.length(), part2Last = part2.length();
    	
    	char sLetter, part1Letter, part2Letter;
    	
    	while(part1Last > 0 && part2Last > 0) {
    		sLetter = s.charAt(sIndex);
    		if(part1Index > 0) {
	    		part1Letter = part1.charAt(part1Index);
	    		if(debugMode)
	    			System.out.println("sLetter: " + sLetter + " part1Letter: " + part1Letter);
	    		if(part1Letter == sLetter) {
	    			part1Last = part1Index;
	    			sIndex--;
	    			part1Index--;
	    			part2Index = part2Last - 1;
	    		}
	    	}
    		if(part2Index > 0) {
	    		part2Letter = part2.charAt(part2Index);
	    		if(debugMode)
	    			System.out.println("sLetter: " + sLetter + " part2Letter: " + part2Letter);
	    		if(part2Letter == sLetter) {
	    			part2Last = part2Index;
	    			sIndex--;
	    			part2Index--;
	    			part1Index = part1Last - 1;
	    		}
	    	}
	    	if(sIndex == 0)
	    		return true;
    	}
    	
        return false;
    }

}