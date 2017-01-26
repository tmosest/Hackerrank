package CodeWars;
/**
 * Street Fighter 2 - Character Selection
 * @author tmosest
 */
public class Solution {
	public static String[] streetFighterSelection(String[][] fighters, int[] position, String[] moves){
	    String[] characters = new String[moves.length];
	    
	    int[] currentPosition = new int[] {0 , 0};
	    
	    for(int i = 0; i < moves.length; i++) {
	    	switch(moves[i]) {
	    		case "up":
	    			if(currentPosition[0] != 0) {
	    				currentPosition[0]--;
	    			}
	    			break;
	    		case "down":
	    			if(currentPosition[0] != 1) {
	    				currentPosition[0]++;
	    			}
	    			break;
	    		case "left":
	    			if(currentPosition[1] != 0) {
	    				currentPosition[1]--;
	    			} else {
	    				currentPosition[1] = fighters[0].length - 1;
	    			}
	    			break;
	    		case "right":
	    			if(currentPosition[1] != fighters[0].length - 1) {
	    				currentPosition[1]++;
	    			} else {
	    				currentPosition[1] = 0;
	    			}
	    			break;
	    	} // end switch
	    	characters[i] = fighters[currentPosition[0]][currentPosition[1]];
	    }
	    return characters;
	}
}