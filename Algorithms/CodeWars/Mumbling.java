package CodeWars;

/**
 * Mumbling
 * @author tmosest
 */
public class Accumul {
    
    public static String accum(String s) {
    	StringBuilder sb = new StringBuilder();
    	for(int i = 0; i < s.length(); i++) {
    		char letter = s.charAt(i);
    		sb.append(Character.toUpperCase(letter));
    		for(int j = 0; j < i; j++) {
    			sb.append(Character.toLowerCase(letter));
    		}
    		if(i < s.length() - 1)
    			sb.append('-');
    	}
    	return sb.toString();
    }
}
